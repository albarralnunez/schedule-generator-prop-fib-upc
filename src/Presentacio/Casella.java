/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author miquel
 * 
 * les caselles de la configuracio horaria
 * 
 */
public class Casella extends javax.swing.JPanel {
    
    int dia;
    int hora;
    boolean activada;
    
    /**
     * 
     * @param d  dia 
     * @param h hora
     */
    public Casella(int d, int h){ 
        dia = d;
        hora = h;
        activada = false;
        
        setBackground( new java.awt.Color( 255, 255, 255 ) );
        setBorder( javax.swing.BorderFactory.createLineBorder(Color.BLACK) );
        initComponents();
    }
    
    /**
     * 
     * @return si la casella esta activada
     */
    public boolean getEstat(){
        return activada;
    }
    
    /**
     * 
     */
    private void initComponents() {
        
        //MOUSE LISTENER
        addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent evt ){
                formMouseClicked(evt);
            }
        });
        
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap( 0, 400, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap( 0, 300, Short.MAX_VALUE)
        );
    }
    
    
    private void formMouseClicked(MouseEvent evt) {
        canviaEstat();
    }
    
    /**
     *  passa d'activada a desacivada i veceversa
     */
    public void canviaEstat(){
        if(activada){
            setBackground( new java.awt.Color( 255, 255, 255 ) ); //blanc
            activada = false;
        }
        else{
            setBackground( new java.awt.Color( 173, 255, 47 ) ); //verd
            activada = true;
        }
    }
    
    /**
     * desactiva la casella
     */
    public void reset(){
            setBackground( new java.awt.Color( 255, 255, 255 ) ); //blanc
            activada = false;
    }
    
}
