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
    * Create a AulaLab.
    */
    public AulaLab (String nombreAula, int capacidadAula, boolean mat) {
        super(nombreAula, capacidadAula);
        material = mat;
    }
    
    /**
     *  
     * @return Returns if the AulaLab has material
     */
    public boolean getMaterial(){
        return material;
    }
    
    /**
     *  
     * @param mar A material
     */    
    public void setMaterial(boolean mat){
        material = mat;
    }
}

