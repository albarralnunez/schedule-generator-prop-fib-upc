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

   
    /**
     * Creator of CjtAulas.
     */
    public CjtAulas(){
        cjtAulas = new ArrayList<Aula>();
    }
   
    public ArrayList<Aula> GetCjtAulas() {
        return cjtAulas;
    }
    
    
    /**
     * 
     * @param aula 
     */
    public void AñadirAula(Aula aula){
        cjtAulas.add(aula);
    }
    
    /**
     * 
     * @param aula 
     */
    public void BorrarAula(Aula aula) {
        if (!cjtAulas.remove(aula)) {
            throw new Error ("No exsiste el aula");
        }
    }
    
    
    /**
     * 
     * @param x
     * @return Return list of Aulas whit capacity greater than x.
     */
    public ArrayList CjtCapacidadMayorDe (int x){
        ArrayList listaRefactor = new ArrayList();
        for (Aula A: cjtAulas) {
            if (A.CapacidadMayorDe(x)) listaRefactor.add(A);       
        }
        return listaRefactor;
    }
}
   
