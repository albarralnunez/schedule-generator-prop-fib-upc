/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

/**
 *
 * @author Daniel Albarral
 */

//Forzar una aula a no poderse usar un dia/hora

class RestriccioAula extends Restriccio{

    private Aula aula;
    private Integer hora;
    private String dia;

    //Constructora por defecto:
    /**
     * Constructora per defecte
     */
    public RestriccioAula() {
        super (5); //ID PROVISIONAL
    }

    /**
     * Constructora que s'inicialitza amb els parametres introduits 
     *
     * @param aula Es l'aula que no podra ser usada.
     * @param hora l'hora en que l'aula que no podra ser usada.
     * @param dia el dia en que l'aula no podra ser usada.
     */
    public RestriccioAula(Aula aula, Integer hora, String dia) {
        super(5);
        this.aula = aula;
        this.hora = hora;
        this.dia = dia;
    }
    /**
     * Constructora que s'inicialitza amb els parametres introduits 
     * @param aula Es l'aula que no podra ser usada
     * @param dia el dia en que l'aula no podra ser usada
     */
    public RestriccioAula(Aula aula, String dia) { //UNA AULA NO PODRA ESTAR UNA DIA ENTERO.
        super(1003);
        this.aula = aula;
        this.hora = null;
        this.dia = dia;
    }

    //Getters y Setters
    /**
     * Retorna l'aula que no pot ser usada
     * @return Aula Aula que no pot ser usada
     */
    public Aula getAula() {
        return aula;
    }
    /**
     * Afegir la Aula que s'ha de restringir
     * @param aula Aula que s'ha de restringir
     */
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    /**
     * Obtenir la hora que no es pot utilitzar la hora
     * @return Hora que no es pot utilitzar la aula
     */
    public int getHora() {
        return hora;
    }
    /**
     * Afegir la hora que no es pot utilitzar la aula
     * @param hora Hora en la qual no es pot usar la aula
     */
    public void setHora(int hora) {
        this.hora = hora;
    }
    /**
     * Obtenir el dia que no es pot utilitzar la aula
     * @return Dia en el que no es pot usar la aula
     */
    public String getDia() {
        return dia;
    }
    /**
     * Afegir el dia en que no es pot utilitzar la aula
     * @param dia Dia que no es pot utilitzar la aula
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    /**
     * Obtenir el identificador de la restriccio
     * @return int Tipus de restriccio 
     */
    public int getId() {
        return id;
    }
    /**
     * Afegir id a la Restriccio
     * @param id Tipus de restriccio
     */
    public void setId(int id) {
        this.id = id;
    }
    @Override
    /**
     * 
     */
    public boolean CompleixRes() {return false;}

      /**
      * Comprova si la ClausulaNom cn compleix la restriccio del tipus 15
      * @param cn És la ClausulaNom ha comprobar
      * @param duracio És la duracio de la Clausula de cn
      * @return boolean que indica si cn compleix la restriccio o no
     */
   public boolean compleixRes15(ClausulaNom cn,int dur) {
        Aula aulaa = cn.getAula();
        int horaa = cn.getHora();
        String diaa = cn.getDia();
        boolean compleix = true;
        if (this.aula.getNom().equals(aulaa.getNom())) { //Si hablan de la aula que esta restringida
            if (this.hora != null) { //Si este aula no puede usarse un dia a una hora concreta...
                if (this.dia.equals(diaa)) {
                    if (this.hora >= horaa && this.hora < horaa+dur)
                        compleix = false; //Si se va a usar la hora que esta prohibida.
                }
            } else { //Si este aula no puede usarse un dia entero...
                if (this.dia.equals(diaa)) compleix = false;
            }
        }
        return compleix;
    }
   /**
    * Canvia el valor del String dia per un valor equivalent del tipus int 
    * @param dia EL dia a canviar
    * @return El valor de string en format int
    */
   private int canviDiaInt(String dia){
        int d = -1;
        if ( dia.equals("dilluns") ) d = 0;
        else if ( dia.equals("dimarts") ) d = 1;
        else if ( dia.equals("dimecres") ) d = 2;
        else if ( dia.equals("dijous") ) d = 3;
        else if ( dia.equals("divendres") ) d = 4;
        else if ( dia.equals("dissabte") ) d = 5;
        else if (dia.equals("diumenge"))d = 6;
        return d;
    }
   /**
     * Comprova si la ClausulaNom cn compleix la restriccio del tipus 16
      * @param cn És la ClausulaNom ha comprobar
      * @param duracio És la duracio de la Clausula de cn
      * @return boolean que indica si cn compleix la restriccio o no
    */
   public boolean compleixRes16(ClausulaNom cn) {
        Aula aulaa = cn.getAula();
        String diaa = cn.getDia();
        if (this.aula.getNom().equals(aulaa.getNom())) { //Si hablan de la aula que esta restringida
            if (this.hora != null) { //Si este aula no puede usarse un dia a una hora concreta...
                if (this.dia.equals(diaa)) {
                    //if ((cn.getHora() > (this.hora+1)) && ((cn.getHora() + c.getDuracio()) > (this.hora+1))) return true;
                    //else return false;
                    if ((cn.getHora() < (this.hora+1))) return false;
                    else return true;
                }
                else if (canviDiaInt(diaa) < canviDiaInt(this.dia))return false;
                else if (canviDiaInt(diaa) > canviDiaInt(this.dia))return true;
            } else { //Si este aula no puede usarse un dia entero...
                if (this.dia.equals(diaa)) return false;
            }
        }
        return true;
    }
     /**
      * Comprova si la ClausulaNom cn compleix la restriccio del tipus 17
      * @param cn És la ClausulaNom ha comprobar
      * @param duracio És la duracio de la Clausula de cn
      * @return boolean que indica si cn compleix la restriccio o no
      */           
     public boolean compleixRes17(ClausulaNom cn,int duracio) {
        Aula aulaa = cn.getAula();
        String diaa = cn.getDia();
        if (this.aula.getNom().equals(aulaa.getNom())) { //Si hablan de la aula que esta restringida
            if (this.hora != null) { //Si este aula no puede usarse un dia a una hora concreta...
                if (this.dia.equals(diaa)) {
                    if ((cn.getHora() < this.hora) && ((cn.getHora() + duracio) > this.hora )) return false;
                    if ((cn.getHora() >= this.hora)) return false;
                    else return true;
                }
                else if (canviDiaInt(diaa) < canviDiaInt(this.dia))return true;
                else if (canviDiaInt(diaa) > canviDiaInt(this.dia))return false;
            } else { //Si este aula no puede usarse un dia entero...
                if (this.dia.equals(diaa)) return false;
            }
        }
        return true;
    }
}
