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
    PanelVeureHoraris pVeuH;
    PanelGeneracioRest pGenR;

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
        pVeuH = new PanelVeureHoraris(this);
        pGenR= new PanelGeneracioRest(this);
        
        this.Layered.add(pLogin);
        this.Layered.add(pMenup);
        this.Layered.add(pHorariLectiu);
        this.Layered.add(pGenAss);
        this.Layered.add(pModDades);
        this.Layered.add(pGenAul);
        this.Layered.add(pVeuH);
        this.Layered.add(pGenR);
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
        pVeuH.setVisible(false);
        pGenR.setVisible(false);

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
        else if (nomPanel.equals("PanelVeureHoraris")) {
            pVeuH.setNomUnitatDocent(unitatDocent);
            pVeuH.setVisible(true);
        }
        else if (nomPanel.equals("PanelGeneracioRest")) {
            pGenR.setVisible(true);
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

    public void mostraAvis(String text, String tipo) {
        //PODEMOS TENER UN SEGUNDO PARAMETRO QUE INDICARA QUE TIPO DE AVISO ES PARA MOSTRAR UN WARNING_MESSAGE O OTRO TIPO DE MENSAJE.
        //TIPOS DE MENSAJE: WARNING_MESSAGE, ERROR_MESSAGE, PLAIN_MESSAGE, INFORMATION_MESSAGE
        if (tipo.equals("WARNING")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::WARNING", JOptionPane.WARNING_MESSAGE);
        else if (tipo.equals("ERROR")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::ERROR", JOptionPane.ERROR_MESSAGE);
        else if (tipo.equals("PLAIN")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::_", JOptionPane.PLAIN_MESSAGE);
        else if (tipo.equals("INFORMATION")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::INFO.", JOptionPane.INFORMATION_MESSAGE);
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
        nomaul = nomaul.substring(this.unitatDocent.length()+1, nomaul.length()); //QUITAMOS EL FIB-
        ArrayList<String> e = new ArrayList<String>();
        //return e;
        
        if (tipo_aula.equals("aula-teo-")) {    
            return cd.llegirAulaTeo(nomaul);
        } else {
            return cd.llegirAulaLab(nomaul);
        }
    }

    public void creaAula(String nom, boolean tipo, Integer capacitat, boolean proj, boolean mat, boolean modify) {
            if (!modify) if (cd.existeixAula(nom)) mostraAvis("No se puede crear una aula que ya existe!", "ERROR");
            int teo, boo;
            if (tipo) {
                //ES DE TEORIA:
                teo = 1;
                if (proj) boo = 1;
                else boo = 0;
                cd.creaAula(nom, capacitat, teo, boo);
            } else {
                teo = 0;
                if (mat) boo = 1;
                else boo = 0;
                cd.creaAula(nom, capacitat, teo, boo);
            }
        }


    public void esborraAula(String nomAula) {
         cd.esborraAula(nomAula);
    }

    public void afegirRestriccio(Integer i, ArrayList params) {
        cd.afegirRestriccio(i, params);
    }

    public boolean AfegirRestriccioGrupSessio(String ass, Integer grup, String dia, Integer hora, Integer opcio) {
        return cd.AfegirRestriccioGrupSessio(ass, grup, dia, hora, opcio);
    }

    public ArrayList< String> llistaRest(int opcio) {
        return cd.llistaRest(opcio);
    }

    public boolean esborrarAssignatura(String nomAsg) {
         if ( ! cd.esborraAssignatura(nomAsg)){
            mostraAvis("ERROR, no s ha pogut esborrar.", "ERROR");
            return false;
         }
         else 
            return true;
    }

    boolean existeixAsignatura(String nomAsg) {
        return cd.existeixAssignatura(nomAsg);
    }

}
