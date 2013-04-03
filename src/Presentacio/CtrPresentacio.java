/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Domini.CtrDomini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrPresentacio {
    
    static String unitatDocent;  // nom de la unitat docent
    
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner( System.in ); // scanner d'entrada
        
        System.out.println("Nom de la unitat docent: ");
        unitatDocent = s.next();
        
        CtrDomini cd = new CtrDomini( unitatDocent );
       
        System.out.println(" MENU ");
        System.out.println(" 1 - generar horari");
        System.out.println(" 2 - cargar horari");
        System.out.println(" 3 - modificar dades");
        System.out.println(" 4 - logOut");
        System.out.println(" 5 - Tancar");    
        System.out.println("");
        System.out.println(" Entra opcio");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        switch (x) {
            case(1): cd.generar();
            case(2): cd.cargar();
            case(3): cd.midificar();
            case(4): cd.logout();
        }
        
        System.out.println(" FIN ");     
    }
}
