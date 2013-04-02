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

    public void generar() {
        
    }

    public void cargar() {
        
    }

    public void midificar() {
        
        sc = new Scanner( System.in );
        
        int opcio = 0;
        while( opcio != 4 ) {
            System.out.println(" OPCIONS ");
            System.out.println(" 1 - asignatures");
            System.out.println(" 2 - aules");
            System.out.println(" 3 - restriccions");
            System.out.println(" 4 - tornar");
            
            opcio = sc.nextInt();
            
            if(opcio == 1) opcionsAsignatures();
            else if(opcio == 2) opcionsAules();
            else if(opcio == 3) opcionsRestriccions();
        }
    }
    
    private void opcionsAsignatures(){

        int opcio = 0;
        while( opcio != 4 ) {
            
            // llista de totes les assignatures de la unitat docent
            System.out.println("C DOMINI OPCIONS ASG -> de la "+nomUnitat+" llista:");
            cper.llistaAssignatures( nomUnitat );
            
            System.out.println("");
            System.out.println(" OPCIONS ");
            System.out.println(" 1 - crear");
            System.out.println(" 2 - esborrar");
            System.out.println(" 3 - modificar");
            System.out.println(" 4 - tornar");
            
            opcio = sc.nextInt();
            
            System.out.println("");
            if(opcio == 1) creaAssignatura();
            else if(opcio == 2) esborraAssignatura();
            else if(opcio == 3) modificaAssignatura();
        }
        
    }
    
    private void opcionsAules(){
        
    }

    public void logout() {
        
    }
    
    private void opcionsRestriccions(){
        
    }
   /*
    * Crea una assigatura (  un arxiu .txt amb tota la info)
    * nom de l arxiu (unitat docent)-(nom assignatura)
    * 
    * ara nomes posa el nom pero tenen que posarse i validar tots
    * els parametres
    */
    private void creaAssignatura(){         
        System.out.println("nom de la assigatura a crear ");
        String nomAsg = sc.next(); // nom de la assignatura 
        
        if( cper.existeix( nomUnitat+"-"+nomAsg) ) {
            System.out.println(" ya existeix "); }// les assignatures es diuen ex: FIB-PROP
        else {
            Assignatura asg = new Assignatura(); // assignatura de prova
            asg.setNom(nomAsg);
            ArrayList params = new ArrayList();
            params.add(asg.getNom());
            
            cper.creaAssignatura( nomUnitat+"-"+nomAsg , params);
        }
    }
    
    private void modificaAssignatura() {
        
    }
    
    private void esborraAssignatura(){         
        System.out.println("nom de la assigatura a esborrar ");
        String nomAsg = sc.next(); // nom de la assignatura 
        
        if( ! cper.existeix( nomUnitat+"-"+nomAsg) ) 
            System.out.println(" aquesta assignatura no existeix "); 
        
        else {
            cper.esborraAssignatura( nomUnitat+"-"+nomAsg);
        }
    }
    
    
}
