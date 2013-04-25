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
public class RestriccioGrups {
    protected class restriccio {
        int grup;
        String aula;
        int dia;
        int hora;
        String assignatura; 
    }
    ArrayList<restriccio> llistaRestGrups;
    
    public void setRestriccio(restriccio r){
        llistaRestGrups.add(r);
    }
    public void setRestriccio(int g, String aul, int d, int h,String assig){
       restriccio r = new restriccio();
       r.assignatura = assig;
       r.aula = aul;
       r.dia = d;
       r.grup = g;
       r.hora = h;
       llistaRestGrups.add(r);
    }
    public ArrayList getRestriccions(){
        return llistaRestGrups;
    }
    
}