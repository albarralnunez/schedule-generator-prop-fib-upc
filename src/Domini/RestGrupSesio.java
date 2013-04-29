/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

/**
 *
 * @author albertomarin
 */

//PONER UN ASSIG+GRUPO A UNA HORA
public class RestGrupSesio extends Restriccio{

    //Atributos
    private Assignatura assignatura;
    private Integer grup;
    private Integer hora; //Hora d'inici.

    //Constructora por defecto
    public RestGrupSesio() {
        super(2); //ID PRIVISIONAL 1002
    }

    public RestGrupSesio(Assignatura assignatura, Integer grup, Integer hora) {
        super(2);
        this.assignatura = assignatura;
        this.grup = grup;
        this.hora = hora;
    }

    //Getters y Setters
    public Assignatura getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(Assignatura assignatura) {
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

    public boolean CompleixRes(String assignatura, Integer grup, Integer hora) {
        boolean compleix = true; //Miramos si habla de la restriccion que afecta a nuestro grupo
        if (this.assignatura.getNom().equals(assignatura) && this.grup.equals(grup)) {
            if (this.hora != hora) compleix = false;
        }
        return compleix;
    }

    /**
     *
     * @param cjtRestGrupSesio Conjunt al que afeigir la noestra restriccio y en el que es poden produir incoherencies.
     * @return true si es pot afeigir al conjunt de restriccions del tipus o false si no es pot perque provoca alguna incoherencia.
     */

    public boolean esPotAfegir(CjtRestriccions cjtRestGrupSesio) {
        boolean espot = true;
        for (Restriccio res: cjtRestGrupSesio.getCjtRes()) {
            RestGrupSesio res_grup_sesio = (RestGrupSesio) res;
            if ((res_grup_sesio.getAssignatura().equals(this.assignatura)) && (res_grup_sesio.getGrup().equals(this.grup))) {
                //Si ya hay una restriccion que obliga a hacer la misma ASSIG+GRUPO en una hora, esta restriccion no podra añadirse al
                //CjtRestGrupSesio porque crearía conflicto con el resto.
                espot = false;
            }
        }
        return espot;
    }

}