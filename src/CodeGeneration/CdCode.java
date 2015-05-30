/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

import ClassDiagram.Attributes;
import ClassDiagram.CandidateClass;
import ClassDiagram.ClassIdentifier;
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
public class CdCode implements FileHandling {
    
    String arrayRegex="(\\w+)([[]\\d*\\[]])";
    String librariesRegex="\\#include<.*>";
    private List<CandidateClass> candidateClassList=new ArrayList<>();
    private List<Attributes> attrList=new ArrayList<Attributes>();
    private List<String> methodList=new ArrayList<String>();
    private CandidateClass candidateClass=null;
    ClassIdentifier classIdentifier=null;
    List<String>librariesList=new ArrayList<String>();
    String outputPath;
    String inputPath;

    
    @Override
     public void setOutputFilePath(String path)
     {
         outputPath=path;
     }
    @Override
  public void setInputFilepath(String path)
  {
      inputPath=path;
  }
    
    public void getLibraries()
    {
        
        librariesList.add("#include<iostream>");
        librariesList.add("#include<cstring>");
       librariesList.add("using namespace std;");
       
       for (int index=0;index<librariesList.size();index++)
       {
           writeToFile(librariesList.get(index));
       }
        
    } // func ends
    public void getCandidateClassList ()
    {
        classIdentifier=classIdentifier.getClassIdentifierInstance();
        candidateClassList=classIdentifier.getCandidateClassList();
        doubleCheck();
        //classIdentifier.printCandidateClasses();
    }
    @Override
    public void readFromFile()
    {
        String line="";
        Pattern librariesPattern=Pattern.compile(librariesRegex);
        Matcher libraryMatcher;
        
        try
        {
            File file=new File(inputPath);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			
			
			while ((line=breader.readLine())!=null)
			{
                            libraryMatcher=librariesPattern.matcher(line);
                            
                            if (libraryMatcher.find())
                                ;
                        }
        }
        catch (Exception e)
        {
            
        }
    }// func ends
    @Override
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
    
    public void assignGlobalVariables()
    {
        
    }
    public void generateCodeFromCd()
   {
        getLibraries();
        
        for (int d=0;d<candidateClassList.size();d++)
        {
            candidateClass=candidateClassList.get(d);
            
             if (candidateClass.getAttributeModifier().equals("Public"))
            {
                writeToFile("class "+candidateClass.getClassName()+" {");
                writeToFile("public:");
                for (int x=0;x<candidateClass.getAttributesList().size();x++)
                writeToFile(candidateClass.getAttributesList().get(x).getType()+" "+candidateClass.getAttributesList().get(x).getName()+";");
            
            generateAccessors(candidateClass.getAttributesList());
            generateMutators(candidateClass.getAttributesList());
            
            for (int y=0;y<candidateClass.getMethodList().size();y++)
            {
              writeToFile(candidateClass.getMethodList().get(y));  
              
               
            } // for ends
            writeToFile("};");
            }
            
        
        } // for ends
        
        
        for (int index=0;index<candidateClassList.size();index++)
        {
            if (candidateClassList.get(index).getAttributeModifier().equals("private"))
            {
            candidateClass=candidateClassList.get(index);
            writeToFile("class "+candidateClass.getClassName()+" {");
            if (candidateClass.getAttributeModifier().equals("private"))
            {
            writeToFile("private:");
            
            for (int x=0;x<candidateClass.getAttributesList().size();x++)
            {
               
                writeToFile(candidateClass.getAttributesList().get(x).getType()+" "+candidateClass.getAttributesList().get(x).getName()+";");
                
            } // for ends
        } // private condition ends
            writeToFile("public: ");
            
            if (candidateClass.getAttributeModifier().equals("Public"))
            {
                for (int x=0;x<candidateClass.getAttributesList().size();x++)
                writeToFile(candidateClass.getAttributesList().get(x).getType()+" "+candidateClass.getAttributesList().get(x).getName()+";");
            }
            generateAccessors(candidateClass.getAttributesList());
            generateMutators(candidateClass.getAttributesList());
            
            for (int y=0;y<candidateClass.getMethodList().size();y++)
            {
              writeToFile(candidateClass.getMethodList().get(y));  
              
               
            } // for ends
            
            writeToFile("};");
            
        }// if for low priority classes ends
        } // for ends
   
    }
    
    String twoNumberString="departmnet";

 
public void doubleCheck()
    {int yo;
        for (int x=0;x<candidateClassList.size();x++)
        {
           yo= numberTwo(candidateClassList.get(x).getClassName());
            if (yo==1)
                candidateClassList.get(x).setAttributeModifier("Public");
        }
    }
    
    public int numberTwo(String name)
    {
        if (name.contains(twoNumberString))
            return 1;
        return 0;
    }
    public void generateAccessors(List<Attributes>attributesList)
    {
        String tokens[];
        boolean flag=true;
        Pattern arrayPattern= Pattern.compile(arrayRegex);
        Matcher arrayMatcher;
        for (int index=0;index<attributesList.size();index++)
        {
            for (int in=0;in<candidateClassList.size();in++)
            {
                if (attributesList.get(index).getType().equals(candidateClassList.get(in).getClassName()))
                    flag=false;
            }
            if (flag)
            {
            arrayMatcher=arrayPattern.matcher(attributesList.get(index).getName());
          
            if (arrayMatcher.find())
            {
                //System.out.println(attributesList.get(index).getName());
                tokens=attributesList.get(index).getName().split("\\[");
                //for (int hh=0;hh<tokens.length;hh++)
                   // System.out.println(tokens[0]);
                if (attributesList.get(index).getType().equals("char"))
                {
                    writeToFile(attributesList.get(index).getType().replace("*", "")+" "+"*get"+tokens[0].replace("*", "")+"()");
                }
                else
                {
                writeToFile(attributesList.get(index).getType().replace("*", "")+" "+"get"+tokens[0].replace("*", "")+"()");
                }
                writeToFile("{");
            writeToFile("return "+tokens[0].replace("*", "")+";");
            writeToFile("}");
            }
            else
            {
                
            writeToFile(attributesList.get(index).getType().replace("*", "")+" "+"get"+attributesList.get(index).getName().replace("*", "")+"()");
            
            writeToFile("{");
            writeToFile("return "+attributesList.get(index).getName().replace("*", "")+";");
            writeToFile("}");
            }
        } // non primitive data type check ends
            flag=true;
        } // for ends
    } // func ends
    
    public void generateMutators(List<Attributes>attributesList)
    {
        String tokens[];
        boolean flag=true;
        Pattern arrayPattern= Pattern.compile(arrayRegex);
        Matcher arrayMatcher;
        
        for (int index=0;index<attributesList.size();index++)
        {
            for (int in=0;in<candidateClassList.size();in++)
            {
                if (attributesList.get(index).getType().equals(candidateClassList.get(in).getClassName()))
                    flag=false;
            }
            if (flag)
            {
                arrayMatcher=arrayPattern.matcher(attributesList.get(index).getName());
        if (arrayMatcher.find())
            {
                //System.out.println(attributesList.get(index).getName());
                tokens=attributesList.get(index).getName().split("\\[");
                if (attributesList.get(index).getType().equals("char"))
                {
                    writeToFile("void set"+tokens[0].replace("*", "")+"("+attributesList.get(index).getType().replace("*", "")+" var[])");
                }
                else
                {
                writeToFile("void set"+tokens[0].replace("*", "")+"("+attributesList.get(index).getType().replace("*", "")+" var)");
                }
                writeToFile("{");
                if (attributesList.get(index).getType().equals("char"))
                {
                    writeToFile("strcpy("+tokens[0].replace("*", "")+", var );");
                }   
               else
                { writeToFile("this->"+tokens[0].replace("*", "")+"= var;");
                
                }
                writeToFile("}");
            }
        else
        {
        writeToFile("void set"+attributesList.get(index).getName().replace("*", "")+"("+attributesList.get(index).getType().replace("*", "")+" var)");
        writeToFile("{");
        writeToFile("this->"+attributesList.get(index).getName().replace("*", "")+"= var;");
        writeToFile("}");
        }
        
            
        
        
        } // non primitve data tyep check ends
            flag=true;
           // writeToFile("void set"+attributes)
        }
    } // func ends
    
   
} // class ends
