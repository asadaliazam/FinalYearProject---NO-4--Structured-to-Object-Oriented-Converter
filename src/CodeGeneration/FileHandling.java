/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

/**
 *
 * @author Umair Khan
 */
public interface FileHandling {
    String myLibMgmtFile="C:\\Users Khan\\Asad\\Desktop\\1st.cpp";
  String gameFile="C:\\Users\\Umair Khan\\Desktop\\str.cpp";
  String oocFile="ooc.txt";
  String finalFile="C:\\Users\\Umair Khan\\Desktop\\finalCode.txt";
  String abcFile="C:\\Users\\Umair Khan\\Desktop\\abc.cpp";
  String umlFile="C:\\Users\\Umair Khan\\Desktop\\uml.txt";
  

  
  
    public void readFromFile();
    public void writeToFile(String line);
  public void setOutputFilePath(String path);         
  public void setInputFilepath(String path);
}
