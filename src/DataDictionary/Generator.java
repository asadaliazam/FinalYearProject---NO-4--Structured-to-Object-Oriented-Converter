/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataDictionary;

/**
 *
 * @author Umair Khan
 */
public class Generator {

    /**
     * @param args the command line arguments
     */
    public  void doGenerateDataDictionary(String codeFile, String outputPath) throws Exception {
        // TODO code application logic here
        regex obj=new regex(outputPath);
        obj.extractstructs(codeFile);
        //obj.displayDD();
        obj.writeDD();
    }
    
}
