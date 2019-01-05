/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Logica.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author delmy
 */
public class MostrarLectores extends javax.swing.JFrame {

    AdministrarLector ae = new AdministrarLector();
    Tablas tabla = new Tablas();

    /**
     * Creates new form MostrarLectores
     */
    public MostrarLectores() {
        initComponents();
        setLocationRelativeTo(null);
        jTLectores.setModel(mostrarLector());
        tabla.resizeColumnWidth(jTLectores);
    }

    public DefaultTableModel mostrarLector() {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
        res.addColumn("Sexo");
        res.addColumn("Fecha Nacimiento");
        res.addColumn("Telefono");
        res.addColumn("Condicion");

        ae.mostrarLector();
        lectores2 = ae.mostrarLector();
        
        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
            res.setValueAt(l.getSexo(), i, 3);
            res.setValueAt(l.getFecha_nac(), i, 4);
            res.setValueAt(l.getTelefono(), i, 5);
            res.setValueAt(l.getCondicion(), i, 6);
            i++;
        }
        return res;
    }

    public String selected() {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTLectores.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 0));

        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return id;
        }
    }

    public DefaultTableModel buscarLector(String n) {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
        res.addColumn("Sexo");
        res.addColumn("Fecha Nacimiento");
        res.addColumn("Telefono");
        res.addColumn("Condicion");

        ae.buscarLector(n);
        lectores2 = ae.buscarLector(n);
        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
            res.setValueAt(l.getSexo(), i, 3);
            res.setValueAt(l.getFecha_nac(), i, 4);
            res.setValueAt(l.getTelefono(), i, 5);
            res.setValueAt(l.getCondicion(), i, 6);
            i++;
        }
        return res;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBAtras1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLectores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTFBuscarNombre = new javax.swing.JTextField();
        jbBuscarLector = new javax.swing.JButton();
        jBAgregarLector = new javax.swing.JButton();
        jBModificarLector = new javax.swing.JButton();
        jBEliminarLector = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lectores");

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Lector");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Lector.png"))); // NOI18N

        jBAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jBAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtras1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar lector"));

        jTLectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTLectores);

        jLabel2.setText("Buscar por Nombre:");

        jTFBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbBuscarLector.setText("Buscar");
        jbBuscarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarLectorActionPerformed(evt);
            }
        });

        jBAgregarLector.setText("Agregar");
        jBAgregarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarLectorActionPerformed(evt);
            }
        });

        jBModificarLector.setText("Modificar");
        jBModificarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarLectorActionPerformed(evt);
            }
        });

        jBEliminarLector.setText("Eliminar");
        jBEliminarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarLectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBModificarLector)
                                    .addComponent(jbBuscarLector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBEliminarLector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBAgregarLector, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAtras1)
                        .addGap(428, 428, 428)
                        .addComponent(jLabel6)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBAtras1)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscarLector)
                    .addComponent(jBAgregarLector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBModificarLector)
                    .addComponent(jBEliminarLector))
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtras1ActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAtras1ActionPerformed

    private void jBAgregarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarLectorActionPerformed
        // TODO add your handling code here:
        AgregarLector al = new AgregarLector();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAgregarLectorActionPerformed

    private void jBModificarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarLectorActionPerformed
        // TODO add your handling code here:
        try {
            ModificarLector ml = new ModificarLector(Integer.parseInt(selected()));
            ml.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jBModificarLectorActionPerformed

    private void jBEliminarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarLectorActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el lector seleccionado, ¿desea continuar?",
                "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ae.eliminarLector(Integer.parseInt(selected()));
                jTLectores.setModel(mostrarLector());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un dato \n indice seleccionado: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jBEliminarLectorActionPerformed

    private void jbBuscarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarLectorActionPerformed
        // TODO add your handling code here:
        this.jTLectores.setModel(buscarLector(jTFBuscarNombre.getText()));
        tabla.resizeColumnWidth(jTLectores);
    }//GEN-LAST:event_jbBuscarLectorActionPerformed

    private void jTFBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyPressed
        // TODO add your handling code here:
        this.jTLectores.setModel(buscarLector(jTFBuscarNombre.getText()));
        tabla.resizeColumnWidth(jTLectores);
    }//GEN-LAST:event_jTFBuscarNombreKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarLectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarLectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarLectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarLectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create andjbBuscarLectorthe form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarLectores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarLector;
    private javax.swing.JButton jBAtras1;
    private javax.swing.JButton jBEliminarLector;
    private javax.swing.JButton jBModificarLector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBuscarNombre;
    private javax.swing.JTable jTLectores;
    private javax.swing.JButton jbBuscarLector;
    // End of variables declaration//GEN-END:variables
}
