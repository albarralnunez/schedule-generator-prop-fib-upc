/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
import java.util.Collections;

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
//TODO: Falta si la assigantura necesita cosas apra teo y lab
    private boolean material;
    private boolean projector;

    public Assignatura() {
    }

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

    public boolean necesitaMaterial() {
        return material;
    }

    public void setMaterial(boolean material) {
        this.material = material;
    }

    public boolean necesitaProjector() {
        return projector;
    }

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHoresT() {
        return horesT;
    }

    public void setHoresT(int horesT) {
        this.horesT = horesT;
    }

    public int getHoresP() {
        return horesP;
    }

    public void setHoresP(int horesP) {
        this.horesP = horesP;
    }

    public int getNivell() {
        return nivel;
    }

    public void setNivell(int nivel) {
        this.nivel = nivel;
    }

    public int getCapacitatTeo() {
        return capacitatTeo;
    }

    public void setCapacitatTeo(int capt) {
        capacitatTeo = capt;
    }

    public int getCapacitatLab() {
        return capacitatLab;
    }

    public void setCapacitatLab(int capl) {
        capacitatLab = capl;
    }

    public ArrayList<Integer> getIntervalsT() {
        return intervalsT;
    }

    public void setIntervalsT(ArrayList<Integer> it) {
        intervalsT = it;
    }

    public ArrayList<Integer> getIntervalsP() {
        return intervalsP;
    }

    public void setIntervalsP(ArrayList<Integer> ip) {
        intervalsP = ip;
    }

    public ArrayList<Integer> getGrups() {
        return grups;
    }

    public void setGrups(ArrayList<Integer> grupos) {
        this.grups.addAll(grupos);
        // Collections.sort(this.grupos);
    }

    public void addGrup(Integer grupo) {
        grups.add(grupo);
        //Collections.sort(this.grupos);
    }
}
