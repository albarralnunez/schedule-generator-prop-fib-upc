/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;


/**
 *
 * @author miquel.masriera
 */
public class Main {
    
    static ControladorPresentacio ctp;
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                    ctp = new ControladorPresentacio();
                
            }
        });
    }
}
