/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

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
    
    
    public boolean esPotCrear(CjtRestriccions cjtR) {
        return true;
    }
    
    public boolean CompleixRes(String assignaturaP, int grupP, String assignaturaS,int grupoS) {
       /* boolean comp = false;
        if()
        */
        return false;
    }
   // RestGrupoAula resdw = (RestGrupoAula) res;
}
