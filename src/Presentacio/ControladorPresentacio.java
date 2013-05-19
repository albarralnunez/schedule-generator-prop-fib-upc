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

import Domini.CtrDomini;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author miquel.masriera
 */
public class ControladorPresentacio extends javax.swing.JFrame {
    
    CtrDomini cd;
    String unitatDocent;
    PanelLogin pLogin;
    PanelMenuPrincipal pMenup;
    PanelHorariLectiu pHorariLectiu;
    PanelGeneracioAssignatures pGenAss;
    PanelModificarDades pModDades;
    PanelGeneracioAules pGenAul;

    public ControladorPresentacio() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        pLogin = new PanelLogin(this);
        pMenup = new PanelMenuPrincipal(this);
        pHorariLectiu = new PanelHorariLectiu(this);
        pGenAss = new PanelGeneracioAssignatures(this);
        pModDades = new PanelModificarDades(this);
        pGenAul = new PanelGeneracioAules(this);
        
        this.Layered.add(pLogin);
        this.Layered.add(pMenup);
        this.Layered.add(pHorariLectiu);
        this.Layered.add(pGenAss);
        this.Layered.add(pModDades);
        this.Layered.add(pGenAul);
        canviaPanel("login");
    }
    
    
    /**
     * el que fa aquesta funció es mostrar en el frame principal el panell que se li
     * indica.
     * primer de tot fa invisibles tots els panells i després només activa el que 
     * s ha de mostrar 
     * 
     * @param nomPanel nom del panell a mostrar
     */
    public void canviaPanel(String nomPanel){
        pLogin.setVisible(false);
        pMenup.setVisible(false);
        pHorariLectiu.setVisible(false);
        pGenAss.setVisible(false);
        pModDades.setVisible(false);
        pGenAul.setVisible(false);

        if(nomPanel.equals("login")) pLogin.setVisible(true);
        else if(nomPanel.equals("menuPrincipal")) {
            pMenup.setNomUnitatDocent(unitatDocent);
            pMenup.setVisible(true);
        }
        else if (nomPanel.equals("PanelHorariLectiu")) {
            pHorariLectiu.carregaConfHoraria();
            pHorariLectiu.setVisible(true);
        }
        //else if (nomPanel.equals("GeneracioAssignatures")) pGenAss.setVisible(true);
        else if (nomPanel.equals("PanelModificarDades")) {
            pModDades.inicialitza();
            pModDades.setVisible(true);
        }
        else if (nomPanel.equals("PanelGeneracioAssignatures")) {
            pGenAss.setVisible(true);
        }
        else if (nomPanel.equals("PanelGeneracioAules")) {
            pGenAul.setVisible(true);
        }
        
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
            .addComponent(Layered, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Layered;
    // End of variables declaration//GEN-END:variables

    public void mostraAvis(String text) {
        //PODEMOS TENER UN SEGUNDO PARAMETRO QUE INDICARA QUE TIPO DE AVISO ES PARA MOSTRAR UN WARNING_MESSAGE O OTRO TIPO DE MENSAJE.
        //TIPOS DE MENSAJE: WARNING_MESSAGE, ERROR_MESSAGE, PLAIN_MESSAGE, INFORMATION_MESSAGE
        JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public void identificarUnitatDocent(String nomUnitatDocent) {
        System.out.println(nomUnitatDocent);
        unitatDocent = nomUnitatDocent;
        cd = new CtrDomini(unitatDocent);
    }

    public ArrayList<String> llistaAssignatures() {
        return cd.llistaAssignatures();
        
    }

    public ArrayList<String> llistaAules() {
        return cd.llistaAules();
    }

    public ArrayList<String> llegeixConfiguracioHoraria(){
        return cd.llegeixConfiguracioHoraria();
    }

    public void guardaConfiguracioHoraria( ArrayList conf) {
        cd.escriuConfigurcioHoraria(conf);
    }

    public boolean existeixConfiguracioHoraria() {
        return cd.existeixConfiguracioHoraria();
    }
    
    public String getNomUnitatDocent(){
        return this.unitatDocent;
    }

    public ArrayList<String> mostraParametresAssignatura(String nomAss) {
        return cd.mostraParametresAssignatura(nomAss);
    }

    public ArrayList<String> mostraParametresAula(String nomaul) {
        String tipo_aula = nomaul.substring(0, 9);
        nomaul = nomaul.substring(9, nomaul.length()); //QUITAMOS EL aula-teo-
        nomaul = nomaul.substring(this.unitatDocent.length()+1, nomaul.length());
        if (tipo_aula.equals("aula-teo-")) {
            return cd.llegirAulaTeo(nomaul);
        } else {
            return cd.llegirAulaLab(nomaul);
        }
    }

}