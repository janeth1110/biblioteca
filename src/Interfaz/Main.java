/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Autor;

/**
 *
 * @author delmy
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBPrestamo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBLector = new javax.swing.JButton();
        jBEditorial = new javax.swing.JButton();
        jBLibro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBPrestamosPendientes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMILibrosPrestados = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAgregarLibro = new javax.swing.JMenuItem();
        jmiAgregarCategorias = new javax.swing.JMenuItem();
        jmiAdministrarLibro = new javax.swing.JMenuItem();
        jmiAdministrarCategorias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiAgregarLector = new javax.swing.JMenuItem();
        jmiAdministrarLectores = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMIAgregarAutor = new javax.swing.JMenuItem();
        jMIAgregarEditorial = new javax.swing.JMenuItem();
        jMIAdministrarAutor = new javax.swing.JMenuItem();
        jMIAdministrarEditorial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Escolar");
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Centro Escolar");

        jBPrestamo.setText("Prestar libro");
        jBPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrestamoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Lic. Carmen Elena Calderon de Escalón");

        jBLector.setText("Lector");
        jBLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLectorActionPerformed(evt);
            }
        });

        jBEditorial.setText("Editorial");
        jBEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditorialActionPerformed(evt);
            }
        });

        jBLibro.setText("Libro");
        jBLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jBPrestamosPendientes.setText("Prestamos pendientes");
        jBPrestamosPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrestamosPendientesActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar libro");

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Prestar libro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMILibrosPrestados.setText("Libros prestados");
        jMILibrosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILibrosPrestadosActionPerformed(evt);
            }
        });
        jMenu1.add(jMILibrosPrestados);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Libros y categorías");

        jmiAgregarLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiAgregarLibro.setText("Agregar libro");
        jmiAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarLibroActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAgregarLibro);

        jmiAgregarCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiAgregarCategorias.setText("Agregar categorias");
        jmiAgregarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarCategoriasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAgregarCategorias);

        jmiAdministrarLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarLibro.setText("Administrar libros");
        jmiAdministrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarLibroActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAdministrarLibro);

        jmiAdministrarCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarCategorias.setText("Administrar categorias");
        jmiAdministrarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarCategoriasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAdministrarCategorias);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Lectores");

        jmiAgregarLector.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmiAgregarLector.setText("Agregar lector");
        jmiAgregarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarLectorActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAgregarLector);

        jmiAdministrarLectores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarLectores.setText("Administrar lectores");
        jmiAdministrarLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarLectoresActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAdministrarLectores);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Autores y editoriales");

        jMIAgregarAutor.setText("Agregar Autor");
        jMIAgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarAutorActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAgregarAutor);

        jMIAgregarEditorial.setText("Agregar Editorial");
        jMIAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarEditorialActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAgregarEditorial);

        jMIAdministrarAutor.setText("Administrar Autores");
        jMIAdministrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAdministrarAutorActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAdministrarAutor);

        jMIAdministrarEditorial.setText("Administrar Editorial");
        jMIAdministrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAdministrarEditorialActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAdministrarEditorial);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBLector, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBPrestamosPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBLector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jBPrestamosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditorialActionPerformed
        // TODO add your handling code here:
        MostrarEditorial me = new MostrarEditorial();
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBEditorialActionPerformed

    private void jBLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLectorActionPerformed
        // TODO add your handling code here:
        MostrarLectores ml = new MostrarLectores();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBLectorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiAgregarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarLectorActionPerformed
        // TODO add your handling code here:
        AgregarLector al = new AgregarLector();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarLectorActionPerformed

    private void jmiAdministrarLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarLectoresActionPerformed
        // TODO add your handling code here:
        MostrarLectores ml = new MostrarLectores();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarLectoresActionPerformed

    private void jmiAgregarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarCategoriasActionPerformed
        // TODO add your handling code here:
        AgregarCategoria ac = new AgregarCategoria();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarCategoriasActionPerformed

    private void jmiAdministrarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarCategoriasActionPerformed
        // TODO add your handling code here:
        MostrarCategoria mc = new MostrarCategoria();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarCategoriasActionPerformed

    private void jBLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLibroActionPerformed
        // TODO add your handling code here:
        MostrarLibros ml = new MostrarLibros();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBLibroActionPerformed

    private void jmiAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarLibroActionPerformed
        // TODO add your handling code here:
        AgregarLibro al = new AgregarLibro();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarLibroActionPerformed

    private void jmiAdministrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarLibroActionPerformed
        // TODO add your handling code here:
        MostrarLibros ml = new MostrarLibros();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarLibroActionPerformed

    private void jBPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrestamoActionPerformed
        // TODO add your handling code here:
        RealizarPrestamo re = new RealizarPrestamo();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBPrestamoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        RealizarPrestamo re = new RealizarPrestamo();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMILibrosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILibrosPrestadosActionPerformed
        // TODO add your handling code here:
        Prestamos pre = new Prestamos();
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMILibrosPrestadosActionPerformed

    private void jBPrestamosPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrestamosPendientesActionPerformed
        // TODO add your handling code here:
        Prestamos pre = new Prestamos();
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBPrestamosPendientesActionPerformed

    private void jMIAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarAutorActionPerformed
        // TODO add your handling code here:
        AgregarAutor au = new AgregarAutor();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarAutorActionPerformed

    private void jMIAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarEditorialActionPerformed
        // TODO add your handling code here:
        AgregarEditorial addEd = new AgregarEditorial();
        addEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarEditorialActionPerformed

    private void jMIAdministrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarAutorActionPerformed
        // TODO add your handling code here:
        MostrarAutor showWritter = new MostrarAutor();
        showWritter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarAutorActionPerformed

    private void jMIAdministrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarEditorialActionPerformed
        // TODO add your handling code here:
        MostrarEditorial showEd = new MostrarEditorial();
        showEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarEditorialActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditorial;
    private javax.swing.JButton jBLector;
    private javax.swing.JButton jBLibro;
    private javax.swing.JButton jBPrestamo;
    private javax.swing.JButton jBPrestamosPendientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMIAdministrarAutor;
    private javax.swing.JMenuItem jMIAdministrarEditorial;
    private javax.swing.JMenuItem jMIAgregarAutor;
    private javax.swing.JMenuItem jMIAgregarEditorial;
    private javax.swing.JMenuItem jMILibrosPrestados;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiAdministrarCategorias;
    private javax.swing.JMenuItem jmiAdministrarLectores;
    private javax.swing.JMenuItem jmiAdministrarLibro;
    private javax.swing.JMenuItem jmiAgregarCategorias;
    private javax.swing.JMenuItem jmiAgregarLector;
    private javax.swing.JMenuItem jmiAgregarLibro;
    // End of variables declaration//GEN-END:variables
}
