/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author miquel.masriera
 */
public class Assignatura {
    private String nom;
    private int horesT; // hores de teoria
    private int horesP; // hores de practica 
    private int nivel; 

    
    public Assignatura() {
        nom = null;
        horesT = -1;
        horesP = -1;
        nivel = -1;
    }

    public Assignatura( String nm, int ht, int hp, int nv) {
        nom = nm;
        horesT = ht;
        horesP = hp;
        nivel = nv;
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
}
