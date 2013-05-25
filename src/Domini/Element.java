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
        
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Assignatura getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public int getGrupo() {
        return grup;
    }

    public void setGrupo(int grup) {
        this.grup = grup;
    }
 
}
