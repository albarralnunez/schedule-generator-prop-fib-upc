/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrPersistencia {
    
    CtrArxius ca;
    
    public CtrPersistencia(){
        ca = new CtrArxius();  
    }
    
    public int nuemroArxius(){
       return ca.numArxius();
    }
    
    public ArrayList llistaAssigantures(String nomUnitat) {
        return ca.llistaDirectori("assig-"+nomUnitat); // te totes les assignatures de la unitat docent 
    }
    
    /**
     * 
     * @param nom
     * @param a 
     */
    public void creaAssignatura( String nom, ArrayList a){
        ca.creaArxiu("assig-"+nom, a);
    }
    
    public boolean existeixAssignatura( String nom ){
        return ( ca.existeix("assig-"+nom) ); // diu si existeix una assignatura amb aquell nom
    }
    
    public boolean esborraAssignatura( String nomAsg) { // nomAsg = UD-nom
        return ca.esborra("assig-"+nomAsg);
    }

    public ArrayList<String> llegirAssignatura( String nomAsg){
        return ca.llegir("assig-"+nomAsg);
    }
    
    /**
     * Crea un Aula.
     * @param nom
     * @param a 
     */
    public void creaAula(String nom, ArrayList a){
        ca.creaArxiu("aula-"+nom, a);
    }
    
    /**
     * Comprueba si existe el Aula nomAula
     * @param nomAula
     * @return Retorna si existe el aula nomAula
     */
     public boolean existeixAula(String nomAula) {
         return ca.existeix("aula-"+nomAula);
     }
     
     /**
      * Borra l'aula amb nom nomAula
      * @param nomAula
      * @return Retorna si existeix l'aula que es vol borra.
      */
     public boolean esborraAula(String nomAula) {
               return ca.esborra("aula-"+nomAula);
    }
    
    /**
     * 
     * @param nomUnitat
     * @return Retrona Una lista de todas las aules.
     */
    public ArrayList<String> llegirAula(String nomUnitat) {
        return ca.llegir("aula-"+nomUnitat);
    }
    
     /**
     * 
     * @param nomUnitat
     * @return  Retorna una lista de toadas las aulas de la unidad docente nomUnitat.
     */
    public ArrayList llistaAules(String nomUnitat) {
        return ca.llistaDirectori("aula-"+nomUnitat); // te totes les assignatures de la unitat docent 
    }
}
