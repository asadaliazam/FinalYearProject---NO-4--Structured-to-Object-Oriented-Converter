/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

import ClassDiagram.ClassIdentifier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Asad
 */
public class FileRead
{
    private String path = null;
    String [] tokens;
    List <String> funcList = new ArrayList<String>();
    List <String> mainFunction = new ArrayList<>();
    Set <String> objectsDeclarationList = new HashSet<String>();
    Set <String> functionObjectsDeclarationList = new HashSet<String>();
    ClassIdentifier classIdentifier=null;
    List<String>globalVariablesList=new ArrayList<String>();
    GlobalVariableDetector gvd=null;
    String outputPath=null;
    Map< String, List<String> > functionsClassesTable = new HashMap<  >();
    
    public FileRead(String inputFile, String outputPathGet)
    {
       
        path = inputFile;
        outputPath = outputPathGet;
                
       classIdentifier=classIdentifier.getClassIdentifierInstance();
       functionsClassesTable=classIdentifier.getFunctionsClassesTable();
       
       for (Map.Entry<String,List<String>> entry : functionsClassesTable.entrySet())
       {
           funcList.add(entry.getKey());
       }
       
    }
    
public void readFile() throws FileNotFoundException, IOException
    {
        //System.out.println(outputPath+"\\ooc.txt");
        String line;
        int start = 0;
        int counter = 0;
        int funcStart = 0;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(outputPath+"\\ooc.txt"));
            while ((line = br.readLine()) != null) 
            {
                
                //System.out.println();
                if (line.contains("main") || start == 1)
                {
                    if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))
                    {
                        continue;
                    }
                    start = 1;
                    for (int i = 0 ; i<line.length(); i++)
                    {
                    //System.out.print(line.charAt(i)+"");
                    if (line.charAt(i)=='{')
                    {
                        counter++;
                        funcStart = 1;
                    }
                    if (line.charAt(i)=='}')
                    {
                        counter--;
                    }
                    }
                    System.out.println();
                    //System.out.println(counter);
                    if (counter == 0 && funcStart == 1)
                    {
                        break;
                    }
                    String lineModifier = stringMatcherWithFunction(line);
                    //System.out.println(lineModifier);
                    mainFunction.add(lineModifier);
                }
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
       
                appendMainFunctionToFile();
                for (String s : mainFunction)
                {
                    System.out.println(s);
                }
        }
 
    public String stringMatcherWithFunction(String strLine)
    {
        
        for (int i = 0 ; i<funcList.size(); i++)
        {
        if (strLine.contains(funcList.get(i)))
                    {
                        String temp = strLine;
                        tokens = temp.split("\\(");
                        String [] temp2 = tokens[1].split("\\)");
                        
                    //System.out.println(temp2[0]);
                    String appendFucntion = appendClassNameWithFunctionCall(funcList.get(i));
                    //System.out.println(strLine);
                    strLine = strLine.replaceAll("\\s+","");
                    String returnString = appendFucntion.concat(strLine);
                    return returnString;
                    }
                    
                    
        
        
    }
        return strLine;
    }
    

    public String appendClassNameWithFunctionCall(String funcName) 
    {
        
        List<String> className = getClassFromFunction(funcName);
        String clasName = className.get(0);
        //System.out.println(clasName);
        String definition = clasName.concat(" ");
        definition = definition.concat(clasName+"Object");
        definition = definition.concat(";");
        //System.out.println(define);
        objectsDeclarationList.add(definition);
        String returnString = clasName+"Object.";
        return returnString;
    }
    
    public List<String> getClassFromFunction(String funcName)
    {
        List<String>temp=new ArrayList<String>();
        for (Map.Entry<String,List<String>> entry : functionsClassesTable.entrySet())
        {
            if (funcName.contains(entry.getKey()))
            {
                return entry.getValue();
                //return "dbs";
            }
        }
        
        return null;
    }
    
    
    
    public void functionWriter() throws FileNotFoundException, IOException
    {
        classIdentifier=classIdentifier.getClassIdentifierInstance();
        List <String> functionList = new ArrayList<>();
      //  functionList.add("void issue_book (issue jack[])");
        //functionList.add("void search_book(dbs var[])");
        functionList=classIdentifier.getAllFunctionsList();
        int bracketCounter = 0;
        //File file = new File(path);
        //FileReader fr = new FileReader(file);
        //BufferedReader br = new BufferedReader(fr);
        //String line;
        List<String> funcDeclaration = new ArrayList<String>();
        //int counter= 0;
        //int funcStart = 0;
        

        String line;
        int start = 0;
        int counter = 0;
        int funcStart = 0;
        String liner = null;
        //List<String> funcDeclaration = new ArrayList<String>();
        List<String> funcList = new ArrayList<>();
        funcList.add("void delete_library_user(user temp[])");
        funcList.add("void add_library_user(user [])");
        
                
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while ((line = br.readLine()) != null) 
            {
               
            for (int i = 0 ; i<functionList.size();i++)
            {
                
                if (line.equalsIgnoreCase(functionList.get(i))  || start == 1)
                {
                    while ((line = br.readLine()) != null)
                    {
                    
                    if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))
                    {
                        continue;
                    }
                    
                    start = 1;
                    for (int j = 0 ; j<line.length(); j++)
                    {
                        //System.out.print(line.charAt(i)+"");
                        //liner = liner+line.charAt(i);

                    if (line.charAt(j)=='{')
                    {
                        counter++;
                        funcStart = 1;
                    }
                    if (line.charAt(j)=='}')
                    {
                        counter--;
                    }
                    }
                    //System.out.println();
                    //System.out.println(counter);
                    if (counter == 0 && funcStart == 1)
                    {
                        start = 0;
                        break;
                    }
                    line = matchLineWithFunctionCall(line);
                    funcDeclaration.add(line);
                }
                    //System.out.println(funcList.get(i));
                
                    appendToFile(functionList.get(i),funcDeclaration,functionObjectsDeclarationList);
                    funcDeclaration.clear();
                    functionObjectsDeclarationList.clear();
            }
            
                
        }
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        
        

    }
        

        
        
    
    public void appendToFile(String funcDef, List<String> funcDeclaration, Set<String> functionObjectsDeclarationList) throws FileNotFoundException, IOException
    {
        System.out.println(funcDef);
        for (String s: funcDeclaration)
        {
            //System.out.println(s);
        }
        
        try 
        {
            File outFile = new File(outputPath+"\\asad.txt");
            File inFile = new File(outputPath+"\\oocd.txt");
     
     
            FileInputStream fis  = new FileInputStream(inFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

     // output         
            FileOutputStream fos = new FileOutputStream(outFile);
            PrintWriter out = new PrintWriter(fos);

            String thisLine = "";
            while ((thisLine = in.readLine()) != null) 
            {
                if(thisLine.contains(funcDef))
                {
                    out.println(thisLine);
                    
                    for (int i = 0 ; i<funcDeclaration.size(); i++)
                    {
                        if (i==1)
                        {
                            for (String s:functionObjectsDeclarationList)
                            {
                                out.println(s);
                            }
                        }
                    out.println(funcDeclaration.get(i));
                    }
                    out.println("}");
                }
                else
                {
                    //thisLine = in.readLine();
                    out.println(thisLine);
                }
            }
    out.flush();
    out.close();
    in.close();
    
    inFile.delete();
    outFile.renameTo(inFile);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}
    
    public void appendMainFunctionToFile() throws FileNotFoundException, IOException
    {
        gvd=gvd.getGlobalVariableDetectorInstance();
        globalVariablesList=gvd.getGlobalVariablesList();
        int check = 0;
        
        
        
        try 
        {
            File outFile = new File(outputPath+"\\oocd.txt");
            File inFile = new File(outputPath+"\\ooc.txt");
     
     
            FileInputStream fis  = new FileInputStream(inFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

     // output         
            FileOutputStream fos = new FileOutputStream(outFile);
            PrintWriter out = new PrintWriter(fos);

            String thisLine = "";
            while ((thisLine = in.readLine()) != null) 
            {
                if (check == 1)
                {
                    break;
                }
                if(thisLine.contains("main"))
                {
                    out.println(thisLine);
                    out.println(mainFunction.get(1));
                    
                    for (String s:globalVariablesList)
                    {
                        s = s.concat(";");
                        out.println(s);
                    }
                    for (String s:objectsDeclarationList)
                    {
                        out.println(s);
                    }
                    for (int i = 2 ; i<mainFunction.size(); i++)
                    {
                    out.println(mainFunction.get(i));
                    }
                    out.println("}");
                    check = 1;
                    break;
                }
                else
                {
                    //thisLine = in.readLine();
                    out.println(thisLine);
                }
            }
    out.flush();
    out.close();
    in.close();
    
    inFile.delete();
    outFile.renameTo(inFile);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void display(String get, List<String> funcDeclaration) 
    {
        System.out.println(get);
        for (String s : funcDeclaration)
        {
            System.out.println(s);
        }
        
    }

    private String matchLineWithFunctionCall(String line) 
    {
        //List<String> funcCallList = new ArrayList<>();
        //funcCallList.add("gotoxy");
        //funcCallList.add("");
        
        for (int i = 0 ; i<funcList.size(); i++)
        {
            
            if (line.contains(funcList.get(i)))
            {
        
                String functionCallregex="(\\w+)\\s*[(](s*\\w+(.*))([,]s*\\w+(.*))*s*[)]s*;";
                Pattern functionCallPattern=Pattern.compile(functionCallregex);
                Matcher functionCallMatcher=null;
        
                functionCallMatcher=functionCallPattern.matcher(line);
                        
                           if (functionCallMatcher.find())
                           {
                               String tokens[]=line.split("(\\w+\\s*[(]s*\\w+(.*)([,]s*\\w+(.*))*s*[)]s*)");
                               
                               String statementBeforeFunction = tokens[0]; // prints text behind the function
                               String functionCall = functionCallMatcher.group(0);// prints the function
                               String classNameFromFunction = appendClassNameWithFunctionCallForFunction(functionCall);
                               String returnString = statementBeforeFunction.concat(classNameFromFunction).concat(functionCall);
                               //System.out.println(tokens[1]); //prints text after the function
                               //line="boo";
                               return returnString;
                               
                           }
            }
        }
        return line;
    }
    
    public String appendClassNameWithFunctionCallForFunction(String funcName) 
    {
        
        List<String> className = getClassFromFunction(funcName);
        String clasName = className.get(0);
        //System.out.println(clasName);
        String definition = clasName.concat(" ");
        definition = definition.concat(clasName+"Object");
        definition = definition.concat(";");
        //System.out.println(define);
        functionObjectsDeclarationList.add(definition);
        String returnString = clasName+"Object.";
        return returnString;
    }
    
    public List<String> getClassFromFunctionForFunction(String funcName)
    {
        List<String>temp=new ArrayList<String>();
        for (Map.Entry<String,List<String>> entry : functionsClassesTable.entrySet())
        {
            if (funcName.contains(entry.getKey()))
            {
                return entry.getValue();
                //return "dbs";
            }
        }
        
        return null;
    }
}
        
