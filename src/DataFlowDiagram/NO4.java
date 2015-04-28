/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFlowDiagram;

import ClassDiagram.ClassIdentifier;
import CodeGeneration.CdCode;
import CodeGeneration.GlobalVariableDetector;
import CodeGeneration.MainMethodHandler;
import DataDictionary.Generator;

/**
 *
 * @author Umair Khan
 */
public class NO4 {

    /**
     * @param args the command line arguments
     */
    private FileHandler fileHandler=new FileHandler();
    private ClassIdentifier classIdentifier=null;
    
    private Generator generator=new Generator();
    public void generateDataDictionary(String codeFile, String outputPath) throws Exception
    {
        generator.doGenerateDataDictionary(codeFile, outputPath);
        fileHandler.setOutputFilePath(outputPath);
    }
    
    public void getFunctionDeclarations(String codeFile)throws Exception
    {
        
        fileHandler.getFunctionDeclarations(codeFile);
    }
    public void parseFile(String address)
    {
        fileHandler.parseFile(address);
    }
    public void nounPhrasing(String address)
    {
        fileHandler.nounPhrasing();
    }
    public void classIdentification(String outputPath) throws Exception
    {
        classIdentifier=classIdentifier.getClassIdentifierInstance();
        classIdentifier.generateClassDiagram(outputPath);
        
    } // func ends
    public void dataExtraction(String File, String outputPath) throws Exception
    {
        generateDataDictionary(File,outputPath);
       getFunctionDeclarations(File);
      parseFile(File);
        
    }// func ends
    public void generateCode(String inputFile,String outputPath)
    {
        GlobalVariableDetector obj=null;//new GlobalVariableDetector();
       obj=obj.getGlobalVariableDetectorInstance();
       obj.setInputFilepath(inputFile);
       obj.setOutputFilePath(outputPath);
       obj.readFromFile();
       obj.addToClassDiagram();
       
       
        CdCode cdCodeObject=new CdCode();
        cdCodeObject.setInputFilepath(inputFile);
        cdCodeObject.setOutputFilePath(outputPath);
        cdCodeObject.getCandidateClassList();
        cdCodeObject.generateCodeFromCd();
        
        
        
        
       MainMethodHandler mainMethodHandlerObject=new MainMethodHandler();
       mainMethodHandlerObject.setInputFilepath(inputFile);
       mainMethodHandlerObject.setOutputFilePath(outputPath);
       mainMethodHandlerObject.readFromFile();
       
       
    } // func ends
    
   
    
} // class ends
