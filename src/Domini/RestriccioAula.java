/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
class RestriccioAula extends Restriccio{

    public RestriccioAula() {
        super (0);
    }
    private String aula;
    private int hora;
    private String dia;
    
    
    public String getAula() {
        return aula;
    }

    public RestriccioAula(String aula, int hora, String dia) {
        super(9);
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

    @Override
    public boolean CompleixRes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
