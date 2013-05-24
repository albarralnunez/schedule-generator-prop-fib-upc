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
public class RestGrupSessio extends Restriccio{

    //Atributos
    private String assignatura;
    private Integer grup;
    private Integer dia;
    private Integer horaInici; //Hora d'inici.

    //Constructora por defecto
    public RestGrupSessio() {
        super(-1); //ID PRIVISIONAL 1002
    }

    public RestGrupSessio( String assignatura, Integer grup, Integer dia, Integer hora,int id) {
        super(id);
        this.assignatura = assignatura;
        this.grup = grup;
        this.dia = dia;
        this.horaInici = hora;
    }

    //Getters y Setters
    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura( String assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setGrup(Integer grup) {
        this.grup = grup;
    }

    public Integer getHora() {
        return horaInici;
    }
    
    public int getDia(){
        return dia;
    }
    public String getDiaString(){
        return canviIntStringDia();
    }
    public void setDia(String d){
        dia = canviStringIntDia(d);
    }
    public void setDia( int d){
        dia = d;
    }

    public void setHora(Integer hora) {
        this.horaInici = hora;
    }
    private int canviStringIntDia(String dia){
        if(dia.equals("dilluns"))return 0;
        else if(dia.equals("dimarts"))return 1;
        else if(dia.equals("dimecres"))return 2;
        else if(dia.equals("dijous"))return 3;
        else if(dia.equals("divendres"))return 4;
        else if(dia.equals("dissabte"))return 5;
        else if(dia.equals("diumenge"))return 6;
        return -1;
    }
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

    /*
     * NOMÉS S HA DE MIRAR AMB LA 1A HORA
     */
   /* public boolean CompleixRes(String assignatura, Integer grup, int dia, Integer hora) {
        boolean compleix = true; //Miramos si habla de la restriccion que afecta a nuestro grupo
        if ( this.assignatura.equals(assignatura) && this.grup.equals(grup)) {
            if( this.dia != dia) return false;
            if (this.horaInici != hora) compleix = false;
        }
        return compleix;
    }*/
    public boolean CompleixRes3(Clausula c,ClausulaNom cn) {
        if(c.getAssignatura().getNom().equals(this.assignatura) && c.getGrup() == this.grup){
            if(cn.getHora() == this.horaInici && canviStringIntDia(cn.getDia()) == this.dia) return true;
            else return false;
        }
        return true;
        
    }
    public boolean CompleixRes4(Clausula c,ClausulaNom cn) {
        if(c.getAssignatura().getNom().equals(this.assignatura) && c.getGrup() == this.grup){
            if (this.canviIntStringDia().equals(cn.getDia())) {
                if ((cn.getHora() < this.horaInici) && ((cn.getHora() + c.getDuracio()) > this.horaInici )) return false;
                if ((cn.getHora() >= this.horaInici)) return false;
                else return true;
            }
            else if (canviDiaInt(cn.getDia()) < this.dia)return true;
            else if (canviDiaInt(cn.getDia()) > this.dia)return false;
        }
        return true;
   }
    public boolean CompleixRes5(Clausula c,ClausulaNom cn) {
        if(c.getAssignatura().getNom().equals(this.assignatura) && c.getGrup() == this.grup){
            if (this.canviIntStringDia().equals(cn.getDia())) {
                if ((cn.getHora() < (this.horaInici+1))) return false;
                else return true;
            }
            else if (canviDiaInt(cn.getDia()) < this.dia)return false;
            else if (canviDiaInt(cn.getDia()) > this.dia)return true;
        }
        return true;
    }

    /**
     *
     * @param cjtRestGrupSesio Conjunt al que afeigir la noestra restriccio y en el que es poden produir incoherencies.
     * @return true si es pot afeigir al conjunt de restriccions del tipus o false si no es pot perque provoca alguna incoherencia.
     */

    public boolean esPotAfegir(CjtRestriccions cjtRestGrupSesio) {
        boolean espot = true;
        for (Restriccio res: cjtRestGrupSesio.getCjtRes()) {
            RestGrupSessio res_grup_sesio = (RestGrupSessio) res;
            if ((res_grup_sesio.getAssignatura().equals(this.assignatura)) && (res_grup_sesio.getGrup().equals(this.grup))) {
                //Si ya hay una restriccion que obliga a hacer la misma ASSIG+GRUPO en una hora, esta restriccion no podra añadirse al
                //CjtRestGrupSesio porque crearía conflicto con el resto.
                espot = false;
            }
        }
        return espot;
    }

}