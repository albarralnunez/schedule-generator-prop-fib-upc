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
    /**
     * 
     * @param assignaturaP
     * @param grupP
     * @param assignaturaS
     * @param grupS 
     */
    public RestSolapament(Assignatura assignaturaP, int grupP, Assignatura assignaturaS, int grupS){
        super(0);
        this.assignaturaPrincipal = assignaturaP;
        this.grupPrincipal = grupP;
        this.assignaturaSolapament = assignaturaS;
        this.grupSolapament = grupS;
    }
    /**
     * 
     * @return 
     */
    public Assignatura getAssignaturaPrincipal() {
        return assignaturaPrincipal;
    }
    /**
     * 
     * @return 
     */
    public int getGrupPrincipal() {
        return grupPrincipal;
    }
    /**
     * 
     * @return 
     */
    public Assignatura getAssignaturaSolapament() {
        return assignaturaSolapament;
    }
    /**
     * 
     * @return 
     */
    public int getGrupSolapament() {
        return grupSolapament;
    }
    /**
     * 
     * @param assignaturaPrincipal 
     */
    public void setAssignaturaPrincipal(Assignatura assignaturaPrincipal) {
        this.assignaturaPrincipal = assignaturaPrincipal;
    }
    /**
     * 
     * @param grupPrincipal 
     */
    public void setGrupPrincipal(int grupPrincipal) {
        this.grupPrincipal = grupPrincipal;
    }
    /**
     * 
     * @param assignaturaSolapament 
     */
    public void setAssignaturaSolapament(Assignatura assignaturaSolapament) {
        this.assignaturaSolapament = assignaturaSolapament;
    }
    /**
     * 
     * @param grupSolapament 
     */
    
    public void setGrupSolapament(int grupSolapament) {
        this.grupSolapament = grupSolapament;
    }
    
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    
    /**
     * Comprova que les dos Clausules i Clausules Nom compleixin la restriccio
     * @param c Clausula
     * @param cn ClausulaNom
     * @param e Clausula 
     * @param hor La hora de la ClausulaNom de e
     * @param dia El dia de la ClausulaNom de e
     * @return 
     */
   public boolean CompleixRes(Clausula c, ClausulaNom cn, Clausula e, int hor,String dia){
       if(!(c.getAssignatura().getNom().equals(e.getAssignatura().getNom()) && c.getGrup() == e.getGrup())){
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
       else return true;
   }
  
}