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
    private ArrayList<Integer> horesT; // hores de teoria
    private ArrayList<Integer> horesP; // hores de practica 
    private int nivel; 
    private int capacitatTeo;
    private int capacitatLab;
    private ArrayList<Grup> grups;

    
    public Assignatura() {
        nom = null;
        horesT = null;
        horesP = null;
        nivel = -1;
        grups = new ArrayList<Grup>();
    }

    public Assignatura( String nm, ArrayList ht, ArrayList hp, int nv,int capTeo, int capLab,ArrayList<Grup> grupos) {
        nom = nm;
        horesT = null;
        horesP = null;
        nivel = nv;
        capacitatTeo= capTeo;
        capacitatLab = capLab;
        this.grups = grupos;
        
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

    public ArrayList<Integer> getHoresT() {
        return horesT;
    }

    public void setHoresT(ArrayList<Integer> horesT) {
        this.horesT = horesT;
    }

    public ArrayList<Integer> getHoresP() {
        return horesP;
    }

    public void setHoresP(ArrayList<Integer> horesP) {
        this.horesP = horesP;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
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
    public ArrayList<Grup> getGrups() {
        return grups;
    }

    public void setGrupos(ArrayList<Grup> grupos) {
        this.grups.addAll(grupos);
       // Collections.sort(this.grupos);
    }
    
    public void setGrupo(Grup grupo) {
        grups.add(grupo);
        //Collections.sort(this.grupos);
    }    
}
