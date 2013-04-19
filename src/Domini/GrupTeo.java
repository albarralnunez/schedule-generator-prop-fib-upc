/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Joan Pol
 */
public class GrupTeo extends Grup {
    private boolean proyector; //Si es necesita projector
    /* private boolean mati; //si ha de ser de mati
    private boolean tarda;  // '' de tarda
    private boolean mixte;*/ //si es indiferent
    
    public GrupTeo (int numero, int capacidad, boolean proyecto) {
       super(numero, capacidad);
       this.proyector = proyecto;
    }
    
    public boolean GetProyector(){
        return proyector;
    }
    
    public void SetProyector(boolean proyector){
        this.proyector = proyector;
    }
} 
    
    
    
    