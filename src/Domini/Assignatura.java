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
    private ArrayList<Grupo> grupos;

    
    public Assignatura() {
        nom = null;
        horesT = -1;
        horesP = -1;
        nivel = -1;
        grupos = new ArrayList<Grupo>();
    }

    public Assignatura( String nm, int ht, int hp, int nv,int capTeo, int capLab,ArrayList<Grupo> grupos) {
        nom = nm;
        horesT = ht;
        horesP = hp;
        nivel = nv;
        capacitatTeo= capTeo;
        capacitatLab = capLab;
        this.grupos = grupos;
        
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
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos.addAll(grupos);
       // Collections.sort(this.grupos);
    }
    
    public void setGrupo(Grupo grupo) {
        grupos.add(grupo);
        //Collections.sort(this.grupos);
    }    
}
