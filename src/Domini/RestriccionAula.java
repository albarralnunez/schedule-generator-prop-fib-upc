/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class RestriccionAula extends Restriccio{
    
    public RestriccionAula (int id) {
        super(id);
    }
    
    public boolean TieneMaterial(AulaLab aula) {
       return aula.GetMaterial();
    }

}
