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
public class RestriccioAssignatures {
    protected class restriccioAssig {
       String assignatura;
       String aula;
       int grup;
       int dia;
       int hora;
    }
    
    private ArrayList<restriccioAssig> restriccions;
    
    public RestriccioAssignatures(){
        restriccions = new ArrayList();
    }
    public void setRestriccioAssig(String assig,String aul, int grp, int d, int h ) {
        restriccioAssig res;
        res = new restriccioAssig();
        res.assignatura = assig;
        res.aula = aul;
        res.grup = grp;
        res.dia = d;
        res.hora = h;
        restriccions.add(res);
   }
    public ArrayList getRestriccions(){
       return restriccions;
  }
    
    
}
