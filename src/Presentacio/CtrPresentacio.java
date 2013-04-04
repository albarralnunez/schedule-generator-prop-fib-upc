/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Domini.CtrDomini;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrPresentacio {
    
    static String unitatDocent;  // nom de la unitat docent
    static CtrDomini cd;
    static Scanner s;
    
    public static void main(String[] args) throws IOException {
        
        s = new Scanner( System.in ); // scanner d'entrada
        
        System.out.println("Nom de la unitat docent: ");
        unitatDocent = s.next();
        
        cd = new CtrDomini( unitatDocent );
      
        int opcio = 0;
        
        while( opcio != 5 ) {
            System.out.println(" MENU ");
            System.out.println(" 1 - generar horari");
            System.out.println(" 2 - cargar horari");
            System.out.println(" 3 - modificar dades");
            System.out.println(" 4 - logOut");
            System.out.println(" 5 - Tancar");
            System.out.println("");
            System.out.println(" Entra opcio");
            opcio = s.nextInt();
            
            if(opcio == 1) generar();
            else if(opcio == 2) carregar();
            else if(opcio == 3) modificar(); // la unica implementada
            else if(opcio == 4) logout();
        }
        System.out.println(" FIN ");      
    }
    
    private static void generar() {}

    private static  void carregar() {}
    
    private static void modificar() {
        
        int opcio = 0;
        while( opcio != 4 ) {
            System.out.println(" OPCIONS ");
            System.out.println("1-assignatures\n2-aules\n3-restriccions\n4-tornar");
            opcio = s.nextInt();
            
            if(opcio == 1) opcionsAsignatures();
            else if(opcio == 2) opcionsAules();
            else if(opcio == 3) opcionsRestriccions();
        }
    }
    
    private static  void opcionsAsignatures(){
        
        int opcio = 0;
        while( opcio != 4 ) {
            //llista les assignatures
            System.out.println(" Unitat Docent:"+unitatDocent+" llista d'assignatures:");
            ArrayList llista = cd.llistaAssignatures();
            for( int i = 0; i < llista.size(); ++i)
                
                System.out.println(llista.get(i) );
            System.out.println("");
            System.out.println(" OPCIONS ");
            System.out.println("1-crear\n2-esborrar\n3-modificar\n4-tornar");
            opcio = s.nextInt();
            
            System.out.println("");
            if(opcio == 1) creaAssignatura();
            else if(opcio == 2) esborraAssignatura();
            else if(opcio == 3) modificaAssignatura();
        }
        
    }
    
    private static void opcionsAules(){
        
    }

    private static void logout() {
        
    }
    
    private static void opcionsRestriccions(){
        
    }
   /*
    * Crea una assigatura (  un arxiu .txt amb tota la info)
    * nom de l arxiu (unitat docent)-(nom assignatura)
    * 
    * ara nomes posa el nom pero tenen que posarse i validar tots
    * els parametres
    */
    private static void creaAssignatura(){  
        
        System.out.println("nom de la assigatura a crear ");
        String nomAsg;
        nomAsg = s.next(); // nom de la assignatura 
        if( cd.existeixAssignatura( nomAsg) ) System.err.println("ja existeix");
        else {
            System.out.println("hores de teoria ");
            int horest;
            horest = s.nextInt();
            System.out.println("hores de practica");
            int horesp;
            horesp = s.nextInt();
            System.out.println("nivell");
            int nivell = s.nextInt();
            cd.creaAssignatura( nomAsg, horest, horesp, nivell);
        }
    }
    
    private static void esborraAssignatura(){         
        System.out.println("nom de la assigatura a esborrar ");
        String nomAsg = s.next(); // nom de la assignatura 
        if( ! cd.esborraAssignatura(nomAsg) ) 
            System.err.println(nomAsg+" no existeix "); 
    }
    
    private static void modificaAssignatura() {
        System.out.println("nom de la assigatura a modificar ");
        String nomAsg;
        nomAsg = s.next(); // nom de la assignatura 
        if( ! cd.existeixAssignatura( nomAsg) ) 
            System.err.println(nomAsg+" no existeix");
        else {
            cd.printAssig(nomAsg);
            System.out.println("hores de teoria ");
            int horest;
            horest = s.nextInt();
            System.out.println("hores de practica");
            int horesp;
            horesp = s.nextInt();
            System.out.println("nivell");
            int nivell = s.nextInt();
            cd.creaAssignatura( nomAsg, horest, horesp, nivell);
        }
    }
    
    
}
