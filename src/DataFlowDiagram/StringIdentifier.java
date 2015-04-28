/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFlowDiagram;

import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Umair Khan
 */
public class StringIdentifier {
    
   // private String pattern= "\\s*\\w+\\s+\\w+\\s*[(](\\s*\\w+\\s+\\w+(.*)\\s*([,]\\s*\\w+\\s+\\w+(.*)//s*)*)*[)]"; // func dec regex
   // correct one private String pattern= "\\s*\\w+\\s+(\\w+)\\s*[(]((\\s*\\w+)(\\s+\\w+\\s*)([[](.*)\\[]])*\\s*([,](\\s*\\w+\\s+)\\w+\\s*([[](.*)\\[]])*\\s*)*)*[)]"; // func dec regex
    private String functionDeclarationPattern2="";//([,]\\s*\\[*]?\\s*\\w+\\[[](.*)\\[]])*\\s*[)]";
     private String pattern= "\\s*\\w+\\s+(\\w+)\\s*[(]((\\s*\\w+\\s*)(\\s+\\w+\\s*)?([[](.*)\\[]])*\\s*([,](\\s*\\w+)(\\s+\\w+\\s*)([[](.*)\\[]])*\\s*)*)*[)]"; // func dec regex
    private String fdp2="\\w+\\s+\\w+[(](\\w+[[]]\\[]])[)]";
    
    String fd="(\\w+\\s+\\w+)\\s*[(](.*)[)]";
    String fdi="^\\w+\\s*[*]*\\w+\\s*([[](.*)\\[]])*\\s*(,\\s*\\w+\\s*[*]*\\w+\\s*([[](.*)\\[]])*)*$";
    String fdp="^\\w+\\s*[*]*\\s*[&]*\\s*\\w+\\s*([[](.*)\\[]])*\\s*(,\\s*\\w+\\s*[*]*\\s*[&]*\\s*\\w+\\s*([[](.*)\\[]])*)*$";
    String fdi2="\\w+\\s*\\[[(.*)\\]]";
    String fdn="(\\w+\\s+\\w+)[(]\\s*[)]";
    //private String functionCallPattern="\\w+\\s*[(]\\w+(.*)(,\\s*\\w+(.*))*[)];"; // func call regex
   // private String functionCallPattern="\\w+\\s*[(]\\w+\\d*([[].*\\[]])*(,\\s*\\w+\\d*([[].*\\[]])*)*[)];"; // func call regex
    private String functionCallPattern="(\\w+)\\s*[(](s*\\w+(.*))([,]s*\\w+(.*))*s*[)]s*;";
    private String returnVariablePattern="(return\\s+)(.+[^;])"; // return statement regex
    private String functionDeclarationInputsPattern="(\\w+\\s+\\w+\\s*)((.*))";
    private String functionCallInputspattern="(\\w+\\s*)((.*)*)";
    private String nounsAndVerbsRegex="(.*)/(VB|NN|NNS)";
    private List <String>functionDeclarationsList=new ArrayList<String>();
    private String functionDeclaration;
    private String functionDeclarationInputs;
    private String outputVariable;
    private String functionCall;
    private String nounorverb="no";
private Map<String, List<String>> funcAdjList=new HashMap<>();
private List <String> calledFunctionsList=new ArrayList<String>();
Set<String> set = new LinkedHashSet<String>();

    public String getNounorverb() {
        return nounorverb;
    }

    public Map<String, List<String>> getFuncAdjList() {
        return funcAdjList;
    }

    public List<String> getCalledFunctionsList() {
        return calledFunctionsList;
    }

    public void setNounorverb(String nounorverb) {
        this.nounorverb = nounorverb;
    }

    public String getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(String functionCall) {
        this.functionCall = functionCall;
    }

    public String getFunctionCallInputs() {
        return functionCallInputs;
    }

    public void setFunctionCallInputs(String functionCallInputs) {
        this.functionCallInputs = functionCallInputs;
    }
    private String functionCallInputs;
  //  private String functionDeclarationInputsPattern="\\w*(,\\s*\\w+)*";

    public String getOutputVariable() {
        return outputVariable;
    }

    public void setOutputVariable(String outputVariable) {
        this.outputVariable = outputVariable;
    }

    public String getFunctionDeclarationInputs() {
        return functionDeclarationInputs;
    }

    public void setFunctionDeclarationInputs(String functionDeclarationInputs) {
        this.functionDeclarationInputs = functionDeclarationInputs;
    }

    public String getFunctionDeclaration() {
        return functionDeclaration;
    }

    public void setFunctionDeclaration(String functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }
    
    public boolean checkFunctionDeclaration(String line)
    {
        if (functionDeclarationsList.contains(line))
            return true;
        else
            return false;
    }
            
    public void extractDeclaredFunctions(String line)
    {
        Pattern declaredFunctionPattern=Pattern.compile(pattern);
        Matcher declaredFunctionMacther=declaredFunctionPattern.matcher(line);
        
        if (declaredFunctionMacther.find()&&!line.endsWith(";"))
        {
            functionDeclarationsList.add(declaredFunctionMacther.group(1).trim());
            //System.out.println(declaredFunctionMacther.group(1));
            
        }
        
        
    }
    
    public int patternMatching(String line) 
    {
        
        
        Pattern r=Pattern.compile(pattern);
        Matcher m=r.matcher(line);
        
        Pattern functionCall=Pattern.compile(functionCallPattern);
        Matcher functionCallMatcher=functionCall.matcher(line);
        
        Pattern returnVariable=Pattern.compile(returnVariablePattern);
        Matcher returnVariableMatcher=returnVariable.matcher(line);
        
        Pattern functionDeclaration2=Pattern.compile(fdp2);
        Matcher fD2Matcher=functionDeclaration2.matcher(line);
        
        Pattern fdPattern=Pattern.compile(fd);
        Matcher fdMatcher=fdPattern.matcher(line);
        
        Pattern fdnPattern=Pattern.compile(fdn);
        Matcher fdnMatcher=fdnPattern.matcher(line);
       
        Pattern fdiPattern=Pattern.compile(fdi);
        
        Pattern fdi2Pattern=Pattern.compile(fdi2);
        
        Pattern fdpPattern=Pattern.compile(fdp);
        Matcher fdpMatcher;
        
        
      /*  if (fdMatcher.find())
        {
          //System.out.println(fdMatcher.group(1));
        Matcher fdiMatcher=fdiPattern.matcher(fdMatcher.group(2));
        
        if (fdiMatcher.find())
        {
            
            System.out.println(fdMatcher.group(1)+"   "+fdiMatcher.group(0));
        }
        
        }
        
        if (fdnMatcher.find()&&!line.endsWith(";"))
            System.out.println(fdnMatcher.group(0));
        */
        if (fdMatcher.find()&&!line.contains(";"))
        {
            //System.out.println(line);
             Matcher fdiMatcher=fdiPattern.matcher(fdMatcher.group(2));
             fdpMatcher=fdpPattern.matcher(fdMatcher.group(2));
             //Pattern functionDeclarationInputs=Pattern.compile(functionDeclarationInputsPattern);
             
       //Matcher functionDeclarationInputsMatcher=functionDeclarationInputs.matcher(m.group(0));
      // throw new StringIdentifierException();
        if (fdiMatcher.find())          // prnting found data
        {
            if (fdiMatcher.group(0).contains("*"))
            {//System.out.println(fdiMatcher.group(0));
                String transformed=fdiMatcher.group(0).replace("*", " *");//doTransformPointer(fdiMatcher.group(0));
                setFunctionDeclarationInputs(transformed);
            }
        else
            {
               setFunctionDeclarationInputs(fdiMatcher.group(0)); 
            }
            calledFunctionsList.addAll(set);
            funcAdjList.put(functionDeclaration, calledFunctionsList);
        setFunctionDeclaration(fdMatcher.group(1));
        set.clear();
        calledFunctionsList=new ArrayList<String>();
            //System.out.println("my:" + functionDeclaration);
        return 1;
    
        }
        else if (fdpMatcher.find())
        {
           // System.out.println(fdpMatcher.group());
            String transformed3=doTransform3(fdpMatcher.group());
            setFunctionDeclarationInputs(transformed3);
            setFunctionDeclaration(fdMatcher.group(1));
            return 1;
        }
       /* else
        {
            Matcher fdi2Matcher=fdi2Pattern.matcher(fdMatcher.group(2));
            if (fdi2Matcher.find())
            {
                setFunctionDeclaration(fdMatcher.group(1));
        setFunctionDeclarationInputs(fdi2Matcher.group(0));
        return 1;
            }
        }*/
            //m=functionCallMatcher.matcher(line);
           // writeFunctionDeclaration(line);
            
            
             // capture inputs
            
        }
        if (fdnMatcher.find()&&!line.contains(";"))
        {
            setFunctionDeclaration(fdnMatcher.group(1));
        setFunctionDeclarationInputs("");
        calledFunctionsList=new ArrayList<String>();
        return 1;
        }
       /* else if (fD2Matcher.find())
        {
            System.out.println(fD2Matcher.group(0));
           return 10;
        }*/
      /*  else if (returnVariableMatcher.find())
        {
           // System.out.println(returnVariableMatcher.group(2));
            setOutputVariable(returnVariableMatcher.group(2));
           // System.out.println("this is output: "+getOutputVariable());
            //writeReturnStatement(line);
            return 3;
        }*/
        
        else if (functionCallMatcher.find() && checkFunctionDeclaration(functionCallMatcher.group(1)))
        {
            //System.out.println(functionCallMatcher.group(1));
            
            
            
            Pattern functionCallInputs=Pattern.compile(functionCallInputspattern);
            Matcher functionCallInputsMatcher=functionCallInputs.matcher(functionCallMatcher.group(0));
            
            if (functionCallInputsMatcher.find())
            {
               // System.out.println("FunctionCall: "+functionCallInputsMatcher.group(1));
               //System.out.println("Input:  "+functionCallInputsMatcher.group(2));
                
                //setFunctionCall(functionCallInputsMatcher.group(1));
                //setFunctionCallInputs(functionCallInputsMatcher.group(2));
                set.add(functionCallMatcher.group(1));
                //calledFunctionsList.add(functionCallMatcher.group(1));
                //calledFunctionsList.
                
                
               // System.out.println(functionDeclaration+": "+functionCallMatcher.group(1));
            }
            //writeFunctionCall(line);
            return 0;
        }
        
        
        else
        {
            //System.out.println("No");
        return 0;
        }
        
    } // function ends
    
    public String doTransformPointer(String line)
    {
        String tokens[]=line.split("\\*");
        tokens[0].concat(" "+"*"+tokens[1]);
        return tokens[0];
        
    }
    
    public String doTransform3(String line)
    {
        String varTokens[]=line.split(",");
        String finalVariable=null;
        String spacedTokens[]=null;
        String anp="*&";
        String var;
        String finalVar=null;
       // if (varTokens.length>1)
        {
        for (int x=0;x<varTokens.length;x++)
        {
            if (varTokens[x].contains("*") && varTokens[x].contains("&"))
            {
                spacedTokens=varTokens[x].replace("*", " ").replace("&", " ").split("\\s+");
                var=anp.concat(spacedTokens[1].trim());
                finalVar=spacedTokens[0].trim().concat(" "+var);
               
                if (x==0)
                    finalVariable=finalVar; //dealing with very first argument
                else
                    finalVariable=finalVariable.concat(","+finalVar);
            }
            else if (varTokens[x].contains("*"))
            {
                String tokens[]=varTokens[x].replace("*", " ").split("\\s+");
                finalVar=tokens[0].trim().concat(" *"+tokens[1].trim());
                
                if (x==0)
                    finalVariable=finalVar; //dealing with very first argument
                else
                    finalVariable=finalVariable.concat(","+finalVar);
            }
            
            else if (varTokens[x].contains("&"))
            {
                String tokens[]=varTokens[x].replace("&", " ").split("\\s+");
                finalVar=tokens[0].trim().concat(" &"+tokens[1].trim());
                
                if (x==0)
                    finalVariable=finalVar; //dealing with very first argument
                else
                    finalVariable=finalVariable.concat(","+finalVar);
            }
            else
            {
                if (x==0)
                    finalVariable=varTokens[x];
                else
                    finalVariable=finalVariable.concat(","+varTokens[x]);
            }
            
        } // for ends
        
        System.out.println(finalVariable);
        return finalVariable;
    } // multiple arguments condition ends
       
        
    } // func ends
    public void getNounsAndVerbs (String pattern)
    {
        Pattern posPattern=Pattern.compile(nounsAndVerbsRegex);
        Matcher m=posPattern.matcher(pattern);
        
        if (m.find())
        {
            //System.out.println("---->"+m.group(1)+"  type: "+m.group(2));
           // return (m.group(1)+" type: "+m.group(2));
            setNounorverb(m.group(1)+"  type: "+m.group(2));
        }
       // else
        //return "no";
        
    } // func ends
    
    
   
    
}  //class ends
