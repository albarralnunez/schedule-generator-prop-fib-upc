/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;

/**
 *
 * @author Daniel Albarral
 */
public class Element implements Serializable{

    private Aula aula;
    private Assignatura assignatura;
    private int grup;
    
    /**
     * Obtenir la Aula del element
     * @return Retorna la Aula del element
     */
    public Aula getAula() {
        return aula;
    }
    /**
     * Afegeix una aula al element
     * @param aula Aula que es vol afegir
     */
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    /**
     * Obtenir la Asignatura del element
     * @return Retorna la Assignatura del element
     */
    public Assignatura getAssignatura() {
        return assignatura;
    }
    /**
     * Afegeix una Assignatura al element
     * @param assignatura Assignatura que es vol afegir
     */
    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }
    /**
     * Obtenir el grup de la assignatura del element
     * @return Retorna el grup de la assignatura del element
     */
    public int getGrupo() {
        return grup;
    }
    /**
     * Afegeix el grup de la assignatura del element
     * @param grup Grup que es vol afegir
     */
    public void setGrupo(int grup) {
        this.grup = grup;
    }
 
}
