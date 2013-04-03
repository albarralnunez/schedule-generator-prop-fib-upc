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
    public String GetNombre() {
        return nombre;
    }
    
     /**
      * 
      * @return Returns the capacity of Aula.
      */
    public int GetCapacidad(){
        return capacidad;
    }
    
     /**
      * 
      * @param nombre 
      */
    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @param capacidad 
     */
    public void SetCapacidad (int capacidad) {
        this.capacidad = capacidad;
    }
    
    public boolean CapacidadMayorDe(int x) {
        return (capacidad > x);
    }            
}
