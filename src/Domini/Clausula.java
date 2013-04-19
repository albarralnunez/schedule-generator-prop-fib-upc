/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

import java.util.ArrayList;

/**
 *
 * @author albertomarin
 */
public class Clausula {
    //TODO: Los dias son Strings las horas  Integers
    void setGrup(int id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    void setAssignatura(String nom) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setDuracio(Integer h) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class Element {
        String a;
        String d;
        int h;
    }
    private String assignatura;
    private int grup;
    private ArrayList<Element> clausula;

    //Constructora
    public Clausula() {
        clausula = new ArrayList<Element>();
    }

    //Métodos


    /**
    * S'afegeix l'element e a la clausla.
    * @param a, d, h son l'aula el día i l'hora.
    */

    public void afegirElem(String a, String d, Integer h) {
        Element e = new Element();
        e.a = a;
        e.d = d;
        e.h = h;
        clausula.add(e);
    }


    /**
     * S'esborra l'element e de la clausula
     * @param a, d, h son l'aula el dia i l'hora.
     */

    public boolean borrarElem(String a, String d, Integer h) {
        Element e = new Element();
        e.a = a;
        e.d = d;
        e.h = h;
        return clausula.remove(e);
    }

    /**
     * Es busca l'element en la clau y es retorna on booleà indicant el resultat
     * @param a, d, h son l'aula, el dia i l'hora que formen l'element a buscar
     * @return true si hem trobat l'element o false en cas contrari.
     */

    
    public boolean buscarElem(String a, String d, Integer h) {
        Element e = new Element();
        e.a = a;
        e.d = d;
        e.h = h;
        for(Element e1: clausula){
                if(e1 == e) return true;
        }
        return false;
    }

}