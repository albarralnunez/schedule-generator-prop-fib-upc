/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
public class ClausulaNom {


    private Aula aula; 
    private String dia; 
    private int hora; 
    
    public ClausulaNom() {
    }

    public ClausulaNom(Aula a, String d, int h) {
        this.aula = a;
        this.dia = d;
        this.hora = h;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

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

   
    
}
