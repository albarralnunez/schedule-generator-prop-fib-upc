/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.util.Scanner;

/**
 *
 * @author miquel.masriera
 */
public class Main {
    
    static ControladorPresentacio ctp;
    static CtrPresentacio cpres;
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("1 para el programa de toda la vida");
                System.out.println("2 para arrancar el tema interfaz");
                int i = sc.nextInt();
                if( i == 2)
                    ctp = new ControladorPresentacio();
                else {
                    cpres = new CtrPresentacio();
                    cpres.mayn();
                }
            }
        });
    }
}
