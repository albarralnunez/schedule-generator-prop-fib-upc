/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Joan Pol
 */
public class GrupoLab extends Grupo {
    private boolean pc; //Si es necesita pc
    /* private boolean mati; //si ha de ser de mati
    private boolean tarda;  // '' de tarda
    private boolean mixte;*/ //si es indiferent
    
    public GrupoLab (int numero,int capacidad,boolean pc) {
        super(numero,capacidad);
        
        
        
        this.pc = pc;
    }
}
