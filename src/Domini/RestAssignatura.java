/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

/**
 *
 * @author Joan Pol Farre
 */
public class RestAssignatura extends Restriccio {
       private Assignatura assignatura;
       private int grup;
       private String dia;
       private int hora;
    /**
     * 
     */
    public RestAssignatura(){
        super(3);
        assignatura = null;
        grup = -1;
        dia = null;
        hora = -1;
    }
    /**
     * 
     * @param assignatura
     * @param grup
     * @param dia
     * @param hora 
     */
    public RestAssignatura(Assignatura assignatura, int grup, String dia, int hora){
        super(3);
        this.assignatura = assignatura;
        this.grup = grup;
        this.dia = dia;
        this.hora = hora;
    }
    /**
     * 
     * @param assignatura 
     */
    public void setAssignatura(Assignatura assignatura){
        this.assignatura = assignatura;
    }
    /**
     * 
     * @param grup 
     */
    public void setGrup(int grup){
        this.grup = grup;
    }
    /**
     * 
     * @param dia 
     */
    public void setDia(String dia){
        this.dia = dia;
    }
    /**
     * 
     * @param hora 
     */
    public void setHora(int hora){
        this.hora = hora;
    }
    /**
     * 
     * @return 
     */
    public Assignatura getAssignatura(){
        return assignatura;
    }
    /**
     * 
     * @return 
     */
    public int getGrup(){
        return grup;
    }
    /**
     * 
     * @return 
     */
    public String getDia(){
        return dia;
    }
    /**
     * 
     * @return 
     */
    public int getHora(){
        return hora;
    }
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public boolean CompleixRes(){return false;}
    
    /**
     * 
     * @param cn
     * @param duracio
     * @return 
     */
    public boolean compleixRes5(ClausulaNom cn, int duracio){
            if(this.hora != -1){
               if(this.hora >= cn.getHora() && (this.hora < cn.getHora() + duracio)) return false;
                //if(this.hora< cn.getHora()) return true;
                //else if(this.hora>cn.getHora()+duracio) return true;
                //else return false;
               else return true;
            }
       
        return true;
    }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes6(ClausulaNom cn){
            if(this.hora != -1){
                /*if ((cn.getHora() > (this.hora+1)) && ((cn.getHora() + c.getDuracio()) > (this.hora+1))) return true;
                else return false;*/
                if ((cn.getHora() < (this.hora+1))) return false;
                else return true;
            }
        return true;
    }
    /**
     * 
     * @param cn
     * @param duracio
     * @return 
     */
    public boolean compleixRes7(ClausulaNom cn,int duracio){
            if(this.hora != -1){
                //if ((cn.getHora() < this.hora) && ((cn.getHora() + duracio) > this.hora)) return false;
                //if ((cn.getHora() >= this.hora)) return false;
                //else return true;
                if(cn.getHora()>= this.hora) return false;
                else if(cn.getHora() + duracio > this.hora) return false;
                else if(cn.getHora() + duracio <= this.hora)return true;
            }
        return true;
    }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes8(ClausulaNom cn){
            if(this.dia != null){
                if(cn.getDia().equals(this.dia)) return false;
                else return true;
            }
        return true;
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
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes9(ClausulaNom cn){
            if(this.dia != null){
                int diaR = canviDiaInt(this.dia);
                int diaCn = canviDiaInt(cn.getDia());
                if(diaCn <= diaR) return false;
                else return true;
            }
        return true;
        
    }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes10(ClausulaNom cn){
            if(this.dia != null){
                int diaR = canviDiaInt(this.dia);
                int diaCn = canviDiaInt(cn.getDia());
                if(diaCn >= diaR) return false;
                else return true;
            }
        return true;
    }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes11(ClausulaNom cn){
            if(this.dia.equals(cn.getDia()) && this.hora == cn.getHora()) return false;
            else return true;
        
    }
    /**
     * 
     * @param cn
     * @return 
     */
    public boolean compleixRes12(ClausulaNom cn){
            if (this.dia.equals(cn.getDia())) {
                    //if ((cn.getHora() > (this.hora+1)) && ((cn.getHora() + c.getDuracio()) > (this.hora+1))) return true;
                    //else return false;
                    if ((cn.getHora() < (this.hora+1))) return false;
                    else return true;
            }
            else if (canviDiaInt(cn.getDia()) < canviDiaInt(this.dia))return false;
            else if (canviDiaInt(cn.getDia()) > canviDiaInt(this.dia))return true;
            return true;
    }
    /**
     * 
     * @param cn
     * @param duracio
     * @return 
     */
    public boolean compleixRes13(ClausulaNom cn,int duracio){
            if (this.dia.equals(cn.getDia())) {
                    if ((cn.getHora() < this.hora) && ((cn.getHora() + duracio) > this.hora )) return false;
                    if ((cn.getHora() >= this.hora)) return false;
                    else return true;
            }
            else if (canviDiaInt(cn.getDia()) < canviDiaInt(this.dia))return true;
            else if (canviDiaInt(cn.getDia()) > canviDiaInt(this.dia))return false;

            return true;
        
    }
}
