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

    private class clausulaNom {
        String a; //Aula
        String d; //Dia
        int h; //Hora
    }
    
    private String assignatura;
    private Integer grup;
    private Integer duracio;
    private ArrayList<clausulaNom> clausula;

    //Constructora
    public Clausula() {
        clausula = new ArrayList<clausulaNom>();
        grup = null;
        duracio = null;
        assignatura = null;
    }

    //Métodos


    /**
    * S'afegeix l'element e a la clausula.
    * @param a, d, h son l'aula el día i l'hora.
    */

    public void afegirElem(String a, String d, Integer h) {
        clausulaNom e = new clausulaNom();
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
        clausulaNom e = new clausulaNom();
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
        clausulaNom e = new clausulaNom();
        e.a = a;
        e.d = d;
        e.h = h;
        for(clausulaNom e1: clausula){
                if(e1 == e) return true;
        }
        return false;
    }


    public void setGrup(Integer id) {
        this.grup = id;
    }

    public void setAssignatura(String nom) {
        this.assignatura = nom;
    }

    public void setDuracio(Integer h) {
        this.duracio = h;
    }


    public String getAssignatura() {
        return assignatura;
    }

    public Integer getDuracio() {
        return duracio;
    }

    public Integer getGrup() {
        return grup;
    }


}