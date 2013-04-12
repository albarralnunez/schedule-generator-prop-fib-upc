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
public class CjtAules {
    
    private ArrayList<Aula> cjtAules;
    
   
    /**
     * Crea un conjunt d'Aules.
     */
    public CjtAules(){
        cjtAules = new ArrayList<Aula>();
    }
    
   
    /**
     * Retorna un conjunt d'Aules
     */
    public ArrayList<Aula> GetCjtAules() {
        return cjtAules;
    }
    
    
    /**
     * 
     * @param aula 
     */
    public void AfegirAula(Aula aula){
        cjtAules.add(aula);
    }
    
    /**
     * 
     * @param aula
     * @return Retorna si es posible esborrar l'aula amb nom aula.
     */
    public boolean EsborrarAula(Aula aula) {
        return (cjtAules.remove(aula));
    }
    
    /**
     * 
     * @param x
     * @return Retorna una llista amb les aules amb una capacitat major de x.
     */
    public ArrayList CjtCapacitatMajorDe (int x){
        ArrayList listaRefactor = new ArrayList();
        for (Aula A: cjtAules) {
            if (A.CapacitatMajorDe(x)) listaRefactor.add(A);       
        }
        return listaRefactor;
    }
}
   
