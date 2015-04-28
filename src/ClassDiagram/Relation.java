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
public class Relation {
    String relationType;

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getClasshavinginstance() {
        return classhavinginstance;
    }

    public void setClasshavinginstance(String classhavinginstance) {
        this.classhavinginstance = classhavinginstance;
    }

    public Relation(String classhavinginstance,String relationType ) {
        this.relationType = relationType;
        this.classhavinginstance = classhavinginstance;
    }
    String classhavinginstance;
}
