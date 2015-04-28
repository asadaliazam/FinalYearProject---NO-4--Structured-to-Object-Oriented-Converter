/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

import ClassDiagram.CandidateClass;
import ClassDiagram.ClassIdentifier;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Umair Khan
 */
public class GlobalVariableDetector implements FileHandling {
    
   // String myLibMgmtFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Assignments\\Project#01(Library Management)\\Project_final\\1st.cpp";
 // String gameFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Assignments\\project 2\\Phase 2\\str.cpp";
    private static GlobalVariableDetector globalVariableDetector=null;
  String fd="(\\w+\\s+\\w+)\\s*[(](.*)[)]";
  String variableDeclarationRegex="\\w+\\s+\\w+([[]\\d*\\w*\\[]])*;";
  List<Character>chars=new ArrayList<Character>();
  ClassIdentifier classIdentifier=null;
  CandidateClass candidateClass=null;
  List<CandidateClass> candidateClassList=new ArrayList<CandidateClass>();
  Map< String, List<String> > dataElementsTable = new HashMap<  >();
  private List<String> globalVariablesList=new ArrayList<String>();
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
  
  
  public static GlobalVariableDetector getGlobalVariableDetectorInstance ()
  {
      if (globalVariableDetector==null)
          globalVariableDetector=(globalVariableDetector=new GlobalVariableDetector());
          return globalVariableDetector;
      
  }

    public List<String> getGlobalVariablesList() {
        return globalVariablesList;
    }
  
    public void addToClassDiagram()
    {
        classIdentifier=classIdentifier.getClassIdentifierInstance();
        
        dataElementsTable=classIdentifier.getDataElementsTable();
        
        {
        
        
        candidateClassList=classIdentifier.getCandidateClassList();
        String tokens[];
        for (int index=0;index<globalVariablesList.size();index++)
        {
            tokens=globalVariablesList.get(index).split("\\s+");
            
            if (!dataElementsTable.containsKey(tokens[0]))
            {
                for (int x=0;x<candidateClassList.size();x++)
                {
                    candidateClassList.get(x).addAttribute(globalVariablesList.get(index),0);
                }
            }
            else
            {
            for (int ind=0;ind<candidateClassList.size();ind++)
            {
                if (tokens[0].equals(candidateClassList.get(ind).getClassName()))
                {
                    //System.out.println("yes");
                    candidateClassList.get(ind).addAttribute(globalVariablesList.get(index),1);
                    
                }                    

                
            } // for ends
        }
        } // for ends
        
        }
        
        classIdentifier.setCandidateClassList(candidateClassList);
        classIdentifier.setClassIdentifier(classIdentifier);
        
    } // func ends
    
  public String charToString(List<Character>charList)
  {
      StringBuilder result = new StringBuilder(charList.size());
for (Character c : charList) {
  result.append(c);
}
String output = result.toString();
return output;
  } // func ends
  
    @Override
    public void writeToFile(String line)
    {
        
    }
    public void readFromFile() 
    {
        try{
            File file=new File(inputPath);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
                        
        FileInputStream fis = new FileInputStream(inputPath);
        char current;
        //Pattern fdPattern=Pattern.compile(fd);
         Pattern variableDeclarationPattern=Pattern.compile(variableDeclarationRegex);
         
         Matcher variableDeclarationMatcher;
        //Matcher variableDeclarationMatcher=variableDeclarationPattern.matcher(line);
        int ob=0; int cb=0;
        String line="";
        String temp;
        line=breader.readLine();
        while (fis.available() > 0) {
            current = (char) fis.read();
            //System.out.print(current);
            if (current=='{')
            { ob++;
            //System.out.println("incmented;;;;;;");
            }
            else if (current=='}') // 
            {  cb++;
             if (ob-cb==0) // { and } are equal
             
             { //System.out.println("---------->   out of functions") ;//doMatch
            
             while (current!='{' && fis.available()>0)
             {current = (char) fis.read();
                 if (current=='\n')
                    if ((line=breader.readLine())!=null)
                    {//System.out.println(line);
                    variableDeclarationMatcher=variableDeclarationPattern.matcher(line);
                    if (variableDeclarationMatcher.find())
                    {  //System.out.println("3333333333333333333333333333 above"+variableDeclarationMatcher.group());
                    globalVariablesList.add(variableDeclarationMatcher.group().trim().replace(";", ""));
                    
                    }
                    }
             }
             ob++;
            /* for (int x=0;current!='\n';x++)//while (current!='\n')
             { current = (char) fis.read();
            
             if (current!='\n')
             chars.add(current);
             }*/
             //temp=charToString(chars);
             /*
             match temp with regex here (if variable is declared after '}')
             */
            // line=breader.readLine();
             //while (current!='{')
             {
                // current = (char) fis.read();
             } // while ends
            } // ob-cb condition ends
             
            }
        else  if (current=='\n')
           {
               if ((line=breader.readLine())!=null)
               {//current = (char) fis.read();
                  // System.out.println(line);
               }
           }
            //System.out.println("next lie-----------");
                
           // Matcher fdMatcher=fdPattern.matcher(Character.toString(current));
           // if (fdMatcher.find())
            
            
        }
        for (int x=0;x<globalVariablesList.size();x++)
        {
            //System.out.println(globalVariablesList.get(x));
        }
    fis.close();
    
        } // try ends
        catch (IOException e)
        {
            
        }
        
        
    } //func ends
} // class ends
