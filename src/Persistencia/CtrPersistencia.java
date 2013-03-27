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
    
    public void creaAssignatura( String nom, ArrayList a){
        ca.creaArxiu(nom, a);
    }
    
    public boolean existeix( String nom ){
        return ( ca.existeix(nom) ); // diu si existeix una assignatura amb aquell nom
    }
    
    public void esborraAssignatura( String nomAsg) { // nomAsg = UD-nom
        ca.esborra( nomAsg);
    }

    public void llistaAssignatures(String nomUnitat) {
        ArrayList llista = ca.llistaDirectori(nomUnitat); // te totes les assignatures de la unitat docent
        System.out.println("ASSIGNATURES DE "+nomUnitat);
        for( int i = 0; i < llista.size(); ++i)
            System.out.println(llista.get(i) );
        
    }
}
