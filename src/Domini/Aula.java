    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel Albarral
 */
public class Aula {
    private String nombre;
    private int capacidad;

    
    /** 
    * Create a Aula.
    */
    public Aula() {
        nombre = null;
        capacidad = -1;
    }//end constructor Studentwqdsae
    
    /** 
    * Create a Aula.
    */
    public Aula(String nomAula, int capacitatAula) {
        nombre = nomAula;
        capacidad = capacitatAula;
    }
    
     /**
     *  
     * @return Returns the name of Aula.
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     *  
     * @return Returns the capacity of Aula.
     */
    public int getCapacidad(){
        return capacidad;
    }
    
     /**
     *  
     * @param nomAula A nombre.
     */
    public void setNom(String nomAula) {
        nombre = nomAula;
    }
    
    /**
     *  
     * @param capacitatAula A capacidad.
     */
    public void setCapacidad (int capacitatAula) {
        capacidad = capacitatAula;
    }
    
}
