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
public class DataElement {
    private String child;
    private String parents;

    public DataElement(String child, String parents) {
        this.child = child;
        this.parents = parents;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }
    
    
}
