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

    
    private String assignatura;
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

    /**
     * Es busca l'element en la clau y es retorna on booleà indicant el resultat
     * @param a, d, h son l'aula, el dia i l'hora que formen l'element a buscar
     * @return true si hem trobat l'element o false en cas contrari.
     */
/*    
    public boolean buscarElem(ClausulaNom c) {
        clausulaNom e = new clausulaNom();
        e.a = a;
        e.d = d;
        e.h = h;
        for(clausulaNom e1: clausula){
                if(e1 == e) return true;
        }
        return false;
    }
*/

    public void setGrup(Integer id) {
        this.grup = id;
    }

    public void setAssignatura(String nom) {
        this.assignatura = nom;
    }

    public void setDuracio(Integer h) {
        this.duracio = h;
    }


    public String getAssignatura() {
        return assignatura;
    }

    public Integer getDuracio() {
        return duracio;
    }

    public Integer getGrup() {
        return grup;
    }


}