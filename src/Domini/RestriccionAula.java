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
    
    public ArrayList AulaDispoible(Aula aula, CjtAulas cjtAulas) {
        ArrayList L = new ArrayList();
        L = cjtAulas.GetCjtAulas();
        L.remove(aula);
        return L;
    }
}
