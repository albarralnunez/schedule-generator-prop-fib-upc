/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miquel Masriera
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
     * Creadora
     * @param nm A Nom de l'assigantura
     * @param niv Nivell de l'assigantura
     * @param ht Hores de teoria de l'assigantura
     * @param inteT Array amb els intervals de Teoria de l'assignatura
     * @param hp Hores de practica de l'assigantura
     * @param inteP Array amb els intervals de Laboratori de l'assigantura
     * @param capT Capacitat dels grups de teoria
     * @param capP Capacitat dels grups de practica
     * @param grups Array amb tots els grups de l'assignatura
     */
    public Assignatura(String nm, int niv, int ht, ArrayList<Integer> inteT, int hp,
            ArrayList<Integer> inteP, int capT, int capP, ArrayList<Integer> grups
            ,boolean mat, boolean proj) {
        nom = nm;
        nivel = niv;
        horesT = ht;
        intervalsT = inteT;
        horesP = hp;
        intervalsP = inteP;
        capacitatTeo = capT;
        capacitatLab = capP;
        this.grups = grups;
        material = mat;
        projector = proj;
    }

    /**
     * Consultora si necesita material.
     * @return Retorna fals si no necesita material y true si el necesita
     */
    public boolean necesitaMaterial() {
        return material;
    }

    /**
     * Seter de material
     * @param material Si necesita materia l'assigantura
     */
    public void setMaterial(boolean material) {
        this.material = material;
    }

    /**
     * Retorna si l'assigantura necesita projector
     * @return Retrona true si el necesita, false en cas contrari
     */
    public boolean necesitaProjector() {
        return projector;
    }

    /**
     * eter de projecotr
     * @param projector
     */
    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    /**
     *
     * @return Retorna el nom de l'assigantura
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom Nom de l'assignatura
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
     * @return nivell de l'assignatura
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
     * @return Capacitat dels grups de Teoria
     */
    public int getCapacitatTeo() {
        return capacitatTeo;
    }

    /**
     * 
     * @param capt A Capacitat dels gurps de teoria
     */
    public void setCapacitatTeo(int capt) {
        capacitatTeo = capt;
    }

    /**
     * 
     * @return Retorna la capacitat dels grups de laboratori
     */
    public int getCapacitatLab() {
        return capacitatLab;
    }

    /**
     * Inicialitzador de la capacitat de laboratori
     * @param capl
     */
    public void setCapacitatLab(int capl) {
        capacitatLab = capl;
    }

    /**
     * 
     * @return Retorna un array amb els intervals de teoria de l'assigantura
     */
    public ArrayList<Integer> getIntervalsT() {
        return intervalsT;
    }

    /**
     * Inicializador dels intervals de teoria
     * @param it Arraay amb els intervals de teoria de l'assignatura
     */
    public void setIntervalsT(ArrayList<Integer> it) {
        intervalsT = it;
    }

    /**
     *
     * @return Array amb els intervals de laboratori de l'assignatura
     */
    public ArrayList<Integer> getIntervalsP() {
        return intervalsP;
    }

    /**
     * Iniclitzador dels intervals de Laboratori
     * @param ip Array amb els intervals de laboratori de l'assignatura
     */
    public void setIntervalsP(ArrayList<Integer> ip) {
        intervalsP = ip;
    }

    /**
     * 
     * @return Retorna un array amb els grups de l'assignatura
     */
    public ArrayList<Integer> getGrups() {
        return grups;
    }

    /**
     * Afegeix un conjunt de grups a l'assignatura
     * @param grupos Array de grups que es volen afegir
     */
    public void setGrups(ArrayList<Integer> grupos) {
        this.grups.addAll(grupos);
    }
    
    /**
     * Inicialitzador de grups
     * @param grupos Array de grups de l'assigantura
     */
    public void setGrupss(ArrayList<Integer> grupos) {
        this.grups = grupos;
    }
    
    /**
     * Afegeix un grupo a l'assignatura
     * @param grupo Numero del grupo que se quiere añadir
     */
    public void addGrup(Integer grupo) {
        grups.add(grupo);
    }
}
