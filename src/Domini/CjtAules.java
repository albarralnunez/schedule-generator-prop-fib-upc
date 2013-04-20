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
    public ArrayList<Aula> getCjtAules() {
        return cjtAules;
    }
    
    
    /**
     * 
     * @param aula 
     */
    public void afegirAula(Aula aula){
        cjtAules.add(aula);
    }
    
    /**
     * 
     * @param aula
     * @return Retorna si es posible esborrar l'aula amb nom aula.
     */
    public boolean esborrarAula(Aula aula) {
        return (cjtAules.remove(aula));
    }
    
    /**
     * 
     * @param x
     * @return Retorna una llista amb les aules amb una capacitat major de x.
     */
    public CjtAules cjtCapacitatMajorDe (int x){
        CjtAules listaRefactor= new CjtAules();
        for (Aula A: cjtAules) {
            if (A.capacitatMajorDe(x)) listaRefactor.getCjtAules().add(A);       
        }
        return listaRefactor;
    }
}
   
