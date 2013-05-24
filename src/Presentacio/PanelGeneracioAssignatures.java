/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelGeneracioAssignatures.java
 *
 * Created on 13-may-2013, 21:20:53
 */

package Presentacio;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author albertomarin
 */
public class PanelGeneracioAssignatures extends javax.swing.JPanel {

    ControladorPresentacio cp;
    ArrayList<String> assignatures;

    //ONLOAD:

    /** Creates new form PanelGeneracioAssignatures */
    public PanelGeneracioAssignatures(ControladorPresentacio cpr) {
        cp = cpr;
        assignatures = new ArrayList();
        initComponents();
        //jButton5.doClick();
        this.setBounds(0, 0, 700, 500);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Nivell", "HoresT", "IntervalT", "HoresL", "IntervalL", "CapacitatT", "CapacitatL", "Grups"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        jScrollPane2.setBounds(0, 20, 660, 200);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Assignatures:");
        jLabel1.setBounds(0, 0, 130, 15);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(jList1);

        jScrollPane1.setBounds(10, 230, 140, 160);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Afegir");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(160, 270, 100, 25);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Editar...");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(160, 300, 100, 25);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Següent");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(560, 360, 94, 25);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("Enrere");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(470, 360, 81, 25);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(160, 360, 30, 30);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        Object[] cadena = jList1.getSelectedValues();
        int h = cadena.length;
        if (h == 0) cp.mostraAvis("Seleccioni l'assignatura a afegir", "WARNING");
        else {
            String cadenaString;
            for (int i=0; i < h; i++){ //Para cada elemento seleccionado de la lista...
                //Si ya no lo hemos añadido...
                cadenaString = cadena[i].toString(); //YA TENEMOS LA ASSIGNATURA SELECCIONADA
                if (assignatures.contains(cadenaString)) {
                    cp.mostraAvis("No es pot afegir de nou l'assignatura "+ cadenaString, "ERROR");
                } else {
                    assignatures.add(cadenaString);
                    int filas = jTable1.getRowCount();
                    modelo.addRow(new Object[filas]);
                    //AQUI HAY QUE IR ACCEDIENDO A CADA UNA DE LAS PROPIEDADES D LA ASIGNATURA Y RELLENAR LA TABLA
                    ArrayList<String> param = cp.mostraParametresAssignatura(cadenaString);
                    int index;
                    for (index = 0; index < 4; ++index) {
                        jTable1.setValueAt(param.get(index), filas, index); //NOMBRE, NIVEL, HOREST, INTERVALT
                    }
                    Integer interval_t = Integer.parseInt(param.get(3));
                    index += interval_t;
                    jTable1.setValueAt(param.get(index), filas, 4); //HORESL
                    ++index;
                    jTable1.setValueAt(param.get(index), filas, 5); //INTERVALL
                    Integer interval_l = Integer.parseInt(param.get(index));
                    ++index;
                    index += interval_l; //Nos saltamos tantas filas como interval de lab.
                    jTable1.setValueAt(param.get(index), filas, 6); //CAPACITAT T;
                    ++index;
                    jTable1.setValueAt(param.get(index), filas, 7); //CAPACITAT L;
                    ++index;
                    String grupos = "";
                    for (int k = index; k < param.size()-1; ++k) {
                        grupos = grupos + param.get(k);
                        grupos = grupos + ",";
                    }
                    grupos = grupos + param.get(param.size()-1);
                    jTable1.setValueAt(grupos, filas, 8); //GRUPS;
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Reseteamos la tabla y las asignaturas:
        assignatures = new ArrayList<String>();
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int n = modelo.getRowCount();
        for (int i = 0; i < n; i++) {
            modelo.removeRow(0);
        }
        cp.canviaPanel("PanelHorariLectiu");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cp.canviaPanel("PanelModificarDades");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        ArrayList<String> Assignaturas = cp.llistaAssignatures();
        for (String ass : Assignaturas) {
            ass = ass.substring(0, ass.length()-4); //QUITAMOS EL .txt
            ass = ass.substring(6, ass.length()); //QUITAMOS EL assig-
            String unitatDocent = cp.getNomUnitatDocent();
            ass = ass.substring(unitatDocent.length()+1, ass.length()); //QUITAMOS EL FIB-
            listModel.addElement(ass);
        }
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for (int i = 0; i < assignatures.size(); ++i) {
            System.out.println(""+assignatures.get(i));
        } //EN ESTE ARRAYLIST ESTAN LAS ASSIG CON LAS QUE SE GENERARA EL HORARIO
        cp.canviaPanel("PanelGeneracioAules");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
