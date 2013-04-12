/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
public class AulaTeo extends Aula{
    
    private boolean projector;
    
    /** 
    * Crea un aula de laboratori.
    */
    public AulaTeo (String nom, int cap, boolean projector) {
       super(nom, cap);
       this.projector = projector;
    }
    
    /**
     *  
     * @return Retorna si l'aula te projector.
     */
    public boolean GetProjector(){
        return projector;
    }
    
    /**
     *  
     * @param projector.
     */    
    public void SetProyector(boolean projector){
        this.projector = projector;
    }
}
