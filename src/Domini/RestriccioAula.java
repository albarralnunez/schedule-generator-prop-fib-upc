/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
class RestriccioAula {

    public RestriccioAula() {
    }
    private String aula;
    private int hora;
    private String dia;
    
    
    public String getAula() {
        return aula;
    }

    public RestriccioAula(String aula, int hora, String dia) {
        this.aula = aula;
        this.hora = hora;
        this.dia = dia;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
}
