/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */

//Forzar una aula a no poderse usar un dia/hora

class RestriccioAula extends Restriccio{

    private Aula aula;
    private Integer hora;
    private String dia;

    //Constructora por defecto:
    public RestriccioAula() {
        super (1003); //ID PROVISIONAL
    }

    /**
     * @pre: Si hora es null => Tot el dia.
     *
     * @param aula Es l'aula que no podra ser usada.
     * @param hora l'hora en que l'aula que no podra ser usada.
     * @param dia el dia en que l'aula no podra ser usada.
     */
    public RestriccioAula(Aula aula, Integer hora, String dia) {
        super(1003);
        this.aula = aula;
        this.hora = hora;
        this.dia = dia;
    }

    public RestriccioAula(Aula aula, String dia) { //UNA AULA NO PODRA ESTAR UNA DIA ENTERO.
        super(1003);
        this.aula = aula;
        this.hora = null;
        this.dia = dia;
    }

    //Getters y Setters
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
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
    public boolean CompleixRes() {return false;}

    public boolean CompleixRes(Aula aula, Integer hora, String dia) {
        boolean compleix = true;
        if (this.aula.equals(aula)) { //Si hablan de la aula que esta restringida
            if (this.hora != null) { //Si este aula no puede usarse un dia a una hora concreta...
                if (this.dia.equals(dia)) {
                    if (this.hora == hora) compleix = false;
                }
            } else { //Si este aula no puede usarse un dia entero...
                if (this.dia.equals(dia)) compleix = false;
            }
        }
        return compleix;
    }

    public boolean esPotAfegir() {
        return true;
    }



}
