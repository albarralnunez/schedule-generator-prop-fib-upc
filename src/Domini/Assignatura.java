/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author miquel.masriera
 */
public class Assignatura {

    private String nom;
    private int nivel;
    private int horesT;
    private int horesP;
    private ArrayList<Integer> intervalsT;
    private ArrayList<Integer> intervalsP;
    private int capacitatTeo;
    private int capacitatLab;
    private ArrayList<Integer> grups;
    private boolean material;
    private boolean projector;

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assignatura other = (Assignatura) obj;
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        return true;
    }

    /**
     * creadora por defecto
     */
    public Assignatura() {
    }

    /**
     * crea una assignatura i inicialitza els seus atributs
     *
     * @param nm nom
     * @param niv nivell
     * @param ht nombre d hores de teoria
     * @param inteT intervals de teoria
     * @param hp hores de practica
     * @param inteP intervals de practica
     * @param capT capacitat dels grups de teoria
     * @param capP capacitat dels grups de practica
     * @param grups grups de l assignatura
     */
    public Assignatura(String nm, int niv, int ht, ArrayList<Integer> inteT, int hp,
            ArrayList<Integer> inteP, int capT, int capP, ArrayList<Integer> grups) {
        nom = nm;
        nivel = niv;
        horesT = ht;
        intervalsT = inteT;
        horesP = hp;
        intervalsP = inteP;
        capacitatTeo = capT;
        capacitatLab = capP;
        this.grups = grups;
        material = false;
        projector = false;
    }

    /**
     *
     * @return
     */
    public boolean necesitaMaterial() {
        return material;
    }

    /**
     *
     * @param material
     */
    public void setMaterial(boolean material) {
        this.material = material;
    }

    /**
     *
     * @return
     */
    public boolean necesitaProjector() {
        return projector;
    }

    /**
     *
     * @param projector
     */
    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getHoresT() {
        return horesT;
    }

    /**
     *
     * @param horesT
     */
    public void setHoresT(int horesT) {
        this.horesT = horesT;
    }

    /**
     *
     * @return
     */
    public int getHoresP() {
        return horesP;
    }

    /**
     *
     * @param horesP
     */
    public void setHoresP(int horesP) {
        this.horesP = horesP;
    }

    /**
     *
     * @return
     */
    public int getNivell() {
        return nivel;
    }

    /**
     *
     * @param nivel
     */
    public void setNivell(int nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @return
     */
    public int getCapacitatTeo() {
        return capacitatTeo;
    }

    /**
     *
     * @param capt
     */
    public void setCapacitatTeo(int capt) {
        capacitatTeo = capt;
    }

    /**
     *
     * @return
     */
    public int getCapacitatLab() {
        return capacitatLab;
    }

    /**
     *
     * @param capl
     */
    public void setCapacitatLab(int capl) {
        capacitatLab = capl;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getIntervalsT() {
        return intervalsT;
    }

    /**
     *
     * @param it
     */
    public void setIntervalsT(ArrayList<Integer> it) {
        intervalsT = it;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getIntervalsP() {
        return intervalsP;
    }

    /**
     *
     * @param ip
     */
    public void setIntervalsP(ArrayList<Integer> ip) {
        intervalsP = ip;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getGrups() {
        return grups;
    }

    /**
     *
     * @param grupos
     */
    public void setGrups(ArrayList<Integer> grupos) {
        this.grups.addAll(grupos);
    }

    /**
     * afegeix el grup que es passa per paràmetre als d'aquella assignatura
     *
     * @param grup numero del grup que es vol afegir
     */
    public void addGrup(Integer grup) {
        grups.add(grup);
    }
}
