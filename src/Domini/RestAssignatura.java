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
public class RestAssignatura /*extends Restriccio*/ {
       String assignatura;
       int grup;
       String dia;
       int hora;
    
    public RestAssignatura(){
        assignatura = null;
        grup = -1;
        dia = null;
        hora = -1;
    }
    public RestAssignatura(String assignatura, int grup, String dia, int hora){
        this.assignatura = assignatura;
        this.grup = grup;
        this.dia = dia;
        this.hora = hora;
    }
    public void setAssignatura(String assignatura){
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
    public String getAssignatura(){
        return assignatura;
    }
    public int getGrup(){
        return grup;
    }
    public String getDia(){
        return dia;
    }
    public int hora(){
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
    
}
