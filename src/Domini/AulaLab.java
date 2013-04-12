/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
public class AulaLab extends Aula{
    
    private boolean material;
    
    /** 
    * Crea un Aula de laboratori.
    */
    public AulaLab (String nom, int cap, boolean mat) {
        super(nom, cap);
        this.material = mat;
    }
    
    /**
     *  
     * @return Retorna si l'aula te material.
     */
    public boolean GetMaterial(){
        return material;
    }
    
    /**
     *  
     * @param mar A material
     */    
    public void SetMaterial(boolean material){
        this.material = material;
    }
}

