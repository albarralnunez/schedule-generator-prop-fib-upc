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
    private int horesT; // hores de teoria
    private int horesP; // hores de practica 
    private int nivel; 
    private int capacitatTeo;
    private int capacitatLab;
    private ArrayList<Integer> grupos;

    
    public Assignatura() {
        nom = null;
        horesT = -1;
        horesP = -1;
        nivel = -1;
        grupos = new ArrayList<Integer>();
    }

    public Assignatura( String nm, int ht, int hp, int nv,int capTeo, int capLab,ArrayList<Integer> a) {
        nom = nm;
        horesT = ht;
        horesP = hp;
        nivel = nv;
        capacitatTeo= capTeo;
        capacitatLab = capLab;
        grupos = a;
        
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
    public ArrayList<Integer> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Integer> a) {
        grupos.addAll(a);
        Collections.sort(grupos);
    }
    public void setGrupo(int grupo) {
        grupos.add(grupo);
        Collections.sort(grupos);
    }    
}
