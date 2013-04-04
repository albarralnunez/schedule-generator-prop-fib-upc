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
    
    /**
     * 
     * @param nom
     * @param a 
     */
    public void creaAssignatura( String nom, ArrayList a){
        ca.creaArxiu(nom, a);
    }
    
    public void creaAula( String nom, ArrayList a){
        ca.creaArxiu("aula-"+ nom, a);
    }
    
    public boolean existeix( String nom ){
        return ( ca.existeix(nom) ); // diu si existeix una assignatura amb aquell nom
    }
    
    public boolean esborraAssignatura( String nomAsg) { // nomAsg = UD-nom
        return ca.esborra( nomAsg);
    }

    public ArrayList llistaAssignatures(String nomUnitat) {
        return ca.llistaDirectori(nomUnitat); // te totes les assignatures de la unitat docent
        
        
    }
    public ArrayList LlistaAulas(String nomUnitat) {
        return ca.llegir(nomUnitat + "-aula-*"); //TODO: SE HA DE HACER UNA LECTORA PARA LAS AULAS
    }
    
    public ArrayList<String> llegirAssignatura( String nomAsg){
        return ca.llegir(nomAsg);
    }
}
