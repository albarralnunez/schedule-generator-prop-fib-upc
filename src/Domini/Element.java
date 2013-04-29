/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
public class Element {

    private Aula aula;
    private Assignatura assignatura;
    private int grupo;
//    private String dia;
//    private int hora;
        
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
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
/*
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
  */     
}
