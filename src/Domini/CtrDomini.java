/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrDomini {
    
    CtrPersistencia cper;
    String nomUnitat;
    Scanner sc;
    
    public CtrDomini( String nomU ){
       
        nomUnitat = nomU;
        cper = new CtrPersistencia(); 
    }


   /*
    * Crea una assigatura (  un arxiu .txt amb tota la info)
    * nom de l arxiu (unitat docent)-(nom assignatura)
    * 
    * ara nomes posa el nom pero tenen que posarse i validar tots
    * els parametres
    */
    public void creaAssignatura( String nomAsg, int ht, int hp, int nivel ){ 
            ArrayList params = new ArrayList();
            params.add(nomAsg);
            params.add(ht);
            params.add(hp);
            params.add(nivel);
            cper.creaAssignatura( nomUnitat+"-"+nomAsg , params);
    }
   
    /**
     * 
     * @param nomAsg
     * @return 
     */
    public boolean esborraAssignatura( String nomAsg){         
        String nom = nomUnitat+"-"+nomAsg;
        return( cper.esborraAssignatura(nom) );
        
    }
    /**
     * 
     * @return 
     */
    public ArrayList llistaAssignatures( ){
        return cper.llistaAssignatures(nomUnitat);
    }

    public boolean existeixAssignatura(String nomAsg) {
        return cper.existeix(nomUnitat+"-"+nomAsg);
    }

    
    public void printAssig( String nomaAsg){
        ArrayList<String> atributs = cper.llegirAssignatura(nomUnitat+"-"+nomaAsg);
        String n = atributs.get(0);
        int nt = Integer.parseInt(atributs.get(1));
        int np = Integer.parseInt(atributs.get(2));
        int nv = Integer.parseInt(atributs.get(3));
        System.out.println("els valors actuals de "+n+" son \n hteoria="+nt+"\n hpractica="+np+"\n nivel="+nv);
        Assignatura a = new Assignatura( atributs.get(0), nt, np, nv );
    }
    
}
