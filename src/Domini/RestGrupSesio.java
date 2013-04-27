/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

/**
 *
 * @author albertomarin
 */
public class RestGrupSesio extends Restriccio{

    //Atributos
    private String assignatura;
    private Integer grup;
    private Integer hora; //Hora d'inici.

    //Constructora por defecto
    public RestGrupSesio() {
        super(1002); //ID PRIVISIONAL 1002
    }

    public RestGrupSesio(String assignatura, Integer grup, Integer hora) {
        super(1002);
        this.assignatura = assignatura;
        this.grup = grup;
        this.hora = hora;
    }

    //Getters y Setters
    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setGrup(Integer grup) {
        this.grup = grup;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    @Override
    public boolean CompleixRes() {return false;}

    public boolean esPotCrear(CjtRestriccions cjtR) {
        return true;
    }

    public boolean CompleixRes(String assignatura, Integer grup, Integer hora) {
        boolean compleix = true; //Miramos si habla de la restriccion que afecta a nuestro grupo
        if (this.assignatura.equals(assignatura) && this.grup.equals(grup)) {
            if (this.hora != hora) compleix = false;
        }
        return compleix;
    }
}