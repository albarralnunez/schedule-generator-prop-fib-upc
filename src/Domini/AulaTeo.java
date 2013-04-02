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
    
    private boolean proyector;
    
    /** 
    * Create a AulaLab.
    */
    public AulaTeo (String nombre, int capacidad, boolean proyecto) {
       super(nombre, capacidad);
       this.proyector = proyecto;
    }
    
    /**
     *  
     * @return Returns if the AulaLab has proyector.
     */
    public boolean getProyector(){
        return proyector;
    }
    
    /**
     *  
     * @param proyector.
     */    
    public void setProyector(boolean proyector){
        this.proyector = proyector;
    }
}
