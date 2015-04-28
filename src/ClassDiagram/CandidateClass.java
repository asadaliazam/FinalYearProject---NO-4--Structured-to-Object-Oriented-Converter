/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDiagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Umair Khan
 */
public class CandidateClass {
    private String className;
    private List <Attributes> attributesList=new ArrayList<>();
private List<String> methodList=new ArrayList<>();
private List<Relation> classRelationList=new ArrayList<>();
private String attributeModifier="private";
private boolean priority=false;

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }


    public String getAttributeModifier() {
        return attributeModifier;
    }

    public void setAttributeModifier(String attributeModifier) {
        this.attributeModifier = attributeModifier;
    }

public void addAttribute(String var,int indicator)
{
    String tokens[]=var.split("\\s+");
    Attributes attributes=null;
    if (indicator==1)
     attributes=new Attributes("*"+tokens[1],tokens[0]);
    else
       attributes=new Attributes(tokens[1],tokens[0]);
    attributesList.add(attributes);
    
    
} // func ends
    
    public List<String> getMethodList() {
        return methodList;
    }

    public List<Relation> getClassRelationList() {
        return classRelationList;
    }

public void addRelation(Relation o)
{
    classRelationList.add(o);
    
} // func ends
    public void setAttributesList(List<Attributes> attributesList) {
        this.attributesList = attributesList;
    }

public int checkVariableCoexistence(List<Attributes> variableList)
{
   // System.out.println("CCLASS ATTR: ");
   // for (int index=0;index<attributesList.size();index++)
    {
        //System.out.println(attributesList.get(index).getType()+" "+attributesList.get(index).getName());
    }
//System.out.println("EMP ATTR:");

//for (int ind=0;ind<variableList.size();ind++)
{
    //System.out.println(variableList.get(ind).getType()+" "+variableList.get(ind).getName());
}    
    if (attributesList.containsAll(variableList))
        return 1;
    else
        return 0;
}
public void diptostring()
{
    String temp=attributesList.toString();
    System.out.println(temp);
}
        
    public List<Attributes> getAttributesList() {
        return attributesList;
    }
   public void addMethod(String method)
   {
       methodList.add(method);
       
   } // func ends
           
    public void assignVariableTypes(Map<String,String> map)
    {
        for (int index=0;index<attributesList.size();index++)
        {
            if (map.containsKey(attributesList.get(index).getName()))
            {
                attributesList.get(index).setType(map.get(attributesList.get(index).getName()));
                
            } // if ends
            
        } // for ends
    }
    
    public void displayRelations()
    {
        for (int index=0;index<classRelationList.size();index++)
        {
            System.out.println(classRelationList.get(index).getClasshavinginstance());
        } // for ends
        
    } // func ends
    public void displayAttributes()
    {
        for (int index=0;index<attributesList.size();index++)
        {
            System.out.println(attributesList.get(index).getName()+" ("+attributesList.get(index).getType()+")");
            //System.out.println(attributesList.get(index).getType());
        } // for ends
    }
    
    public void displayMethods()
    {
        for (int index=0;index<methodList.size();index++)
        {
            System.out.println(methodList.get(index));
            //System.out.println(attributesList.get(index).getType());
        } // for ends
    }
    public CandidateClass(String className) {
        
        this.className = className;
    }

    public void setAttributes(Attributes attributes) {
        attributesList.add(attributes);
    }

    public String getClassName() {
        return className;
    }

    
 public boolean checkvariableExistence(String var)
 {
     Attributes atr=new Attributes(var,"dummy");
     for (int x=0;x<attributesList.size();x++)
     {
         if (attributesList.contains(atr))
             return true;
         
         
     } // for ends
     return false;
 } // func ends
 

    

   
    
} // class ends
