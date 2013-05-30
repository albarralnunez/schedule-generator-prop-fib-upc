/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

/**
 *
 * @author Alberto Marin
 */

//PONER UN ASSIG+GRUPO A UNA HORA
public class RestGrupSessio extends Restriccio{

    //Atributos
    private String assignatura;
    private Integer grup;
    private Integer dia;
    private Integer horaInici; //Hora d'inici.

    //Constructora por defecto
    /**
     * 
     */
    public RestGrupSessio() {
        super(-1); //ID PRIVISIONAL 1002
    }
    /**
     * 
     * @param assignatura
     * @param grup
     * @param dia
     * @param hora
     * @param id 
     */
    public RestGrupSessio( String assignatura, Integer grup, Integer dia, Integer hora,int id) {
        super(id);
        this.assignatura = assignatura;
        this.grup = grup;
        this.dia = dia;
        this.horaInici = hora;
    }

    //Getters y Setters
    /**
     * 
     * @return 
     */
    public String getAssignatura() {
        return assignatura;
    }
    /**
     * 
     * @param assignatura 
     */
    public void setAssignatura( String assignatura) {
        this.assignatura = assignatura;
    }
    /**
     * 
     * @return 
     */
    public Integer getGrup() {
        return grup;
    }
    /**
     * 
     * @param grup 
     */
    public void setGrup(Integer grup) {
        this.grup = grup;
    }
    /**
     * 
     * @return 
     */
    public Integer getHora() {
        return horaInici;
    }
    /**
     * 
     * @return 
     */
    public int getDia(){
        return dia;
    }
    /**
     * 
     * @return 
     */
    public String getDiaString(){
        return canviIntStringDia();
    }
    /**
     * 
     * @param d 
     */
    public void setDia(String d){
        dia = canviDiaInt(d);
    }
    /**
     * 
     * @param d 
     */
    public void setDia( int d){
        dia = d;
    }
    /**
     * 
     * @param hora 
     */
    public void setHora(Integer hora) {
        this.horaInici = hora;
    }
    /**
     * 
     * @return 
     */
    private String canviIntStringDia(){
        if(this.dia == 0) return "dilluns";
        if(this.dia == 1) return "dimarts";
        if(this.dia == 2) return "dimecres";
        if(this.dia == 3) return "dijous";
        if(this.dia == 4) return "divendres";
        if(this.dia == 5) return "dissabte";
        if(this.dia == 6) return "diumenge";
        return null;
    }
    /**
     * 
     * @param dia
     * @return 
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
    @Override
    public boolean CompleixRes() {return false;}

    /**
     * 
     * @param cn
     * @param duracio
     * @return 
     */
    public boolean CompleixRes3(ClausulaNom cn,int duracio) {
            if (this.canviIntStringDia().equals(cn.getDia())) {
                if ((cn.getHora() < this.horaInici) && ((cn.getHora() + duracio) > this.horaInici )) return false;
                if ((cn.getHora() >= this.horaInici)) return false;
                else return true;
            }
            else if (canviDiaInt(cn.getDia()) < this.dia)return true;
            else if (canviDiaInt(cn.getDia()) > this.dia)return false;
            return true;
   }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean CompleixRes4(ClausulaNom cn) {
            if (this.canviIntStringDia().equals(cn.getDia())) {
                if ((cn.getHora() < (this.horaInici+1))) return false;
                else return true;
            }
            else if (canviDiaInt(cn.getDia()) < this.dia)return false;
            else if (canviDiaInt(cn.getDia()) > this.dia)return true;
            return true;
    }

}