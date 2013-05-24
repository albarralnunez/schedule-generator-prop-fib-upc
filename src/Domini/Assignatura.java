/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author miquel.masriera
 */
public class Assignatura implements Serializable{

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
     *
     */
    public Assignatura() {
    }

    /**
     *
     * @param nm
     * @param niv
     * @param ht
     * @param inteT
     * @param hp
     * @param inteP
     * @param capT
     * @param capP
     * @param grups
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

    public void setGrupss(ArrayList<Integer> grupos) {
        this.grups = grupos;
    }
    
    /**
     * 
     * @param grupo 
     */
    public void addGrup(Integer grupo) {
        grups.add(grupo);
    }
}
