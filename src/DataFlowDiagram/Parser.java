/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFlowDiagram;

/**
 *
 * @author Umair Khan
 */
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class Parser {
    MaxentTagger tagger;
    private String word;
    private StringIdentifier si=new StringIdentifier();

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public Parser() throws Exception
    {
      tagger = new MaxentTagger("C:\\Users\\Umair Khan\\Desktop\\NO4\\tagger\\bidirectional-distsim-wsj-0-18.tagger");
    }
    
    public void func () throws Exception
    {
        //MaxentTagger tagger = new MaxentTagger("C:\\Users\\Umair Khan\\Desktop\\NO4\\tagger\\bidirectional-distsim-wsj-0-18.tagger");
        // The sample string
 
       String sample = "My dog is watching cartoon and its so cool feel jar laptop airline flight happy user passenger motor sad variable split convert ";
 
// The tagged string
 
         // String tagged = tagger.tagString(sample);
 
// Output the result
 String tokens[]=sample.split(" ");
 for (int x=0;x<tokens.length;x++)
 {
    // String tokens2[]=tokens[x].split("/");
     //if (tokens2[1].equals("NN"))
         System.out.println(tagger.tagString(tokens[x]));
 }
 
//System.out.println(tagged);
    }
    
    public int doNounphrasing(String line)
    {
        String tagged=tagger.tagString(line);
       // tagged.replace("Main Function:", " ").replace("Inputs", " ").replace("Function:", tagged).replace("Output:", " ");
      // System.out.println(tagged);
     //   String temp[]=tagged.split("/");
        
       // if (temp[1].equals("NN") ||temp[1].equals("NNS"))
      // setWord(tagged+" NOUN");
      //  else if (temp[1].equals("VB"))
          //  setWord(tagged+" VERB");
       // else
        //tagged.sp
        si.getNounsAndVerbs(tagged);
        String temp=si.getNounorverb();
                   // System.out.println(temp);
                    setWord(temp);

        if (temp.equals("no"))
            return 0;
        else 
            return 1;
        /*String tokens[]=tagged.split(" ");
 for (int x=0;x<tokens.length;x++)
 {
     String tokens2[]=tokens[x].split("/");
     if (tokens2[1].equals("NN") || tokens2[1].equals("NNS") || tokens2[1].equals("VB"))
     { System.out.println(tokens2[0]+tokens2[1]);
     setWord(tokens2[0]+ " "+tokens2[1]);
     
     } // if ends
 }*/
        
    } // function ends
    
} // class ends
