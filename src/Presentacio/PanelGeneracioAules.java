/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelGeneracioAules.java
 *
 * Created on 18-may-2013, 20:45:44
 */

package Presentacio;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author albertomarin
 */
public class PanelGeneracioAules extends javax.swing.JPanel {

    ArrayList<String> aules;
    ControladorPresentacio cp;

    /** Creates new form PanelGeneracioAules */
    public PanelGeneracioAules(ControladorPresentacio cpr) {
        cp = cpr;
        aules = new ArrayList<String>();
        initComponents();
        this.setBounds(0, 0, 700, 550);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        botoReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(686, 421));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Prem");
        jLabel1.setBounds(40, 30, 40, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Capacitat", "Projector", "Material"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(310, 40, 360, 370);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane2.setViewportView(jList1);

        jScrollPane2.setBounds(40, 70, 140, 340);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Afegir >");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(190, 80, 100, 25);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Editar..");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(190, 120, 100, 25);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(90, 30, 30, 25);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("Enrere");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(190, 350, 100, 25);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setText("Següent");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(190, 380, 100, 25);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botoReset.setText("Reset");
        botoReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoResetActionPerformed(evt);
            }
        });
        botoReset.setBounds(190, 160, 100, 25);
        jLayeredPane1.add(botoReset, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("per carregar les aules");
        jLabel2.setBounds(130, 30, 150, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton6.setText("Select All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.setBounds(190, 190, 100, 25);
        jLayeredPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //RESETEAMOS LA TABLA Y LAS AULAS
        aules = new ArrayList<String>();
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int n = modelo.getRowCount();
        for (int i = 0; i < n; i++) {
            modelo.removeRow(0);
        }
        cp.canviaPanel("PanelGeneracioAssignatures");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        ArrayList<String> Aules = cp.llistaAules();
        for (String aul : Aules) {
            aul = aul.substring(0, aul.length()-4); 
            listModel.addElement(aul);
        }
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cp.canviaPanel("PanelModificarDades");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        Object[] cadena = jList1.getSelectedValues();
        int h = cadena.length;
        if (h == 0) cp.mostraAvis("Seleccioni l'aula a afegir", "WARNING");
        else {
            String cadenaString;
            for (int i=0; i < h; i++){ //Para cada elemento seleccionado de la lista...
                //Si ya no lo hemos añadido...
                cadenaString = cadena[i].toString(); //YA TENEMOS LA ASSIGNATURA SELECCIONADA (aula-lab-FIB-A5001)
                String cadenaCompleta = cadenaString;
                cadenaString = cadenaString.substring(9, cadenaString.length()); //QUITAMOS aula-teo-
                String unitatDocent = cp.getNomUnitatDocent();
                cadenaString = cadenaString.substring(unitatDocent.length()+1, cadenaString.length()); //QUITAMOS EL FIB-

                if (aules.contains(cadenaString)) {
                    cp.mostraAvis("No es pot afegir de nou l'aula "+ cadenaString, "ERROR");
                } else {
                    aules.add(cadenaString);
                    int filas = jTable1.getRowCount();
                    modelo.addRow(new Object[filas]);
                    //AQUI HAY QUE IR ACCEDIENDO A CADA UNA DE LAS PROPIEDADES DEL AULA Y RELLENAR LA TABLA

                    ArrayList<String> param = cp.mostraParametresAula(cadenaCompleta);

                    for (int m = 0; m < param.size(); ++m) {
                        System.out.println(""+ param.get(m));
                    }

                    Integer tipo = Integer.parseInt(param.get(0)); //TIPO: 1 = TEO, 0 = LAB
                    jTable1.setValueAt(param.get(1), filas, 0); //NOMBRE
                    jTable1.setValueAt(param.get(2), filas, 1); //CAPACIDAD

                    if (tipo == 0) {
                        jTable1.setValueAt(false, filas, 2);
                        Integer material = Integer.parseInt(param.get(3)); //1 = TIENE, 0 = NO TIENE.
                        if (material == 0) jTable1.setValueAt(false, filas, 3);
                        else jTable1.setValueAt(true, filas, 3);
                    } else {
                        jTable1.setValueAt(false, filas, 3);
                        Integer projector = Integer.parseInt(param.get(3)); //1 = TIENE, 0 = NO TIENE.
                        if (projector == 0) jTable1.setValueAt(false, filas, 2);
                        else jTable1.setValueAt(true, filas, 2);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //EL ARRAYLIST aules tiene las aulas que van a usarse en la generación del horario
        cp.aulesSeleccionades(aules);
        cp.InicialitzaGenerador();
        
        cp.canviaPanel("PanelGeneracioRest");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void botoResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoResetActionPerformed
        
        aules = new ArrayList<String>();
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int n = modelo.getRowCount();
        for (int i = 0; i < n; i++) {
            modelo.removeRow(0);
        }
    }//GEN-LAST:event_botoResetActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      int end = jList1.getModel().getSize() - 1;
      if (end >= 0) jList1.setSelectionInterval(0, end);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    void reseteja() {
        aules = new ArrayList<String>();
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int n = modelo.getRowCount();
        for (int i = 0; i < n; i++) {
            modelo.removeRow(0);
        }
    }

}
