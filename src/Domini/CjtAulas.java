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
public class CjtAulas {
    
    private ArrayList<Aula> cjtAulas;
    
    public CjtAulas(){
        cjtAulas = new ArrayList<Aula>();
    }
    
    public void AñadirAula(Aula aula){
        cjtAulas.add(aula);
    }
    
    public void BorrarAula(Aula aula) {
        if (!cjtAulas.remove(aula)) {
            throw new Error ("No exsiste el aula");
        }
    }
}
   
