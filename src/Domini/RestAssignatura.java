/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

/**
 *
 * @author Joan Pol
 */
public class RestAssignatura extends Restriccio {
       Assignatura assignatura;
       int grup;
       String dia;
       int hora;

    public RestAssignatura(){
        super(3);
        assignatura = null;
        grup = -1;
        dia = null;
        hora = -1;
    }
    public RestAssignatura(Assignatura assignatura, int grup, String dia, int hora){
        super(3);
        this.assignatura = assignatura;
        this.grup = grup;
        this.dia = dia;
        this.hora = hora;
    }
    public void setAssignatura(Assignatura assignatura){
        this.assignatura = assignatura;
    }
    public void setGrup(int grup){
        this.grup = grup;
    }
    public void setDia(String dia){
        this.dia = dia;
    }
    public void setHora(int hora){
        this.hora = hora;
    }
    public Assignatura getAssignatura(){
        return assignatura;
    }
    public int getGrup(){
        return grup;
    }
    public String getDia(){
        return dia;
    }
    public int getHora(){
        return hora;
    }
    public boolean everyday(){
        if(dia == null) return true;
        else return false;
    }
    public boolean everthour(){
        if(hora == -1) return true;
        else return false;
    }
    @Override
    public boolean CompleixRes(){return false;}
    
    
     public boolean esPotAfegir(CjtRestriccions cjtResAssig,CjtRestriccions cjtResGS) {
         ArrayList<Restriccio> llista = new ArrayList();
         llista = cjtResAssig.getCjtRes();
         int size = llista.size();
         for(int i = 0; i < size; ++i){
             Restriccio res = llista.get(i);
             RestAssignatura resdw = (RestAssignatura) res;
             if(resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup() == this.grup && resdw.getDia().equals(this.dia) && resdw.getHora() == this.hora) return false;
              //if(this.equals(resdw)) return false
         }
         llista = cjtResGS.getCjtRes();
         size = llista.size();
         for(int i = 0; i < size; ++i){
             Restriccio res = llista.get(i);
             RestGrupSesio resdw = (RestGrupSesio) res;
             if(resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup() == this.grup && resdw.getHora() == this.hora) return false;
         }
         return true;
    }
    
    public boolean compleixResHora(Assignatura assignatura, int grup, int hora) {
        boolean comp = true;
        if (this.assignatura.equals(assignatura) && this.grup == grup) {
            if(this.hora != hora) comp = false;
        }
        return comp;
    }
    public boolean compleixResDia(Assignatura assignatura, int grup, String dia){
        boolean comp = false;
        if(this.assignatura == assignatura && this.grup == grup){
            if(this.hora == hora) comp = true;
        }
        return comp;
    }
    
    public boolean CompleixResDiaHora(Assignatura assignatura, int grup, String dia,int hora){
        if(compleixResHora(assignatura, grup, hora) && compleixResDia(assignatura, grup, dia)) return true;
        else return false;
   }
    
}
