/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

/**
 *
 * @author Joan Pol
 */
public class GrupTeo extends Grup {
    private boolean proyector; //Si es necesita projector
    /* private boolean mati; //si ha de ser de mati
    private boolean tarda;  // '' de tarda
    private boolean mixte;*/ //si es indiferent
    
    public GrupTeo (int numero, int capacidad, boolean proyecto,ArrayList l) {
       super(numero, capacidad,l);
       this.proyector = proyecto;
    }
    
    public boolean GetProyector(){
        return proyector;
    }
    
    public void SetProyector(boolean proyector){
        this.proyector = proyector;
    }
} 
    
    
    
    