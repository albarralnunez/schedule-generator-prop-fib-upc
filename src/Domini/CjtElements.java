/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miquel Masriera
 */
public class CjtElements implements Serializable {

    /**
     * valid diu si aquell conjunt es valid
     */
    private boolean valid;
    
    private ArrayList<Element> assignacions;

    /**
     * Creadora 
     */
    public CjtElements() {
        valid = false;
        assignacions = new ArrayList<Element>();
    }

    /**
     * Afegeix un element.
     * @param e A element que volem afegir
     */
    public void afegirElement(Element e) {
        assignacions.add(e);
    }

    /**
     * 
     * @return Retorna si el conjunt d'elements es valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     *
     * @param valid True si el conjunt es valid false si no ho es
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     *
     * @return Retorna totes les assignacions que s'han fet
     */
    public ArrayList<Element> getAssignacions() {
        return assignacions;
    }

    /**
     *
     * @param pos enter, representa una posicio del conjunt d'elements
     * @return Retorna l'element que hi ha a la posicio pos.
     */
    public Element getElementPosicio(int pos) {
        return assignacions.get(pos);
    }

    /**
     *
     * @return Retorna el numero d'elements del conjutn
     */
    public int numeroElements() {
        return assignacions.size();
    }


    /**
     * 
     * @param e Element que es vol borrar
     * @return Retorna true si s'ha pogut borra l'element false en cas contari
     */
    boolean borrarElement(Element e) {
        return assignacions.remove(e);
    }
}
