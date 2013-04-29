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
public class RestSolapament extends Restriccio{
    String assignaturaPrincipal;
    int grupPrincipal;
    String assignaturaSolapament;
    int grupSolapament;
    
    /** 
    * Crea una restriccion que indica que una assig+grupo no puede impartirse a la vez que otra temporalmente hablando
    */
    public RestSolapament(){
        super(0);
        assignaturaPrincipal = null;
        grupPrincipal = -1;
        assignaturaSolapament = null;
        grupSolapament = -1;
    }
    public RestSolapament(String assignaturaP, int grupP, String assignaturaS, int grupS){
        super(0);
        this.assignaturaPrincipal = assignaturaP;
        this.grupPrincipal = grupP;
        this.assignaturaSolapament = assignaturaS;
        this.grupSolapament = grupS;
    }
    public void setAssignaturaPrincipal(String assignaturaP){
        this.assignaturaPrincipal = assignaturaP;
    }
    public void setAssignaturaSolapamiento(String assignaturaS){
        this.assignaturaSolapament = assignaturaS;
    }
    public void setGrupPrincipal(int grupP){
        this.grupPrincipal =grupP;
    }
    public void setGrupSolapament(int grupS){
        this.grupSolapament = grupS;
    }
    public String getAssignaturaPrincipal(){
        return assignaturaPrincipal;
    }
    public String getAssignaturaSolapamiento(){
        return assignaturaSolapament;
    }
    public int getGrupPrincipal(){
        return grupPrincipal;
    }
    public int getGrupSolapament(){
        return grupSolapament;
    }
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    public boolean esPotAfegir(CjtRestriccions cjtR) {
        ArrayList<Restriccio> llista = new ArrayList();
        llista = cjtR.getCjtRes();
        int size = llista.size();
        for(int i = 0; i < size; ++i){
            Restriccio res = llista.get(i);
            RestSolapament resdw = (RestSolapament) res;
            if(this.equals(resdw)) return false;
            //if(this.assignaturaPrincipal == resdw.getAssignaturaPrincipal() && this.assignaturaSolapament == resdw.getAssignaturaSolapamiento() && this.grupPrincipal == resdw.getGrupPrincipal() && this.grupSolapament == resdw.getGrupSolapament()) return false;
        }
        return true;
    }
    
    private String transformaIntDia(int i){
        if (i == 0) return "dilluns"; 
        else if (i == 1) return "dimarts";
        else if (i == 2) return "dimecres";
        else if (i == 3) return "dijous";
        else if (i == 4) return "divendres";
        else if (i == 5) return "dissabte";
        else return "diumenge";
    }
    public boolean CompleixRes(Quadricula q, Element e, String dia,int hora) {
       boolean ass1 = false;
       boolean ass2 = false;
       boolean grup1 = false;
       boolean grup2 = false;
       CjtElements cjt = new CjtElements();
       cjt = q.getElementsPosicio(dia, hora);
       int size = cjt.numeroElements();
       if(e.getAssignatura().equals(assignaturaPrincipal)){
           ass1 = true;
           if(grupPrincipal >= 0){
               if(grupPrincipal != e.getGrupo()) ass1 = false;
               else grup1 = true;
           }
       }
       else if(e.getAssignatura().equals(assignaturaSolapament)){
            ass2 = true;
            if(grupSolapament >= 0){
               if(grupSolapament != e.getGrupo()) ass2 = false;
               else grup2 = true;
           }
       }
       if (ass1 == false && ass2 == false) return true;
       for(int i = 0; i < size; ++i){
           if(ass1 != false){
               if(cjt.getElementPosicio(i).getAssignatura().equals(assignaturaSolapament)) {
                    ass2 = true;
                    if(cjt.getElementPosicio(i).getGrupo() == grupSolapament) grup2 = true;
                }
           }
           else if(ass2 != false){
                if(cjt.getElementPosicio(i).getAssignatura().equals(assignaturaPrincipal)) {
                    ass1 = true;
                    if(cjt.getElementPosicio(i).getGrupo() == grupPrincipal) grup1 = true;
                }   
           }
            if(grupPrincipal <0 && grupSolapament < 0) {
                if(ass1 && ass2) return false;
            }
            else if(grupPrincipal <0 && grupSolapament >= 0){
                if(ass1 && ass2 && grup2) return false;
            }
            else if(grupPrincipal >=0 && grupSolapament < 0){
                if(ass1 && ass2 && grup1) return false;
            }
            else {
                if(ass1 && ass2 && grup1 && grup2) return false;
            }
        }
        return true;
   }
   public boolean CompleixRes(Quadricula q){
       boolean ass1;
       boolean ass2;
       boolean grup1;
       boolean grup2;
       
       CjtElements cjt = new CjtElements();
       for(int i=0; i < 7; ++i) {
            for (int j=0; j < 24; ++j) { 
                ass1 = false;
                ass2 = false;
                grup1 = false;
                grup2 = false;
                cjt = q.getElementsPosicio(transformaIntDia(i), j);
                for(int k = 0; k < cjt.numeroElements(); ++k){
                    if(cjt.getElementPosicio(k).getAssignatura().equals(assignaturaPrincipal)) {
                        ass1 = true;
                        if(cjt.getElementPosicio(k).getGrupo() == grupPrincipal) grup1 = true;
                    }
                    if(cjt.getElementPosicio(k).getAssignatura().equals(assignaturaSolapament)) {
                         ass2 = true;
                        if(cjt.getElementPosicio(k).getGrupo() == grupSolapament) grup2 = true;
                    }
                    if(grupPrincipal <0 && grupSolapament < 0) {
                        if(ass1 && ass2) return false;
                    }
                    else if(grupPrincipal <0 && grupSolapament >= 0){
                        if(ass1 && ass2 && grup2) return false;
                    }
                    else if(grupPrincipal >=0 && grupSolapament < 0){
                        if(ass1 && ass2 && grup1) return false;
                    }
                    else {
                        if(ass1 && ass2 && grup1 && grup2) return false;
                    }
               }
            }
      }
      return true;
    }
}