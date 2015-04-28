/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDiagram;

/**
 *
 * @author Umair Khan
 */
public class Attributes {
    private String name;
    private String type;
    private String modifier;

    @Override
    public boolean equals(Object o) {
        
    return name.equals(((Attributes)o).name);
    }
    
    
    public Attributes(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
