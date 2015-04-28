/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataDictionary;

import ClassDiagram.Attributes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umair Khan
 */
public class Structs {
    private String name;
    private List<Attributes> attributesList=new ArrayList<Attributes>();

    public Structs(String name) {
        this.name = name;
    }

    public void setAttributesList(List<Attributes> attributesList) {
        this.attributesList = attributesList;
    }

    public String getName() {
        return name;
    }

    public List<Attributes> getAttributesList() {
        return attributesList;
    }
    
    
}
