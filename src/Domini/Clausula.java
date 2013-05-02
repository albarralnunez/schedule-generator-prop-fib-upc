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

    
    private Assignatura assignatura;
    private Integer grup;
    private Integer duracio;
    private ArrayList<ClausulaNom> clausula;

    public ArrayList<ClausulaNom> getClausula() {
        return clausula;
    }

    //Constructora
    public Clausula() {
        clausula = new ArrayList<ClausulaNom>();
        grup = null;
        duracio = null;
        assignatura = null;
    }



    /**
    * S'afegeix l'element e a la clausula.
    * @param a, d, h son l'aula el día i l'hora.
    */

    //Métodos


    public void setClausula(ArrayList<ClausulaNom> clausula) {
        this.clausula = clausula;
    }


    public void afegirElem(ClausulaNom c) {
        clausula.add(c);
    }


    /**
     * S'esborra l'element e de la clausula
     * @param a, d, h son l'aula el dia i l'hora.
     */

    public boolean borrarElem(ClausulaNom c) {
        return clausula.remove(c);
    }

    public void setGrup(Integer id) {
        this.grup = id;
    }

    public void setAssignatura(Assignatura nom) {
        this.assignatura = nom;
    }

    public void setDuracio(Integer h) {
        this.duracio = h;
    }


    public Assignatura getAssignatura() {
        return assignatura;
    }

    public Integer getDuracio() {
        return duracio;
    }

    public Integer getGrup() {
        return grup;
    }

    void addClausula(ArrayList<ClausulaNom> cnaux) {
        this.clausula.addAll(cnaux);
    }


}