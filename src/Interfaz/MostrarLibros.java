/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author delmy
 */
public class MostrarLibros extends javax.swing.JFrame {

    AdministrarLibro ali = new AdministrarLibro();
    AdministrarCategoria ac = new AdministrarCategoria();
    AdministrarAutor aa = new AdministrarAutor();
    AdministrarIdioma ai = new AdministrarIdioma();

    /**
     * Creates new form MostrarEditoriales
     */
    public MostrarLibros() {
        initComponents();
        setLocationRelativeTo(null);
        jTLibros.setModel(mostrarLibros());
        tamanos(jTLibros);
    }
    
    public DefaultTableModel mostrarLibros() {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo libro");
        res.addColumn("Ejemplares");
        res.addColumn("Categoria");
        res.addColumn("Autor");
        res.addColumn("ISBN");
        res.addColumn("Titulo");
//        res.addColumn("Año");
        res.addColumn("Descripción");
        res.addColumn("edicion");
        res.addColumn("Idioma");

        ali.mostrarLibro();
        libros2 = ali.mostrarLibro();

        int i = 0;
        for (Libro l : libros2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(ObtenerEjemplares(l.getId()), i, 1);
//            res.setValueAt(l.getIdEditorial(), i, 1);
            res.setValueAt(obtenerCate(l.getIdCategoria()), i, 2);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 3);
            res.setValueAt(l.getISBN(), i, 4);
            res.setValueAt(l.getTitulo(), i, 5);
//            res.setValueAt(l.getAño(), i, 5);
            res.setValueAt(l.getDescripcion(), i, 6);
            res.setValueAt(l.getEdicion(), i, 7);
            res.setValueAt(ObtenerIdio(l.getIdioma()), i, 8);
            i++;
        }
        return res;
    }

    public String selected() {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTLibros.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLibros.getSelectedRow(), 0));

        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return id;
        }
    }

    public void tamanos(JTable tabla) {
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(25);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(125);
//        columnModel.getColumn(5).setPreferredWidth(25);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(25);
        columnModel.getColumn(8).setPreferredWidth(25);
    }

    public DefaultTableModel buscarLibros(String n) {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo libro");
        res.addColumn("Ejemplares");
        res.addColumn("Categoria");
        res.addColumn("Autor");
        res.addColumn("ISBN");
        res.addColumn("Titulo");
//        res.addColumn("Año");
        res.addColumn("Descripción");
        res.addColumn("edicion");
        res.addColumn("Idioma");

        ali.mostrarLibro();
        libros2 = ali.buscarLibro(n);

        int i = 0;
        for (Libro l : libros2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(ObtenerEjemplares(l.getId()), i, 1);
//            res.setValueAt(l.getIdEditorial(), i, 1);
            res.setValueAt(obtenerCate(l.getIdCategoria()), i, 2);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 3);
            res.setValueAt(l.getISBN(), i, 4);
            res.setValueAt(l.getTitulo(), i, 5);
//            res.setValueAt(l.getAño(), i, 5);
            res.setValueAt(l.getDescripcion(), i, 6);
            res.setValueAt(l.getEdicion(), i, 7);
            res.setValueAt(ObtenerIdio(l.getIdioma()), i, 8);
            i++;
        }
        return res;
    }
//para nombre desde id de categoria 

    public String obtenerCate(int x) {
        String f;
        Categoria ca = new Categoria();
        ca = ac.obtenerCategoria(x);
        f = ca.getCategoria();
        return f;
    }

    // para obtener nombre desde id autor
    public String ObtenerAut(int y) {
        String g;
        Autor au = new Autor();
        au = aa.obtenerAutor(y);
        g = au.getNombre() + " " + au.getApellido();
        return g;
    }

    // para obtener idioma desde id idioma
    public String ObtenerIdio(int y) {
        String g;
        Idioma id = new Idioma();
        id = ai.devolverIdioma(y);
        g = id.getIdioma();
        return g;
    }

    // para obtener ejemplares por libro
    public int ObtenerEjemplares(int y) {
        int g;
        g = ali.mostrarEjemplar(y);
//        g = id.getIdioma();
        return g;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAtras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFBuscarLibro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLibros = new javax.swing.JTable();
        jBBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBModificar = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBEjemplar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Maiandra GD", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Libro");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Libros disponibles"));

        jLabel1.setText("Buscar por título:");

        jTFBuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarLibroKeyPressed(evt);
            }
        });

        jTLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTLibros);

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTFBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jBBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBEjemplar.setText("Ejemplar");
        jBEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEjemplarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(443, 443, 443)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBModificar)
                            .addComponent(jBEjemplar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAgregar)
                            .addComponent(jBEliminar))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAgregar)
                            .addComponent(jBEjemplar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBModificar)
                            .addComponent(jBEliminar))
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        // TODO add your handling code here:
        Main principal = new Main();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        AgregarLibro al = new AgregarLibro();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
        try {
            ModificarLibro ml = new ModificarLibro(Integer.parseInt(selected()));
            ml.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el libro seleccionado, ¿desea continuar?",
                "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ali.eliminarLibro(Integer.parseInt(selected()));
                jTLibros.setModel(mostrarLibros());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un dato \n indice seleccionado: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        this.jTLibros.setModel(buscarLibros(jTFBuscarLibro.getText()));
        tamanos(jTLibros);
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTFBuscarLibroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarLibroKeyPressed
        // TODO add your handling code here:
        this.jTLibros.setModel(buscarLibros(jTFBuscarLibro.getText()));
        tamanos(jTLibros);
    }//GEN-LAST:event_jTFBuscarLibroKeyPressed

    private void jBEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEjemplarActionPerformed
        // TODO add your handling code here:
        try {
            AgregarEjemplar ej = new AgregarEjemplar(Integer.parseInt(selected()));
            ej.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jBEjemplarActionPerformed


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
            java.util.logging.Logger.getLogger(MostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBAtras;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEjemplar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBuscarLibro;
    private javax.swing.JTable jTLibros;
    // End of variables declaration//GEN-END:variables
}
