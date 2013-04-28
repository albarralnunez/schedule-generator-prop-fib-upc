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


    private String aula; //Aula
    private String dia; //Dia
    private int hora; //Hora
    
    public ClausulaNom() {
    }

    public ClausulaNom(String a, String d, int h) {
        this.aula = a;
        this.dia = d;
        this.hora = h;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
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
