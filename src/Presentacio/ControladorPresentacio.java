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
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author miquel.masriera
 * 
 * aquesta classe controla tota la capa de pesentacio, es un frame que conté
 * i genstiona totes les vistes
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
    PanelVistaAules pva;
    PanelVistaHores pvh;
    
    ArrayList<String> aules;
    ArrayList<String> assignatures;

    /**
     * Creadora, inicialitza totes les vistes
     */
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
        pva = new PanelVistaAules(this);
        pvh = new PanelVistaHores(this);
        
        this.Layered.add(pLogin);
        this.Layered.add(pMenup);
        this.Layered.add(pHorariLectiu);
        this.Layered.add(pGenAss);
        this.Layered.add(pModDades);
        this.Layered.add(pGenAul);
        this.Layered.add(pVeuH);
        this.Layered.add(pGenR);
        this.Layered.add(pva);
        this.Layered.add(pvh);

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
        pva.setVisible(false);
        pvh.setVisible(false);

        if(nomPanel.equals("login")) pLogin.setVisible(true);
        else if(nomPanel.equals("menuPrincipal")) {
            pMenup.setNomUnitatDocent(unitatDocent);
            pMenup.setVisible(true);
        }
        else if (nomPanel.equals("PanelHorariLectiu")) {
            pHorariLectiu.carregaConfHoraria();
            pHorariLectiu.setVisible(true);
        }
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
            pVeuH.carregaLlistaHoraris();
            pVeuH.setVisible(true);
        }
        else if (nomPanel.equals("PanelGeneracioRest")) {
            pGenR.setVisible(true);
        }
        else if (nomPanel.equals("PanelVistaAules")){
            pGenAul.reseteja();
            pva.setHorariGenetar(true);////////////////////
            pva.setVisible(true);
        }
        else if (nomPanel.equals("PanelVistaHores")){
            pvh.pintaUsades("TOTES");
            assignatures = cd.AssignaturesUsades();
            pvh.posaAssignatures( assignatures );
            pvh.setVisible(true);
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

    
    /**
     * mostra una finestra de dialeg amb el text
     * 
     * @param text text a mostrar
     * @param tipo tius de missatge
     */
    public void mostraAvis(String text, String tipo) {
        if (tipo.equals("WARNING")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::WARNING", JOptionPane.WARNING_MESSAGE);
        else if (tipo.equals("ERROR")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::ERROR", JOptionPane.ERROR_MESSAGE);
        else if (tipo.equals("PLAIN")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::_", JOptionPane.PLAIN_MESSAGE);
        else if (tipo.equals("INFORMATION")) JOptionPane.showMessageDialog(this, text, "GeneradorHoraris::INFO.", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * 
     * @param nomUnitatDocent inicia tota la capa de domini per a aquesta unitat Docent
     */
    public void identificarUnitatDocent(String nomUnitatDocent) {
        unitatDocent = nomUnitatDocent;
        cd = new CtrDomini(unitatDocent);
    }

    /**
     * 
     * @return llista d assignatures usades
     */
    public ArrayList<String> llistaAssignatures() {
        return cd.llistaAssignatures();
    }

    /**
     * 
     * @return llista de totes les aules 
     */
    public ArrayList<String> llistaAules() {
        return cd.llistaAules();
    }

    /**
     * 
     * @return  retorna els dies i hores especificats en el document de configuraciio horaria per a assignar classes 
     */
    public ArrayList<String> llegeixConfiguracioHoraria(){
        return cd.llegeixConfiguracioHoraria();
    }

    /**
     * 
     * @param conf guarda els canvis fets en a cnfiguracio horaria
     */
    public void guardaConfiguracioHoraria( ArrayList conf) {
        cd.escriuConfigurcioHoraria(conf);
    }

    /**
     * 
     * @return cert si existeix un fitxer de configuracio oraria per a aquella unitat docent 
     */
    public boolean existeixConfiguracioHoraria() {
        return cd.existeixConfiguracioHoraria();
    }
    
    /**
     * 
     * @return el nom de la unitat docent 
     */
    public String getNomUnitatDocent(){
        return this.unitatDocent;
    }

    /**
     * 
     * @param nomAss
     * @return 
     */
    public ArrayList<String> mostraParametresAssignatura(String nomAss) {
        return cd.mostraParametresAssignatura(nomAss);
    }

    /**
     * 
     * @param nomaul
     * @return tots els paramentres de l'aula
     */
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

    /**
     * 
     * @param nom
     * @param tipo
     * @param capacitat
     * @param proj
     * @param mat
     * @param modify 
     */
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


    /**
     * 
     * @param nomAula 
     */
    public void esborraAula(String nomAula) {
         cd.esborraAula(nomAula);
    }

    /**
     * 
     * @param i
     * @param params 
     */
    public void afegirRestriccio(Integer i, ArrayList params) {
        cd.afegirRestriccio(i, params);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<String> getAssignatures(){
        return assignatures;
    }

    /**
     * 
     * @param nomAsg
     * @return 
     */
    public boolean esborrarAssignatura(String nomAsg) {
         if ( ! cd.esborraAssignatura(nomAsg)){
            mostraAvis("ERROR, no s ha pogut esborrar.", "ERROR");
            return false;
         }
         else 
            return true;
    }

    /**
     * 
     * @param nomAsg
     * @return 
     */
    public boolean existeixAsignatura(String nomAsg) {
        return cd.existeixAssignatura(nomAsg);
    }

    /**
     * crea una assignatura
     * 
     * 
     * @param nomAsg
     * @param nvl
     * @param ht
     * @param intsT
     * @param hp
     * @param intsP
     * @param capT
     * @param capL
     * @param grups
     * @param mat
     * @param proj 
     */
    public void creaAssignatura(String nomAsg, int nvl, int ht, 
            ArrayList<Integer> intsT, int hp, ArrayList<Integer> intsP, int capT, 
            int capL, ArrayList<Integer> grups, boolean mat, boolean proj) {
        cd.creaAssignatura(nomAsg, nvl, ht, intsT, hp, intsP, capT, capL, grups,mat,proj);
    }
    /**
     * donada una assignatura, et retorna totes aules que fa servir
     * 
     * @param as nom de l'assignatura 
     */
    public void aulesSeleccionades( ArrayList<String> as){
        aules = as;
        pva.posaConjuntAules(as);
    }
    
    
    /**
     * 
     * @param aules 
     */
    public void InicialitzaGenerador(ArrayList<String> aules){
        cd.inicialitzaGenerador(aules, assignatures);
        cd.inicialitzarClausules();
        cd.inicialitzarClausulesNom();
    }

       
    /**
     * intenta generar un horari, si pot l'imprimeix en un txt
     * 
     * @return cert si ha pogut generar un horari
     */
    public boolean generar() {
        if ( cd.generar() ){
            cd.imprimeixHorari();
            this.mostraAvis("S' ha guardat l horari generat en un txt", "INFORMATION");
            return true;
        }
        return false;  
    }

    /**
     * 
     * si no hi ha cap assignacio, a la primera posicio hi ha l String "BUIDA"
     * 
     * @param nomAula
     * @param d dia
     * @param h hora
     * @return donada una aula i una hora, retorna u string amb 2 posicions
     * a la primera hi ha la assignatura, i a la segona el grup
     */
    public ArrayList<String> aulaAssignadaALes(String nomAula, int d, int h) {
        return cd.aulaAssignadaALes(nomAula, d, h);
    }

    /**
     * 
     * 
     * @param nomH 
     * @return cert si ha pogut guardar l horari ammb el nom indicat 
     */
    public boolean guardar(String nomH) {
        if(  nomH == null )return false;
        return cd.guardaHorari(nomH);
    }

    /**
     * 
     * @return una llista amb els noms de tots els horaris que te guardats aquella unitat docent
     */
    public ArrayList<String> carregaLlistaHoraris() {
        return cd.carregaLlistaHoraris();
    }

    /**
     * carrega l horari indicat
     * 
     * @param nomhorari 
     */
    public void carregaHorari(String nomhorari) {
        boolean b = cd.carregarHorari(nomhorari);
        ArrayList<String> auls = cd.llistaAules();
        String nomun = cd.nomUnitatDocent();
       
        ArrayList<String> aulesnom = new ArrayList<String>();
        for( String au : auls){
            au = au.replace("aula-lab-"+nomun+"-", "");
            au = au.replace("aula-teo-"+nomun+"-", "");
            au = au.replace(".txt", "");
            aulesnom.add(au);
        }
        pva.posaConjuntAules(aulesnom);
        
        assignatures = cd.AssignaturesUsades();
        
        canviaPanel("PanelVistaAules");
    }

    /**
     * 
     * actualitza la llista d assignatures amb les que s han fet servi
     * 
     * @param ass actualitza la llista d assignatures amb les que s han fet servir
     */
    public void assigSeleccionades(ArrayList<String> ass) {
        assignatures = ass;
    }

    /**
     * 
     * carrega les restriccions guardades en el fitxer de text 
     * 
     * @param nomUnitatDocent 
     */
    public void carregarRestTxt(String nomUnitatDocent) {
        boolean a = cd.existeixRest(unitatDocent);
        if (a) {
            cd.montaRestriccions(unitatDocent);
            mostraAvis("S'han carregat les restriccions .txt satisfactoriament", "INFORMATION");
        }
        else mostraAvis("No s'han pogut carregar les restriccions", "ERROR");
    }

    /**
     * 
     * esborra l horari indicat
     * 
     * @param nomhorari 
     */
    public void esborraHorari(String nomhorari) {
        cd.esborraHorari(nomhorari);
    }

    /**
     * 
     * 
     * @param d dia
     * @param h hora
     * @param asg assignatura
     * @return cert si la assignatura ha estat assignada a alguna aula el dia d a la hora h
     */
    public boolean usada(int d, int h, String asg) {
        return cd.esUsada(d, h, asg);
    }

    /**
     * 
     * 
     * @param d dia
     * @param h hora
     * @param s nom de l assignatura
     * @return un string que conté totes les assignacions de la assingatura a aquell dia en aquella hora
     * assignacio = nomAssignatua+grup+aula
     */
    public String getAssignacio(int d, int h, String s) {
        String a = "";
        a = cd.getAssignacio(d, h, s);
        return a;
    }



    

}
