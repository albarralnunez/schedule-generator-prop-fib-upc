/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

import java.util.ArrayList;

/**
 *
 * @author Alberto Marin
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
    
    public Clausula(Clausula c) {
        this.grup = new Integer (c.getGrup());
        this.duracio = new Integer(c.getDuracio());
        Assignatura as = new Assignatura();
        as.setCapacitatLab(c.getAssignatura().getCapacitatLab());
        as.setCapacitatTeo(c.getAssignatura().getCapacitatTeo());
        as.setGrupss(c.getAssignatura().getGrups());
        as.setHoresP(c.getAssignatura().getHoresP());
        as.setHoresT(c.getAssignatura().getHoresT());
        as.setMaterial(c.getAssignatura().necesitaMaterial());
        as.setNivell(c.getAssignatura().getNivell());
        as.setNom(c.getAssignatura().getNom());
        as.setProjector(c.getAssignatura().necesitaProjector());
        as.setIntervalsP(c.getAssignatura().getIntervalsP());
        as.setIntervalsT(c.getAssignatura().getIntervalsT());
        this.assignatura = as;
        this.clausula = new ArrayList<ClausulaNom> (c.getClausula());
        
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