/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Domini.CtrDomini;
import java.util.Scanner;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrPresentacio {
    
    static String unitatDocent;  // nom de la unitat docent
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner( System.in ); // scanner d'entrada
        
        System.out.println("Nom de la unitat docent: ");
        unitatDocent = s.next();
        
        CtrDomini cd = new CtrDomini( unitatDocent );
        
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
            
            if(opcio == 1) cd.generar();
            else if(opcio == 2) cd.cargar();
            else if(opcio == 3) cd.midificar(); // la unica implementada
            else if(opcio == 4) cd.logout();
        }
        System.out.println(" FIN ");
          
    }
    
   
    
    
    
}
