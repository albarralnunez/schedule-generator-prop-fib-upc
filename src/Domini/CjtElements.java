/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author miquel
 */
public class CjtElements {
    /**
     * valid diu si aquell conjunt es valid
     */
    private boolean valid;
    private ArrayList<Element> assignacions;
    
    public CjtElements(){
        valid = false;
        assignacions = null;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public ArrayList<Element> getAssignacions() {
        return assignacions;
    }

    
    
    
    
    
}