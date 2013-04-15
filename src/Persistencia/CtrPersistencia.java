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
    
    CtrDisc cdisc;
    CtrArxius ca;
    CtrObjectes co;
    
    public CtrPersistencia(){
        
        cdisc = new CtrDisc();
        ca = new CtrArxius(); 
        co = new CtrObjectes(); 
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
        return ca.llegirArxiu("assig-"+nomAsg);
    }
    
    /**
     * Crea un Aula de Teoria.
     * @param nom
     * @param a 
     * @return Retrona si es pot crear l'aula de teoria
     */
    public void creaAulaTeo(String nom, ArrayList a){
        if (existeixAula(nom)) esborraAula(nom);
        ca.creaArxiu("aula-teo-"+nom, a);
    }
    
    /**
     * Crea un Aula de Laboratori.
     * @param nom
     * @param a 
     * @return Retrona si es pot crear l'aula de laboratori
     */
    public void creaAulaLab(String nom, ArrayList a){
        if (existeixAula(nom)) esborraAula(nom);
        ca.creaArxiu("aula-lab-"+nom, a);
    }
    
    /**
     * Comprueba si existe el Aula nomAula
     * @param nomAula
     * @return Retorna si existe el aula nomAula
     */
     public boolean existeixAula(String nomAula) {
         return ca.existeix("aula-lab-"+nomAula) || ca.existeix("aula-teo-"+nomAula);
     }
     
     /**
      * Borra l'aula amb nom nomAula
      * @param nomAula
      * @return Retorna si existeix l'aula que es vol borra.
      */
     public boolean esborraAula(String nomAula) {
               return ca.esborra("aula-teo-"+nomAula) || ca.esborra("aula-lab-"+nomAula) ;
    }
    
    /**
     * 
     * @param nomUnitat
     * @return Llegeix un Aula
     */
    public ArrayList<String> llegirAula(String nomAula) {
        if (ca.existeix("aula-teo-"+nomAula))
            return ca.llegirArxiu("aula-teo-"+nomAula);
        else
            return ca.llegirArxiu("aula-lab-"+nomAula);
    }
  
     /**
     * 
     * @param nomUnitat
     * @return Retorna una lliste de totes les aules de la unitat decent nomUnitat
     */
    public ArrayList llistaAules(String nomUnitat) {
        ArrayList a = new ArrayList();
        a = ca.llistaDirectori("aula-teo-"+nomUnitat);
        a.addAll(ca.llistaDirectori("aula-lab-"+nomUnitat));
        return a; // te totes les assignatures de la unitat docent 
    }
    
      /**
     * 
     * @param nomUnitat
     * @return  Retorna una lista de toadas las aulas de la unidad docente nomUnitat.
     */
    public ArrayList llistaAulesTeo(String nomUnitat) {
        return ca.llistaDirectori("aula-teo-"+nomUnitat); // te totes les assignatures de la unitat docent 
    }
    
      /**
     * 
     * @param nomUnitat
     * @return  Retorna una lista de toadas las aulas de la unidad docente nomUnitat.
     */
    public ArrayList llistaAulesLab(String nomUnitat) {
        return ca.llistaDirectori("aula-lab-"+nomUnitat); // te totes les assignatures de la unitat docent 
    }

    
}
