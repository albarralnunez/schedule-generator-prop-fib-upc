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
    public AulaTeo (String nombre, int capacidad, boolean proyector) {
       super(nombre, capacidad);
       this.proyector = proyector;
    }
    
    /**
     *  
     * @return Returns if the AulaLab has proyector.
     */
    public boolean GetProyector(){
        return proyector;
    }
    
    /**
     *  
     * @param proyector.
     */    
    public void SetProyector(boolean proyector){
        this.proyector = proyector;
    }
}
