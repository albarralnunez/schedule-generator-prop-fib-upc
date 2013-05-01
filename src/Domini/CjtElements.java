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
        assignacions = new ArrayList<Element>();
    }

    public void afegirElement (Element e) {
        assignacions.add(e);
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
    
    public Element getElementPosicio(int pos) {
        return assignacions.get(pos);
    }

    public int numeroElements() {
        return assignacions.size();
    }

    public boolean aulaRepetida(Element e) {
        for( int i = 0; i < assignacions.size(); ++i){
            if( assignacions.get(i).getAula().equals( e.getAula() ) ){ // si es la misma aula
                if( ! assignacions.get(i).equals(  e )  ) { // y no es el mismo elemtno
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solapamentTeoriaPractica(Element e) {
        //String asg = e.getAssignatura();
        boolean grupTeoria = false;
        if( (e.getGrupo()%10) == 0) grupTeoria = true;
        for( int i = 0; i < assignacions.size(); ++i){
            if( assignacions.get(i).getAssignatura().equals(e.getAssignatura()) ){ // si es la misma assignatura
                if( assignacions.get(i).getGrupo() != e.getGrupo() ){ // y no es el mismo elemento
                    int grup = assignacions.get(i).getGrupo();
                    if( grupTeoria) {
                       if( grup%10 != 0 ) {
                           
                           return true;
                       } //si ya habia teoria de esa asignatura SOLAPAMIENTO  
                    } 
                    else { // es grup de lab
                        if( grup%10 == 0) {
                            
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void borrarElement(Element e) {
        assignacions.remove(e);
    }

    boolean solapamentNivell(Element e) {
        for (Element ass : assignacions) {
            if (e.getAssignatura().getNivell() == 
                    ass.getAssignatura().getNivell()) {
                if (!(e.getAssignatura().equals(ass.getAssignatura())
                        && e.getGrupo() == ass.getGrupo())) return true;
            }
        }
        return false;
    }

    
    
    
    
    
}
