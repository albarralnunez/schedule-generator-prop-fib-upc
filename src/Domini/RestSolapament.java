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
    private Assignatura assignaturaPrincipal;
    private int grupPrincipal;
    private Assignatura assignaturaSolapament;
    private int grupSolapament;
    
    /** 
    * Crea una restriccion que indica que una assig+grupo no puede impartirse a la vez que otra temporalmente hablando
    */
    public RestSolapament(){
        super(4);
        assignaturaPrincipal = null;
        grupPrincipal = -1;
        assignaturaSolapament = null;
        grupSolapament = -1;
    }
    public RestSolapament(Assignatura assignaturaP, int grupP, Assignatura assignaturaS, int grupS){
        super(0);
        this.assignaturaPrincipal = assignaturaP;
        this.grupPrincipal = grupP;
        this.assignaturaSolapament = assignaturaS;
        this.grupSolapament = grupS;
    }

    public Assignatura getAssignaturaPrincipal() {
        return assignaturaPrincipal;
    }

    public int getGrupPrincipal() {
        return grupPrincipal;
    }

    public Assignatura getAssignaturaSolapament() {
        return assignaturaSolapament;
    }

    public int getGrupSolapament() {
        return grupSolapament;
    }

    public void setAssignaturaPrincipal(Assignatura assignaturaPrincipal) {
        this.assignaturaPrincipal = assignaturaPrincipal;
    }

    public void setGrupPrincipal(int grupPrincipal) {
        this.grupPrincipal = grupPrincipal;
    }

    public void setAssignaturaSolapament(Assignatura assignaturaSolapament) {
        this.assignaturaSolapament = assignaturaSolapament;
    }

    public void setGrupSolapament(int grupSolapament) {
        this.grupSolapament = grupSolapament;
    }
    
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    public boolean esPotAfegir(CjtRestSolapament cjtR) {
        ArrayList<Restriccio> llista = new ArrayList();
        llista = cjtR.getCjtRes();
        int size = llista.size();
        for(int i = 0; i < size; ++i){
            Restriccio res = llista.get(i);
            RestSolapament resdw = (RestSolapament) res;
            if(this.equals(resdw)) return false;
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
    /**
     *El Metode CompleixRes ens adverteix ,amb un bool, de si es compliria la restriccio si afegissim el element "e" en el dia "dia" a la hora "hora" de la quadricula q
     * @param q Quadricula a la qual li volem afegir-li el element
     * @param e Element que volem afegir 
     * @param dia Dia en el que volem afegir el element
     * @param hora Hora en la que volem afegir el element
     * @return Boolea que indica si es seguiria complint la restriccio un cop afegit el element
     */
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
    /**
     * CompleixRes(Quadricula q) comprova per a cada dia i hora de la quadricula q si es compleix la restriccio
     * @param q Quadricula que volem comprovar
     * @return Boolean que ens informa si compleix la restriccio per tot dia-hora de la quadricula
     */
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
   public boolean CompleixRes(Clausula c, ClausulaNom cn, Clausula e, int hor,String dia){
       Assignatura a1 = c.getAssignatura();
       Assignatura a2 = e.getAssignatura();
       int g1 = c.getGrup();
       int g2 = e.getGrup();
       boolean combinacio1 = false;
       boolean combinacio2 = false;
       if(this.grupPrincipal != -1 && this.grupSolapament != -1){
            combinacio1 =(a1.getNom().equals(this.assignaturaPrincipal.getNom())) && (g1 == this.grupPrincipal) && (a2.getNom().equals(this.assignaturaSolapament.getNom())) && (g2 == this.grupSolapament);
            combinacio2 = (a2.getNom().equals(this.assignaturaPrincipal.getNom())) && (g2 == this.grupPrincipal) && (a1.getNom().equals(this.assignaturaSolapament.getNom())) && (g1 == this.grupSolapament);
       }
       else {
            combinacio1 =(a1.getNom().equals(this.assignaturaPrincipal.getNom())) && (a2.getNom().equals(this.assignaturaSolapament.getNom()));
            combinacio2 = (a2.getNom().equals(this.assignaturaPrincipal.getNom())) &&(a1.getNom().equals(this.assignaturaSolapament.getNom()));  
       }
       if(combinacio1 || combinacio2) {
           if(dia.equals(cn.getDia()) && (hor-c.getDuracio() < cn.getHora() && hor >= cn.getHora()))return false;
           else return true;
       }
       return true;
   }
}