/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDiagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import DataFlowDiagram.DataElement;
import DataFlowDiagram.FileHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Umair Khan
 */
public class ClassIdentifier {
    private List<String> dataTypesList=new ArrayList<String>();
    private FileHandler fileHandler=new FileHandler();
   // private DataElement dataElement=new DataElement();
    private List<DataElement> dataDictionary;
    Map< String, List<String> > variableTable = new HashMap<  >();
    Map< String, List<String> > dataElementsTable = new HashMap<  >();
    Map< String, List<String> > functionsClassesTable = new HashMap<  >();
List<String>classNameList=new ArrayList<String>();
List<String> allFunctionsList=new ArrayList<String>();
List<String>publicClassesList=new ArrayList<String>();
public void printPublicClassesList()
{
    for (int x=0;x<publicClassesList.size();x++)
    {
        System.out.println(publicClassesList.get(x));
    }
}
    public List<String> getPublicClassesList() {
        return publicClassesList;
    }

    public Map<String, List<String>> getDataElementsTable() {
        return dataElementsTable;
    }

    public List<String> getAllFunctionsList() {
        return allFunctionsList;
    }

    public void setCandidateClassList(List<CandidateClass> candidateClassList) {
        this.candidateClassList = candidateClassList;
    }

    public Map<String, List<String>> getFunctionsClassesTable() {
        return functionsClassesTable;
    }

    public List<CandidateClass> getCandidateClassList() {
        return candidateClassList;
    }
   private List<CandidateClass> candidateClassList=new ArrayList<>();

    public static void setClassIdentifier(ClassIdentifier classIdentifier) {
        ClassIdentifier.classIdentifier = classIdentifier;
    }
    private Map< String, String > variableTypeTable = new HashMap<  >();
    private Map<String, String> functionDeclarationTable=new HashMap<>();
    private Map<String, String> functionsReturnTypeTable=new HashMap<>();
    private static ClassIdentifier classIdentifier=null;
    String fdi2="^\\w+\\s*\\[[(.*)\\]]$";
    
    public static ClassIdentifier getClassIdentifierInstance()
    {
        if (classIdentifier==null)
           classIdentifier=new ClassIdentifier();
            return classIdentifier;
        
    }
    
    public void printAllFunctions()
    {
       for (int index=0;index<allFunctionsList.size();index++)
       {
           System.out.println(allFunctionsList.get(index));
           
       } // for ends
    } // func ends
    public void printFunctionsClassestable()
    {
        for (Map.Entry<String,List<String>> entry : functionsClassesTable.entrySet())
        {
            System.out.println("function: "+entry.getKey() );
            for (int index=0;index<entry.getValue().size();index++)
            {
                System.out.println(entry.getValue().get(index));
            }
            
        }
        
    } // func ends
    public void assignGlobalVariables()
    {
        
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
    public void assignMethods()
    {
        Pattern argPattern=Pattern.compile(fdi2);
        Matcher matcher;
        functionDeclarationTable=fileHandler.readDfdFile();
        functionsReturnTypeTable=fileHandler.getFunctionsReturnTypeTable();
         for (Map.Entry<String,String> entry : functionDeclarationTable.entrySet())
         {
             if (entry.getValue()==null)
              {
                  if (!entry.getKey().equals("main"))
                  {
                  CandidateClass candidateClass= new CandidateClass(entry.getKey()+"Class"); 
                candidateClassList.add(candidateClass);
                candidateClass.addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"( )");
                 allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"( )");
                  }
                  
                  }
             
             else
             {
             String tokens[]=entry.getValue().split(",");
            // System.out.println(entry.getValue());
             if (tokens.length==1) // considering methods with only one argument
             {
                 matcher=argPattern.matcher(tokens[0]);
             if (matcher.find())
             {
                for (int m=0;m<candidateClassList.size();m++)
                {
                    if (candidateClassList.get(m).getClassName().equals(tokens[0].replaceAll("\\s*\\[[(.*)\\]]", "")))
                    {
                        candidateClassList.get(m).addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                        allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                        if (functionsClassesTable.containsKey(entry.getKey()))
                        {
                            classNameList=new ArrayList<String>();
                            classNameList.add(candidateClassList.get(m).getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                        }
                        else
                        {
                            classNameList=new ArrayList<String>();
                            classNameList.add(candidateClassList.get(m).getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                        }
                        
                        //System.out.println(entry.getKey()+ entry.getValue());
                    }
// System.out.println(tokens[0].replaceAll("\\[[(.*)\\]]", ""));
                        //System.out.println("found------------");
                }
                 /* 
                       if nonprimitve datatype
                          assign function to respective class
                       else
                       check the existence of variable in other classes and assign function to each of those classes
                 */
                 //System.out.println(matcher.group());
             }
              else
             {
                 
                 String tokens2[]=tokens[0].split(" "); // getting 'type' of the variable
                 //System.out.println(tokens2[1]);
                 if (dataElementsTable.containsKey(tokens2[0])) // if dF is a class
                 {
                     for (int index=0;index<candidateClassList.size();index++)
                     {
                         if (candidateClassList.get(index).getClassName().equals(tokens2[0]))
                         {
                             candidateClassList.get(index).addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                             allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                             
                             
                             classNameList=new ArrayList<String>();
                            classNameList.add(candidateClassList.get(index).getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                            // System.out.println("Adding "+entry.getKey()+ " to "+ candidateClassList.get(index).getClassName());
                         }
                     } 
                 }
                
                 else if (variableTable.containsKey(tokens2[1]))
                 {//System.out.println(tokens2[1]+"  it is");
                     List<String> tempList=variableTable.get(tokens2[1]);
                     
                     for (int index=0;index<tempList.size();index++)
                     {
                         
                         for (int ccindex=0;ccindex<candidateClassList.size();ccindex++)
                         {
                             if (tempList.get(index).equals(candidateClassList.get(ccindex).getClassName()))
                                 candidateClassList.get(ccindex).addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                             allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                             classNameList=new ArrayList<String>();
                            classNameList.add(candidateClassList.get(ccindex).getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                             
                         }
                         
                     } // for ends
                 }  // else if ends
             } // unusual argument type
                               //// here i need to tackle the scenarion in which argument is absent in both tables
             } // if ends
             
              else if (tokens.length>1) // if multiple arguments
            {//System.out.println(tokens[0]+tokens[1]);
                List<Attributes> tempAttrList=new ArrayList<>();
                 for (int index=0;index<tokens.length;index++)
                 {//System.out.println(tokens[index].trim());
                 String splitted[]=tokens[index].trim().split(" ");
                 
                 // match rexex with single argument, if matches put the
                 
                // System.out.println(splitted[0]+" "+splitted[1]);
                 Attributes attr=new Attributes(splitted[1],splitted[0]);
                 
                 tempAttrList.add(attr);
                 } // for ends
                 int found=0;
                 //System.out.println("current attrs: ");
                         for (int y=0;y<tempAttrList.size();y++)
                         {
                           //  System.out.println(tempAttrList.get(y).getType()+" "+tempAttrList.get(y).getName());
                         }
                 for (int ccIndex=0;ccIndex<candidateClassList.size();ccIndex++)
                 {
                     int x=candidateClassList.get(ccIndex).checkVariableCoexistence(tempAttrList);
                     {//System.out.println("real attr:");
                        //candidateClassList.get(ccIndex).displayAttributes();
                     }
                     if (x==1) // if all arguments are owned attributes in some class
                     { // System.out.println(entry.getKey()+" added to "+ candidateClassList.get(ccIndex).getClassName());
                     candidateClassList.get(ccIndex).addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                     allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                     
                     classNameList=new ArrayList<String>();
                            classNameList.add(candidateClassList.get(ccIndex).getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                     found=1;
                    // else if (x==0)
                     }
                     
                         //System.out.println("nothing");
                 } // for1 ends
                 if (found==0) // if attributes arent owned attributes in some class
                     {
                         CandidateClass cclass=new CandidateClass(entry.getKey()+"Class");
                         cclass.setAttributesList(tempAttrList);
                         cclass.addMethod(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")"); // added return type 
                         //System.out.println("new class "+entry.getKey());
                         candidateClassList.add(cclass);
                         allFunctionsList.add(functionsReturnTypeTable.get(entry.getKey())+" "+entry.getKey()+"("+entry.getValue()+")");
                         
                         classNameList=new ArrayList<String>();
                            classNameList.add(cclass.getClassName());
                            functionsClassesTable.put(entry.getKey(),classNameList);
                         
                         /////
                         for (int x=0;x<tempAttrList.size();x++) // new class is made so we need to update variable table in order to show inclusion of attributes in new class
                         {List<String> tempList=new ArrayList<>();
                             if (variableTable.containsKey(tempAttrList.get(x).getName()))
                             {
                                 tempList=variableTable.get(tempAttrList.get(x).getName());
                                 tempList.add(cclass.getClassName());
                                    variableTable.put(tempAttrList.get(x).getName(), tempList);
                                 
                                // System.out.println("yes:          "+entry.getKey());
                              
                             } // if endsw
                             else
                             {tempList.add(cclass.getClassName());
                                 variableTable.put(tempAttrList.get(x).getType(), tempList); // because in variableTable,only name of struct is saved (not the name of the variable unlike primitve variables). Thats why we are adding 'type' of the variable instead of its name
                             }
                         }
                         
                         ///
                     }
                 
                 
                 
             } // else if ends
         } // no arg fuctions handler
         } // for ends
        
    } // func ends
    
    public void determineClassRelations()
    {
        /*
        for (int index=0;index<candidateClassList.size();index++)
        {
            if (variableTable.containsKey(candidateClassList.get(index).getClassName()))
            {
                for (int varindex=0;varindex<variableTable.get(candidateClassList.get(index).getClassName()).size();varindex++)
                {
                    Relation relation=new Relation(variableTable.get(candidateClassList.get(index).getClassName()).get(varindex),"c");
                    candidateClassList.get(index).addRelation(relation);
                } // for1 ends
            }
        } // for ends
        */
        /////////////////////////////
        List<Attributes> dummyList=new ArrayList<Attributes>();
        Relation relation2=null;
        for (int kk=0;kk<candidateClassList.size();kk++)
        {
            dummyList=candidateClassList.get(kk).getAttributesList();
            
            for (int mm=0;mm<dummyList.size();mm++)
            {
                if (!dataTypesList.contains(dummyList.get(mm).getType()))
                {
                     relation2=new Relation(dummyList.get(mm).getType(),"c");
                    candidateClassList.get(kk).addRelation(relation2);
                }
                
            } // inner for ends
            
        } // for ends
        
    } // func ends
    
    public void generateClassDiagram(String outputPath) throws Exception
    {
        fileHandler.setOutputFilePath(outputPath);
        extractDataDictionary();
        //displayDataDictionary();
        identifyStandaloneClasses();
        assignAttributes();
        
       // printCandidateClasses();
        assignMethods();
        determineClassRelations();
       // printFunctionsClassestable();
        printCandidateClasses();
        //printPublicClassesList();
       // printAllFunctions();
        boolean yo;
        for (int y=0;y<candidateClassList.size();y++)
        {
            yo=candidateClassList.get(y).checkvariableExistence("isbn");
           // if (yo)
            //System.out.println("checking");
            
        }
       // writeClasses();
        
    }
    
    public void identifyStandaloneClasses()
    {
        populateDataTypesList();
        for (Map.Entry<String, List<String>> entry : dataElementsTable.entrySet())
        {
            String dataElement=entry.getKey();
            
            if (!variableTable.containsKey(dataElement)) // if dataElement dE is standalone
            {
                CandidateClass candidateClass= new CandidateClass(dataElement);  // creating new class with same name as of dE
                candidateClassList.add(candidateClass);
                
                //System.out.println(dataElement+"  Yes standalone");
            }
            
        } //for ends
        
        String type11;
        for (Map.Entry<String, List<String>> entry : dataElementsTable.entrySet())
        {
            String dataElement=entry.getKey();
            
            if (variableTable.containsKey(dataElement)) // dE is subset of another element dE1
            {
                if(dataElementsTable.get(dataElement).size()==1) // if dataelement is composed of only one element
                {
                    type11=dataElementsTable.get(dataElement).get(0);
                    //System.out.println(type11);
                    if (!dataTypesList.contains(type11)) // if non-primitve data type, (confusion)
                    {
                       /* CandidateClass candidateClass=new CandidateClass(dataElement); // creat new class with same name as of dE
                candidateClassList.add(candidateClass);
                System.out.println(dataElement+"  Yes standalone  "+type11);
                        */
                        //System.out.println(dataElementsTable.get(dataElement).get(0) +"needs to be public");
                        
                        if (!publicClassesList.contains(dataElementsTable.get(dataElement).get(0))) // to avoid repitition
                        publicClassesList.add(dataElementsTable.get(dataElement).get(0));
                        
                        
                        
                    } // inner most if ends
                }
                else
                {
                    CandidateClass candidateClass=new CandidateClass(dataElement); // creat new class with same name as of dE
                candidateClassList.add(candidateClass);
                }
                
                /*List<String> variableTableList=variableTable.get(dataElement);
                
                for (int index=0;index<variableTableList.size();index++)
                {
                    Attributes attribute=new Attributes(dataElement,dataElement);
                    
                    for (int ind=0;ind<candidateClassList.size();ind++)
                    {
                        if (variableTableList.get(index).equals(candidateClassList.get(ind).getClassName()))
                        {
                            candidateClassList.get(ind).setAttributes(attribute); // adding dE as owned attribute in de1
                            
                        } // if ends
                    } // inner for ends
                    
                    
                } // for ends */
                
                
            } // if ends
            
            
            
        } // for ends
        
        
        
    } // func ends
    
    public void identifyVariables()
    {
        
        
        
        for (Map.Entry<String, List<String>> entry : variableTable.entrySet())
                {
                    List<String> variableTableList=variableTable.get(entry.getKey());
                    
                    if (!dataTypesList.contains(entry.getKey()))
                    {
                    Attributes attribute=new Attributes(entry.getKey(),entry.getKey());
                   // System.out.println("->>>>>>"+entry.getKey());
                    for (int index=0;index<variableTableList.size();index++)
                    {
                    for (int ind=0;ind<candidateClassList.size();ind++)
                    {
                        if (variableTableList.get(index).equals(candidateClassList.get(ind).getClassName()))
                        {
                            candidateClassList.get(ind).setAttributes(attribute); // adding dE as owned attribute in de1
                            
                        } // if ends
                    } // inner for ends
                    
                    }
                } // for ends
    }
    } // func endws
    public void extractDataDictionary()
    {
      variableTable=fileHandler.attributeViewDataDictionary();
      dataElementsTable=fileHandler.structViewDataDictionary();
      variableTypeTable=fileHandler.getVariableTypeTable();
      
      
    }
    
    public void assignVariableTypes()
    {
        for (int index=0;index<candidateClassList.size();index++)
        {
            candidateClassList.get(index).assignVariableTypes(variableTypeTable);
            if (publicClassesList.contains(candidateClassList.get(index).getClassName()))
                candidateClassList.get(index).setAttributeModifier("Public");
        } // for ends
        
       
    } // func ends
    public void printCandidateClasses()
    {
        for (int index=0;index<candidateClassList.size();index++)
        {
            System.out.println("Candidate Class: "+candidateClassList.get(index).getClassName());
            System.out.println("Attributes: "+candidateClassList.get(index).getAttributeModifier());
            candidateClassList.get(index).displayAttributes();
            System.out.println("Methods: ");
            candidateClassList.get(index).displayMethods();
            System.out.println("Relation: ");
            candidateClassList.get(index).displayRelations();
            System.out.println("----------");
            
        } // for ends
        
    } // func ends
    
    public void displayDataDictionary()
    {
        
        for (Map.Entry<String, List<String>> entry : variableTable.entrySet())
        {
           // String dummy=entry.getKey();
            List<String>dummylist=entry.getValue();
           System.out.println("Parents: "+entry.getKey()); 
           for (int dum=0;dum<dummylist.size();dum++)
           {
               System.out.println(dummylist.get(dum));
               
           }
           System.out.println("---------");
        }
    }
    public void displayDataDictionary2()
    {
        
        for (Map.Entry<String, List<String>> entry : dataElementsTable.entrySet())
        {
           // String dummy=entry.getKey();
            List<String>dummylist=entry.getValue();
           System.out.println("Data Elements: "+entry.getKey()); 
           for (int dum=0;dum<dummylist.size();dum++)
           {
               System.out.println(dummylist.get(dum));
               
           }
           System.out.println("---------");
        }
    } // func ends
   
    public void assignAttributes()
    {
        
      identifyVariables();
      assignVariableTypes();
     
        
    } // func ends
    
    public void writeClasses() throws Exception
    {
        for (int index=0;index<candidateClassList.size();index++)
        {
            fileHandler.writeClasses(candidateClassList.get(index));
            
        } // for ends
    } // func ends
    
    
} // class ends
