/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CodeGeneration.FileHandling;
import CodeGeneration.MainAndFunctionCompatibility;
import CodeGeneration.umlFile;
import DataFlowDiagram.NO4;

/**
 *
 * @author Umair Khan
 */
public class User {
    private static NO4 no4Controller=new NO4();
    private String addressButton="";
    private static String codeFile;
    
    private static  String projectInputFile="D:\\Fast-NUCES\\1st Semester\\ITC\\ITC\\Term Project Main\\iCooperate final\\iCooperate\\fh final.cpp";
    private String lmsFile="C:\\Users\\Umair Khan\\Desktop\\Library Management System\\lms.cpp";
   private String alarmCodeFile="C:\\Users\\Umair Khan\\Desktop\\Alarm System\\uk.cpp";
   private String alarmDfdFile="C:\\Users\\Umair Khan\\Desktop\\alarmd.txt";
   private String libDfdFile="C:\\Users\\Umair Khan\\Desktop\\dd.txt";
   String autodd="C:\\Users\\Asad\\Desktop\\autodd.txt";
   static String studmgmtFile="C:\\Users\\Umair Khan\\Desktop\\STUDMGMT.cpp";
   String studDfdFile="C:\\Users\\Umair Khan\\Desktop\\sdd.txt";
   String sEngineFile="D:\\Fast-NUCES\\2nd Semester\\Computer Programming\\Final project\\Final\\Ranking\\URK\\rough\\dcc.cpp";
   static String  myLibMgmtFile="C:\\Users\\Umair Khan\\Desktop\\1st.cpp";
  static String gameFile="C:\\Users\\Umair Khan\\Desktop\\str.cpp";
  private static String sampFile="C:\\Users\\Umair Khan\\Desktop\\samp.txt";
  private static String miniFile="C:\\Users\\Umair Khan\\Desktop\\Mini.cpp";
  private static String bilalFile="C:\\Users\\Umair Khan\\Desktop\\bilal.cpp";
  private static String abcFile="C:\\Users\\Umair Khan\\Desktop\\abc.cpp";
  private static String outputPath="C:\\Users\\Umair Khan\\Desktop";
  
// private static ClassIdentifier ddo=new ClassIdentifier();
   // public void startExtractingDFD()
    //{
    //    no4Controller.parseFile(addressButton);
   // }
    public static void main(String[] args)throws Exception
    {
        ProjectController projectControllerObject = new ProjectController();
        projectControllerObject.startGUI();
        
        //StartFrame startFrame = new StartFrame(this, miniFile, outputPath);
        //startFrame.setLocationRelativeTo(null);
        //startFrame.setVisible(true);
        
        //System.out.println(miniFile);
        //System.out.println(outputPath);
        
        //no4Controller.dataExtraction(miniFile,outputPath);
        //no4Controller.classIdentification(outputPath);
        //no4Controller.generateCode(miniFile,outputPath);
        
        //FileRead fileReadObject = new MainAndFunctionCompatibility(miniFile, outputPath);
        //fileReadObject.readFile();
        //fileReadObject.functionWriter();
        
        
        //umlFile umlFileobj=new umlFile();
        //umlFileobj.generateUmlFIle();
        
        
         

        
        
    }
    
    
}
