/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FramePrincipal.java
 *
 * Created on May 10, 2013, 12:54:40 PM
 */
package Presentacio;

import java.awt.Rectangle;

/**
 *
 * @author miquel.masriera
 */
public class ControladorPresentacio extends javax.swing.JFrame {
    
    PanelLogin pLogin;

    public ControladorPresentacio() {
        initComponents();
        this.setVisible(true);
        pLogin = new PanelLogin();
        pLogin.setBounds(0,0,700,500);
        this.Layered.add(pLogin);
        canviaPanel("login");
    }
    
    
    
    
    
    public void canviaPanel(String nomPanel){
        pLogin.setVisible(false);
        if(nomPanel.equals("login"))
            pLogin.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layered = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layered, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layered, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Layered;
    // End of variables declaration//GEN-END:variables
}
