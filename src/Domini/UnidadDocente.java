/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Joan Pol
 */
public class UnidadDocente {
    String nombre;
    
    public UnidadDocente() {
        nombre = null;
    }
    public UnidadDocente(String nombre){
        this.nombre = nombre;
    }
    public String GetNombre() {
        return nombre;
    }   
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
}
