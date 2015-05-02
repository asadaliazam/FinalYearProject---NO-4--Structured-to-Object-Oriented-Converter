/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Umair Khan
 */
public class MainMethodHandler implements FileHandling {
    
    private String mainMethodRegex="void\\s+main";
    private String equaltoOperatorRegex="(.*)[=](.*)[;]";
   // private String dotOperatorregex="(\\w+([[]\\d*\\w*\\[]])*)\\.(w+([[]\\d*\\w*\\[]])*)";
    private String dotOperatorregex="(.*)[.](.*)";
    private String strcpyregex="strcpy[(](.*)[)][;]";
    private String setString="set";
    private String getString="get";
    boolean counter=true;
    
    private List<String> globalvariablesList=new ArrayList<String>();
    private GlobalVariableDetector gvd=null;
    private List<String>gvList=new ArrayList<String>();
    String outputPath;
    String inputPath;

    
     public void setOutputFilePath(String path)
     {
         outputPath=path;
     }
  public void setInputFilepath(String path)
  {
      inputPath=path;
  }
    public void getAndWriteGlobalVariables()
    {
        
        gvd=gvd.getGlobalVariableDetectorInstance();
        gvd.readFromFile();
        gvList=gvd.getGlobalVariablesList();
        
        for (int ind=0;ind<gvList.size();ind++)
            writeToFile(gvList.get(ind));
        
    } // func ends
    
    @ Override
    public void writeToFile(String line)
    {
        try
        {
        File file=new File(outputPath+"\\"+oocFile);
	FileWriter fwriter=new FileWriter(file,true);
	BufferedWriter bwriter=new BufferedWriter(fwriter);
        
        bwriter.newLine();
        bwriter.write(line);
        
        
        
        
        
	bwriter.close();
	fwriter.close();
        
        } // try ends
        catch (Exception e)
        {
            System.out.println("Error occured!");
        }
    } // func ends
    
    @Override
    public void readFromFile() 
    {
        Pattern mainMethodPattern=Pattern.compile(mainMethodRegex);
        Matcher mainMethodMatcher;
        
        int ob=0;int cb=0;
        String tokens[];
        try
        {
        File file=new File(inputPath);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
                        String line="";
			
                        FileInputStream fis = new FileInputStream(inputPath);
                         char current;
		         current = (char) fis.read();
		
			 
			while ((line=breader.readLine())!=null && fis.available()>0)
                        {
                            while (current!='\n')
                                current = (char) fis.read();
                            current = (char) fis.read();
                            
                        mainMethodMatcher=mainMethodPattern.matcher(line);
                        
                        if (mainMethodMatcher.find())
                        {
                            writeToFile(line);
                            
                            while (current!='{')
                            {
                                if (current=='\n')
                                    line=breader.readLine();
                               current = (char) fis.read();
                            }
                            ob++;
                            
                            
                            while (ob-cb!=0) // condition for iterating inside the main method
                            {
                                current = (char) fis.read();
                                if (current=='{')
                                    ob++;
                                else if (current=='}')
                                    cb++;
                                else if (current=='\n')
                                {
                                    line=breader.readLine();
                                    //System.out.println(line);
                                    //writeToFile(line);
                                    tokens=line.split(";");
                                    if (tokens.length>1)
                                    {for (int index=0;index<tokens.length;index++)
                                        if (index!=tokens.length-1)
                                           detectAssignments(tokens[index]+";");
                                    else
                                        detectAssignments(tokens[index]+";");
                                    
                                    
                                    }
                                    else
                                     detectAssignments(line);   
                                
                                }
                               // System.out.print(current);
                            } // while ends
                            writeToFile(Character.toString(current));
                        } // main method finder if ends
                          
                        }
    }// try ends
        catch (IOException e)
    {
        ;
    }
    } //func ends
    
    public void detectAssignments(String line)
    {
       // if (counter)
           // getAndWriteGlobalVariables();
      //  counter=false;
        Pattern strcpyPattern=Pattern.compile(strcpyregex);
        Matcher strcpyMatcher=strcpyPattern.matcher(line);
        
        boolean leftFlag;
        boolean rightFlag;
        boolean strcpyFlag;
        Pattern equaltoOperatorPattern=Pattern.compile(equaltoOperatorRegex);    
        Matcher equaltoOperatorMatcher=equaltoOperatorPattern.matcher(line);
        
        if (equaltoOperatorMatcher.find())
        {
          String tokens[]=equaltoOperatorMatcher.group().split(";");
          for (int index=0;index<tokens.length;index++)
          {
              equaltoOperatorMatcher=equaltoOperatorPattern.matcher(tokens[index]+";");
              if (equaltoOperatorMatcher.find())
              {
           // System.out.println(equaltoOperatorMatcher.group(0)); 
            
            leftFlag=detectDotOperator(equaltoOperatorMatcher.group(1)); // argument is left hand side of equality
            rightFlag=detectDotOperator(equaltoOperatorMatcher.group(2));
            if (leftFlag)
           
            { //System.out.println("need setter for above");
            generateSetter(equaltoOperatorMatcher.group().trim());
            
            }
            
            else if (rightFlag)  
                    {
                      
                    System.out.println("need getter for this");
                    
                    }
            else
                writeToFile(line);
              }
              else
                ; // writeToFile(line);
          } // for ends
          
        } // if ends
        else if (strcpyMatcher.find())
        {
            //System.out.println(strcpyMatcher.group(1));
            strcpyFlag=detectDotOperator(strcpyMatcher.group(1));
            if (strcpyFlag)
                generateSetter(strcpyMatcher.group(1).replace(",", "=").trim());
        }
            
        else
        writeToFile(line);
    } // func ends

    public boolean detectDotOperator(String var)
    {
        Pattern dotOperatorPattern=Pattern.compile(dotOperatorregex);
        Matcher dotOperatorMatcher=dotOperatorPattern.matcher(var);
        
        if (dotOperatorMatcher.find())
        {
            //System.out.println("its dot operator");
            return true;
        }
        return false;
    } // func ends
    
    public void generateSetter(String var)
    {
        //System.out.println(var);
        String tokens[]=var.replace(";", "").split("=");
       String dotTokens[]=tokens[0].split("\\.");
       //System.out.println(dotTokens[0]);
       if (dotTokens.length==2)
       {String concatSet=setString.concat(dotTokens[1]);
        
       String leftSide=dotTokens[0].concat("."+concatSet);
       
       String wholeExp=leftSide.concat("("+tokens[1]+")"+";");
       //System.out.println(wholeExp);
       writeToFile(wholeExp);
       }
       else
       {
           writeToFile(var);
       }
       
         //System.out.println(wholeExp);
        
    } // func ends
    
} // class ends 
