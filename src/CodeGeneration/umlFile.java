/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneration;

import ClassDiagram.Attributes;
import ClassDiagram.CandidateClass;
import ClassDiagram.ClassIdentifier;
import ClassDiagram.Relation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umair Khan
 */
public class umlFile implements FileHandling {
 
    private ClassIdentifier classIdentifier=null;
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
    @Override
    public void writeToFile(String line)
    {
        try
        {
        File file=new File(umlFile);
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
    }
    
    @Override
    public void readFromFile()
    {
        
    }
    
    public void generateUmlFIle()
    {
        classIdentifier=classIdentifier.getClassIdentifierInstance();
        
          List<CandidateClass> candidateClassList=new ArrayList<>();
     List<Attributes> attrList=new ArrayList<Attributes>();
   List<String> methodList=new ArrayList<String>();
   List<Relation> relList=new ArrayList<Relation>();
     CandidateClass candidateClass=null;
     
     candidateClassList=classIdentifier.getCandidateClassList();
     
     for (int x=0;x<classIdentifier.getCandidateClassList().size();x++)
     {
         writeToFile("org.eclipse.uml2.uml.Class "+candidateClassList.get(x).getClassName()+"Class = createClass(epo2Model,\""+candidateClassList.get(x).getClassName()+"\", false);");
     }
        
        for (int y=0;y<classIdentifier.getCandidateClassList().size();y++)
        {
            attrList=classIdentifier.getCandidateClassList().get(y).getAttributesList();
            
            for (int ind=0;ind<attrList.size();ind++)
            {
                if (attrList.get(ind).getType().equals("char"))
                    writeToFile("createAttribute("+classIdentifier.getCandidateClassList().get(y).getClassName()+"Class, \""+attrList.get(ind).getName()+"\", "+"String"+"PrimitiveType, 0, 1);");
                else
                writeToFile("createAttribute("+classIdentifier.getCandidateClassList().get(y).getClassName()+"Class, \""+attrList.get(ind).getName()+"\", "+attrList.get(ind).getType()+"PrimitiveType, 0, 1);");
            }
        }
        
        for (int h=0;h<candidateClassList.size();h++)
        {
            relList=candidateClassList.get(h).getClassRelationList();
            if (relList.size()>0)
            {
            for (int c=0;c<relList.size();c++)
            {
                
                
                    writeToFile("createAssociation("+candidateClassList.get(h).getClassName()+", true, AggregationKind.COMPOSITE_LITERAL,\"pendingOrders\", 0, LiteralUnlimitedNatural.UNLIMITED,"+relList.get(c).getClasshavinginstance()+", false, AggregationKind.NONE_LITERAL , 1, 1);");
                
            }
        }
        }
    } // func ends
    
    
    
} // class ends
