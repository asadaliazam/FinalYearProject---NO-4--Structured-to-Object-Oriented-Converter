/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataDictionary;

import ClassDiagram.Attributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Umair Khan
 */
public class regex {
    
    private String structNamePattern="(struct\\s+)(\\w+).*";
    private String variablePattern="(\\w+[*]*\\s*\\[*]*\\w+d*s*([[]\\d+\\[]])*[;])"; // made it a group in order to find multiple variable declarations in single line
    private String semicolonBracket="[}]\\s*[;]";
    private String wrongStruct="struct\\s+\\w+\\s+\\w+";
    private String variablePattern2="\\w+\\s+\\w+\\s*([,]\\s*\\w+\\s*)+";
     String myLibMgmtFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Assignments\\Project#01(Library Management)\\Project_final\\1st.cpp";
    String sEngineFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Final project\\Final\\Ranking\\URK\\rough\\dcc.cpp";
    String studmgmtFile="C:\\Users\\Umair Khan\\Desktop\\STUDMGMT.cpp";
    Pattern r=Pattern.compile(structNamePattern);
    Pattern varPattern=Pattern.compile(variablePattern);
    Pattern varPattern2=Pattern.compile(variablePattern2);
    Pattern semicolon=Pattern.compile(semicolonBracket);
    Pattern wS=Pattern.compile(wrongStruct);
    private String outputFilePath;
    private List<Structs> structsList=new ArrayList<Structs>();
   private List<Attributes>attributesList;
   public regex(String outputPath)
   {
       outputFilePath=outputPath;
   }
    public void extractstructs(String codeFile) throws Exception
    {
        File file=new File(codeFile);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
                        
			String line="";
			
                       while ((line=breader.readLine())!=null)
                       {
                           
                           Matcher m=r.matcher(line);
                            if (m.find()) // if struct found
                            {
                                
                                Matcher ws=wS.matcher(line);
                                if (!ws.find())
                                {
                                Structs struct=new Structs(m.group(2));
                            attributesList=new ArrayList<Attributes>();
                                // seperate out the struct name
                           // System.out.println(m.group(2));
                            //line=breader.readLine();
                                Matcher varMatcher=varPattern.matcher(m.group(0));
                                
                                
                                if (varMatcher.find()) // if variable found
                                {
                                    
                                    doTransform(varMatcher.group(0));
                                    //System.out.println(varMatcher.group(0));
                                    
                                }
                                
                                
                                
                                
                               Matcher semicolonmatcher=semicolon.matcher(line);
                               line=breader.readLine();
                                while (!semicolonmatcher.find())
                                {
                                    varMatcher=varPattern.matcher(line);
                                    Matcher varMatcher2=varPattern2.matcher(line);
                                    if (varMatcher.find())
                                    {
                                        doTransform(varMatcher.group(0));
                                        //System.out.println(varMatcher.group(0));
                                    }
                                    else if (varMatcher2.find())
                                {
                                    doTransform2(varMatcher2.group(0));
                                   // System.out.println(varMatcher2.group(0));
                                }
                                    line=breader.readLine();
                                    semicolonmatcher=semicolon.matcher(line);
                                }
                                
                            struct.setAttributesList(attributesList);
                            structsList.add(struct);
                            }
                       }/////
                       } // while ends
        
    } // func ends
    
    public void doTransform(String variable)
    {
        String tokens[]=variable.split("\\;");
        if (tokens.length>1) // if multiple variables in same line
        {
            for (int index=0;index<tokens.length;index++)
            {
                
                String tokens2[]=tokens[index].trim().split(" "); // seperating variable name and type
                
                Attributes attributes=new Attributes(tokens2[1].replace(";", ""),tokens2[0].replace(";", ""));
                //System.out.println(tokens2[0]+" "+tokens2[1]);
                attributesList.add(attributes);
            }
        }
        else
        {
            if (variable.contains("*"))
            {
                String tok1=variable.replace("*", " ");
                String tok2[]=tok1.split("\\s+");
                variable=tok2[0].trim().concat(" *"+tok2[1].trim());
            }
            
            String tokens3[]=variable.split("\\s+");
            
            
            
            Attributes attributes=new Attributes(tokens3[1].replace(";", ""),tokens3[0].replace(";", ""));
            //System.out.println(tokens3[0]+" "+tokens3[1]);
            attributesList.add(attributes);
        }
        
    } // func ends
    
    public void doTransform2(String variable)
    {
        String tokens[]=variable.split("\\,");
        String tokens2[]=tokens[0].split(" ");
        Attributes attribute=new Attributes(tokens2[1],tokens2[0]);
        attributesList.add(attribute);
        
        for (int x=1;x<tokens.length;x++)
        {
            attribute=new Attributes(tokens[x],tokens2[0]);
            attributesList.add(attribute);
        }
    } // func ends
    
    public void displayDD()
    {
        List<Attributes>attrList;
        Attributes attr;
        for (int index=0;index<structsList.size();index++)
        {
            System.out.println("struct: "+structsList.get(index).getName());
            attrList=structsList.get(index).getAttributesList();
            for (int k=0;k<attrList.size();k++)
            {
                attr=attrList.get(k);
                System.out.println(attr.getType()+" "+attr.getName());
                
            } // inner for ends
            
        } // for ends
    } // func ends
    
   public void writeDD() throws Exception
   {
       File file=new File(outputFilePath+"\\autodd.txt");
			FileWriter fwriter=new FileWriter(file,true);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
                        
                        //bwriter.write("---------------------------------");
                        
                        for (int index=0;index<structsList.size();index++)
                        {
                            bwriter.write(structsList.get(index).getName()+":");
                           // bwriter.newLine();
                            for (int k=0;k<structsList.get(index).getAttributesList().size();k++)
                            {
                                
                            Attributes attr=structsList.get(index).getAttributesList().get(k);
                            if (!(k==structsList.get(index).getAttributesList().size()-1))
                            bwriter.write(attr.getName()+"+");
                            else
                            bwriter.write(attr.getName());    
                            
                            
                            } //  for ends
                            bwriter.newLine();
                            
                            for (int k=0;k<structsList.get(index).getAttributesList().size();k++)
                            {
                                 Attributes attr=structsList.get(index).getAttributesList().get(k);
                                 bwriter.write(attr.getName()+":"+attr.getType());
                                 bwriter.newLine();
                            } // for ends
                            
                            
                        } // outer for ends
                        bwriter.close();
                        fwriter.close();
   } // func ends
   
} // class ends
