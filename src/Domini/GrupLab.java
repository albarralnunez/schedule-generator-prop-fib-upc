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
public class GrupLab extends Grup {

    private boolean material; //Si es necesita pc
    /* private boolean mati; //si ha de ser de mati
     private boolean tarda;  // '' de tarda
     private boolean mixte;*/ //si es indiferent

   public GrupLab (int numero,int capacidad,boolean material,ArrayList l) {
        super(numero,capacidad,l);
        this.material = material;
    }

   //Creadora por defecto:

   public GrupLab() {
       super();
       this.material = false; //Por defecto no tiene material
   }

    
    public boolean GetMaterial(){
        return material;
    }
    
    public void SetMaterial(boolean mat){
        this.material = mat;
    }
}
