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
public class RestriccioAssignatures /*extends Restriccio*/ {
    protected class restriccioAssig {
       String assignatura;
       String aula;
       int grup;
       String dia;
    }
    boolean abansTeoria;
    
    
    private ArrayList restriccions;
    
    public RestriccioAssignatures(){
        restriccions = new ArrayList();
    }
    public void setRestriccioAssig(String assig,String aul, int grp, String d, int h ) {
        restriccioAssig res;
        res = new restriccioAssig();
        res.assignatura = assig;
        res.aula = aul;
        res.grup = grp;
        res.dia = d;
        restriccions.add(res);
   }
    public void setRestricioAnterioritat(boolean b){
        abansTeoria = b;
    }
    
    public ArrayList getRestriccions(){
       return restriccions;
   }
    
   /*public boolean solapamentNivell(Horari h,String dia,int hora,CjtAssignatures cjtassig, int nivell){
     String assign = h.getAssignaturaElementX(dia, hora);
     int size = cjtassig.getCjtAssignatures().size();
     for(int i = 0; i < size; ++i){
         Assignatura a = cjtassig.getCjtAssignatures().get(i);
         if(a.getNom() == assign && a.getNivel() == nivell)
     }
   }*/
    
}
