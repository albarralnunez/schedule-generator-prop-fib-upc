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
    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
 
     /**
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
      * @param nombre 
      */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @param capacidad 
     */
    public void setCapacidad (int capacidad) {
        this.capacidad = capacidad;
    }
}
