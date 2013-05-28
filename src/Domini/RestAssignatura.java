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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }/*
    public boolean everyday(){
        if(dia == null) return true;
        else return false;
    }
    public boolean everthour(){
        if(hora == -1) return true;
        else return false;
    }*/
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    /* public boolean esPotAfegir(CjtRestAssignatura cjtResAssig,CjtRestGrupSessio cjtResGS) {
         ArrayList<Restriccio> llista = new ArrayList();
         llista = cjtResAssig.getCjtRes();
         int size = llista.size();
         for(int i = 0; i < size; ++i){
             Restriccio res = llista.get(i);
             RestAssignatura resdw = (RestAssignatura) res;
             if(resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup
                     () == this.grup && resdw.getDia().equals(this.dia) && 
                     resdw.getHora() == this.hora) return false;
         }
         llista = cjtResGS.getCjtRes();
         size = llista.size();
         for(int i = 0; i < size; ++i){
             Restriccio res = llista.get(i);
             RestGrupSessio resdw = (RestGrupSessio) res;
             if( (resdw.getAssignatura().equals(this.assignatura.getNom())) && (resdw.getGrup() == this.grup) && (resdw.getHora() == this.hora) ) return false;
         }
         return true;
    }
    
    public boolean compleixResHora(Assignatura assignatura, int grup, int hora) {
        boolean comp = true;
        if (this.assignatura.equals(assignatura) && this.grup == grup) {
            if(this.hora == hora) comp = false;
        }
        return comp;
    }
    public boolean compleixResDia(Assignatura assignatura, int grup, String dia){
        boolean comp = true;
        if(this.assignatura == assignatura && this.grup == grup){
            if(this.dia.equals(dia)) comp = false;
        }
        return comp;
    }
    
    public boolean CompleixResDiaHora(Assignatura assignatura, int grup, String dia,int hora){
        if(compleixResHora(assignatura, grup, hora) && compleixResDia(assignatura, grup, dia)) return false;
        else return true;
   }

    public boolean compleixRes(Clausula c, ClausulaNom cn) {
        String d = cn.getDia();
        Integer h = cn.getHora();
        int g = c.getGrup();
        if(h !=-1 && dia != null){
            if (!CompleixResDiaHora(c.getAssignatura(), g, d, h)) return false;
        }
        else if(dia!=null){
            if (!compleixResDia(c.getAssignatura(), g, d)) return false;
        }
        else if(h != -1){
            if (!compleixResHora(c.getAssignatura(), g, h)) return false;
        }
        return true;
    }*/
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
    public boolean compleixRes6(ClausulaNom cn){
            if(this.hora != -1){
                /*if ((cn.getHora() > (this.hora+1)) && ((cn.getHora() + c.getDuracio()) > (this.hora+1))) return true;
                else return false;*/
                if ((cn.getHora() < (this.hora+1))) return false;
                else return true;
            }
        return true;
    }
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
    public boolean compleixRes8(ClausulaNom cn){
            if(this.dia != null){
                if(cn.getDia().equals(this.dia)) return false;
                else return true;
            }
        return true;
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
    public boolean compleixRes9(ClausulaNom cn){
            if(this.dia != null){
                int diaR = canviDiaInt(this.dia);
                int diaCn = canviDiaInt(cn.getDia());
                if(diaCn <= diaR) return false;
                else return true;
            }
        return true;
        
    }
    public boolean compleixRes10(ClausulaNom cn){
            if(this.dia != null){
                int diaR = canviDiaInt(this.dia);
                int diaCn = canviDiaInt(cn.getDia());
                if(diaCn >= diaR) return false;
                else return true;
            }
        return true;
    }
    public boolean compleixRes11(ClausulaNom cn){
            if(this.dia.equals(cn.getDia()) && this.hora == cn.getHora()) return false;
            else return true;
        
    }
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
