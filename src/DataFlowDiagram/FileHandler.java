/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFlowDiagram;

import ClassDiagram.CandidateClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class FileHandler {
    private StringIdentifier patternMatcher=new StringIdentifier();
    private String inputFile="C:\\Users\\Umair Khan\\Desktop\\calculator\\uk.cpp";
    private String outputFile="\\log.txt";
    private String nounsAndVerbsOutputFile="C:\\Users\\Umair Khan\\Desktop\\nounPhrasing.txt";
   private  String projectInputFile="D:\\Fast-NUCES\\1st Semester\\ITC\\ITC\\Term Project Main\\iCooperate final\\iCooperate\\fh final.cpp";
   private String lmsFile="C:\\Users\\Umair Khan\\Desktop\\Library Management System\\lms.cpp";
   private String alarmCodeFile="C:\\Users\\Umair Khan\\Desktop\\Alarm System\\uk.cpp";
   private String alarmDfdFile="C:\\Users\\Umair Khan\\Desktop\\alarmd.txt";
   private String libDfdFile="C:\\Users\\Umair Khan\\Desktop\\dd.txt";
   String autodd="\\autodd.txt";
   String studmgmtFile="C:\\Users\\Umair Khan\\Desktop\\STUDMGMT.cpp";
   String studDfdFile="C:\\Users\\Umair Khan\\Desktop\\sdd.txt";
   String sEngineFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Final project\\Final\\Ranking\\URK\\rough\\dcc.cpp";
   String myLibMgmtFile="C:\\Users\\Asad\\Desktop\\1st.cpp";
  String gameFile="C:\\Users\\Umair Khan\\Desktop\\str.cpp";
   private int typeIndicator;
   // private DataDictionaryOpr dataDictionaryOpr=new DataDictionaryOpr();
    //private DataElement dataElement=new DataElement();
    private List<DataElement> dataElementList=new ArrayList<DataElement>();
    private List<String> dataTypesList=new ArrayList<String>();
    String xyz;
    private String functionCallPattern="(\\w+)\\s*[(](s*\\w+(.*))([,]s*\\w+(.*))*s*[)]s*;";
    private String functionCallInputspattern="(\\w+\\s*)((.*)*)";
    Map< String, List<String> > mainVariableTable = new HashMap< String, List<String> >();
    Map< String, List<String> > otherVariableTable = new HashMap< String,  List<String> >();
    Map< String, String > variableTypeTable = new HashMap< String,  String>();
Map<String,String> dfdTable=new HashMap<String,String>();

Map<String,List<String>> functionCallTable;
private Map<String, List<String>> funcAdjList=new HashMap<>();
private List <String> calledFunctionsList=new ArrayList<String>();
private Map<String, String> functionsReturnTypeTable=new HashMap<>();
private String outputFilePath;

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }


    public Map<String, String> getVariableTypeTable() {
        return variableTypeTable;
    }

    public Map<String, String> getFunctionsReturnTypeTable() {
        return functionsReturnTypeTable;
    }
    
   
    public void getFunctionDeclarations(String codeFile) throws Exception
    {
        File file=new File(codeFile);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			String line="";
			 
			while ((line=breader.readLine())!=null)
                        {
                            //System.out.println(line);
                            patternMatcher.extractDeclaredFunctions(line);
                        }
                        
    }
    
    public void populateDataTypesList()
    {
        dataTypesList.add("String");
        dataTypesList.add("int");
        dataTypesList.add("bool");
        dataTypesList.add("double");
        dataTypesList.add("float");
        dataTypesList.add("char"); 
        
    }
    public void parseFile(String codeFile) 
    {
        populateDataTypesList();
        try
		{//System.out.println("yes");
			File file=new File(codeFile);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			String line="";
			 
			while ((line=breader.readLine())!=null)
			{//System.out.println("yes");
				String tokens[]=line.split(" ");
                               
                                //patternMatching(line);
                                typeIndicator=patternMatcher.patternMatching(line);
                                
                                if (typeIndicator==1)
                                    writeFunctionDeclaration(line);
                                else if (typeIndicator==2)
                                    writeFunctionCall(line);
                                else if (typeIndicator==3)
                                    writeReturnStatement(line);
                                //else
                                  //  System.out.println("No matching");
				
				
			}
                        
			//myobj.DisplayList(obj5);
		} // try block ends
		
        
		catch(java.io.FileNotFoundException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        catch(java.io.IOException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
    
        functionCallTable=patternMatcher.getFuncAdjList();
        for (Map.Entry<String,List<String>> entry : functionCallTable.entrySet())
        {
            //System.out.println(entry.getKey()+": ");
            for (int b=0;b<entry.getValue().size();b++)
            {
               // System.out.println(entry.getValue().get(b));
            }
        }
    }
    
    
    public void writeFunctionDeclaration(String line)
    {
        try
		{
			File file=new File(outputFilePath+outputFile);
			FileWriter fwriter=new FileWriter(file,true);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
                        
                        bwriter.write("---------------------------------");
                        bwriter.newLine();
                        ///
                      //  String tokens[]=line.split(" ( ");
                        bwriter.write("Main Function: "+patternMatcher.getFunctionDeclaration());
                        bwriter.newLine();
                        bwriter.write("Inputs:"+patternMatcher.getFunctionDeclarationInputs().replace("(","").replace(")", ""));
                       // bwriter.write("inputs: "+tokens[1].replace(')', ' '));
                        ///
			//bwriter.write(line); // original
			
	
                        bwriter.newLine();
                        //bwriter.write("Functions: ");
			bwriter.close();
			fwriter.close();
			
		} // try block ends
		
		catch(Exception e)
		{
			System.out.println("Error occured!");
			
		}
    } // function ends
    
    public void writeFunctionCall(String line)
    {
        try
		{
			File file=new File(outputFilePath+outputFile);
			FileWriter fwriter=new FileWriter(file,true);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
                       //bwriter.write("  ");
                       //////////
			bwriter.write("Function: "+patternMatcher.getFunctionCall());
                        bwriter.write("  Inputs:");
                        bwriter.write(patternMatcher.getFunctionCallInputs().replace("(", " ").replace(")", " "));
			
			bwriter.newLine();
			bwriter.close();
			fwriter.close();
			
		} // try block ends
		
		catch(Exception e)
		{
			System.out.println("Error occured!");
			
		}
    } // function ends
    
    
    public void writeReturnStatement(String line)
    {
        try
		{
			File file=new File(outputFilePath+outputFile);
			FileWriter fwriter=new FileWriter(file,true);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
                      // bwriter.write("  ");
                       // 
                        
                        ////
                        bwriter.write("Output: "+ patternMatcher.getOutputVariable().replace("(", " ").replace(")", " "));
                        ///
			//bwriter.write(line); // original
			
			bwriter.newLine();
			bwriter.close();
			fwriter.close();
			
		} // try block ends
		
		catch(Exception e)
		{
			System.out.println("Error occured!");
			
		}
    } // function ends
    
    public void nounPhrasing()
    {
        
        try
		{
			File file=new File("C:\\Users\\Umair Khan\\Desktop\\log.txt");
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			int x;
                        int opt;
			/////////
			String line="";
			 Parser parser=new Parser();
			while ((line=breader.readLine())!=null)
			{
                             String doc=line.replace("Main Function:", "").replace("Inputs:", "").replace("Function:", "").replace("Output:", "").replace(",", "").replace("---------------------------------", "".replace("[]", ""));
                             //System.out.println(doc);
                             String tokens[]=doc.split(" ");
                             for (int y=0;y<tokens.length;y++)
                             { opt=parser.doNounphrasing(tokens[y]);
                         //System.out.println(parser.getWord());
                         if (!parser.getWord().equals(null))
                             writeNounsAndVerbs(parser.getWord());
                            // System.out.println(parser.getWord());
                            // 
                            // if (opt==1)
                          // 
                           //  
                             }
				//String tokens[]=line.split(" ");
                                //patternMatching(line);
                               /* x=patternMatcher.patternMatching(line);
                                
                                if (x==1)
                                    writeFunctionDeclaration(line);
                                else if (x==2)
                                    writeFunctionCall(line);
                                else if (x==3)
                                    writeReturnStatement(line);
                                else
                                    System.out.println("No matching");*/
				
				
			}
			//myobj.DisplayList(obj5);
		} // try block ends
		
		catch(Exception e)
		{
			System.out.println("Error occured!");
			
		}
        
    } // function ends
    
    public void writeNounsAndVerbs(String line)
    {
        try
        {
        File file=new File(nounsAndVerbsOutputFile);
	FileWriter fwriter=new FileWriter(file,true);
	BufferedWriter bwriter=new BufferedWriter(fwriter);
        
        bwriter.write(line);
        
        
        
        
        bwriter.newLine();
	bwriter.close();
	fwriter.close();
        
        }
        catch (Exception e)
        {
            System.out.println("Error occured!");
        }
    } // function ends
    
    public Map<String, List<String>> attributeViewDataDictionary()
    {
        try
		{
			File file=new File(outputFilePath+autodd);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			String line="";
			
			while ((line=breader.readLine())!=null)
			{
                            //line.
                            String temp=line.replace(" ", "");
                           // System.out.println(temp);
				String tokens[]=temp.split(":"); // one data dictionary line
                                String parents[]=tokens[1].split("\\+");  // tokenizing parents of one data element
                                //System.out.println(parents[0]);
                                //DataElement dataElement=new DataElement(tokens[0],tokens[1]);
                            
                                for (int x=0;x<parents.length;x++)
                                {
                                     List<String> mainVariableList=new ArrayList<>();
                                    if (mainVariableTable.containsKey(parents[x]))
                                    {
                                        ///System.out.println("already pres; "+parents[x]);
                                    mainVariableList=mainVariableTable.get(parents[x]);
                                   mainVariableList.add(tokens[0]);
                                    mainVariableTable.put(parents[x], mainVariableList);
                             
                                    }
                                    
                                    else
                                    {  
                                        mainVariableList.add(tokens[0]);
                                        mainVariableTable.put(parents[x],mainVariableList );
                                   
                                    }
                                    
                                }
                             
                                //dataElementList.add(dataElement);
                             
			} // while ends
                        
			//myobj.DisplayList(obj5);
		} // try block ends
		
		catch(java.io.FileNotFoundException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        catch(java.io.IOException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        
        
        
        return mainVariableTable;
    } // func ends
    
     public Map<String,List<String>> structViewDataDictionary()
    {
        try
		{
			File file=new File(outputFilePath+autodd);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			String line="";
			
			while ((line=breader.readLine())!=null)
			{
                            //line.
                            String temp=line.replace(" ", "");
                            //System.out.println(temp);
				String tokens[]=temp.split(":"); // one data dictionary line
                                String parents[]=tokens[1].split("\\+");  // tokenizing parents of one data element
                                
                                if (parents.length==1) // this If is for setting variable type
                                {
                                    variableTypeTable.put(tokens[0], parents[0]); // setting variable type
                                }
                                
                                
     /*------->*/                       if (!dataTypesList.contains(parents[0])) // this If is for extracting data dict
                                {
                            
                                
                                
                                     List<String> otherVariableList=new ArrayList<>();
                                  
                                    
                                        for (int x=0;x<parents.length;x++)
                                        {
                                        ///System.out.println("already pres; "+parents[x]);
                                    otherVariableList.add(parents[x]);
                                  
                                    
                                        } // for ends
                                    
                                    
                               
                                    {  
                                       
                                        otherVariableTable.put(tokens[0],otherVariableList );
                                   
                                    }
                                    
                                
                             
                                }
                             
			} // while ends
                        
			//myobj.DisplayList(obj5);
		} // try block ends
		
		catch(java.io.FileNotFoundException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        catch(java.io.IOException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        
        
        
        return otherVariableTable;
    } // func ends
    
     public Map<String,String> readDfdFile()
     {
         try
		{
			File file=new File(outputFilePath+outputFile);
			FileReader freader=new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			
			/////////
			String line="";
			
			while ((line=breader.readLine())!=null)
			{
				if (line.equals("---------------------------------"))
                                {
                                
                                } // if ends
                                
                                else
                                {//System.out.println(line);
                                    String fullFunction[]=line.split("Main Function: ");
                                    
                                    String function[]=fullFunction[1].split(" ");
                                    
                                    functionsReturnTypeTable.put(function[1], function[0]);
                                    
                                    line=breader.readLine();
                                    //System.out.println(line);
                                    String inputs[]=line.split(":");
                                   // System.out.println(inputs[1]);
                                    if (inputs.length==1) 
                                    {
                                        dfdTable.put(function[1], null);
                                    }
                                    else // if inputs exists
                                    {
                                        //System.out.println(function[1]);
                                        if (inputs[1].equals("void"))
                                     dfdTable.put(function[1], null);
                                        else
                                            dfdTable.put(function[1], inputs[1]);
                                    }
                                    
                                } // else ends
                                    
				
				
			} // while ends
			//myobj.DisplayList(obj5);
		} // try block ends
		
		catch(java.io.FileNotFoundException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
        catch(java.io.IOException e)
		{
			System.out.println("Input Code File Not Found !");
			
		}
         
         for (Map.Entry<String, String> entry : dfdTable.entrySet())
         {
             String key=entry.getKey();
             String value=dfdTable.get(key);
             
            // System.out.println(value);
         }
         return dfdTable;
     } // func ends
     
     public void writeClasses(CandidateClass cc) throws Exception
     {
         File file=new File(outputFilePath+"\\cd.txt");
			FileWriter fwriter=new FileWriter(file,true);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
                        
                        bwriter.write("Class "+cc.getClassName()+" {");
                        bwriter.newLine();
                        bwriter.write("Private:");
                        bwriter.newLine();
                        for (int index=0;index<cc.getAttributesList().size();index++)
                        {
                            bwriter.write(cc.getAttributesList().get(index).getType()+" "+cc.getAttributesList().get(index).getName()+";");
                             bwriter.newLine();
                        } // for ends
                          bwriter.write("Public:");
                            bwriter.newLine();
                        for (int ind=0;ind<cc.getMethodList().size();ind++)
                        {
                            bwriter.write(cc.getMethodList().get(ind)+"();");
                             bwriter.newLine();
                        } // for ends
                         bwriter.write("};");
                          bwriter.newLine();
                         bwriter.close();
	fwriter.close();
     }
     
} // class ends
