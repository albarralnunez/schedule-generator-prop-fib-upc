/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Joan Pol
 */
public class Titulacion {
    String nombre;
    
    public Titulacion(){
        nombre = null;
    }
    public Titulacion (String nom){
        nombre = nom;
    }
    public String GetNombre() {
        return nombre;
    }   
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
}
