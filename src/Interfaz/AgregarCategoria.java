package Interfaz;

import Logica.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class AgregarCategoria extends javax.swing.JFrame {

    AdministrarCategoria ae = new AdministrarCategoria();
    Categoria ed = new Categoria();

    /**
     * Creates new form AgregarCategoria
     */
    public AgregarCategoria() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Coloca imagen de formulario
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/logo-icono.png"));
        return retValue;
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
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLAtras = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMIRealizarPrestamo = new javax.swing.JMenuItem();
        jMILibrosPrestados = new javax.swing.JMenuItem();
        jMISalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAgregarLibro = new javax.swing.JMenuItem();
        jmiAdministrarLibro = new javax.swing.JMenuItem();
        jmiAgregarCategorias = new javax.swing.JMenuItem();
        jmiAdministrarCategorias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiAgregarLector = new javax.swing.JMenuItem();
        jmiAdministrarLectores = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMIAgregarAutor = new javax.swing.JMenuItem();
        jMIAdministrarAutor = new javax.swing.JMenuItem();
        jMIAgregarEditorial = new javax.swing.JMenuItem();
        jMIAdministrarEditorial = new javax.swing.JMenuItem();
        jMiReportes = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Agregar Categoría - Biblioteca escolar");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Consolas", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Agregar nueva categoría");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel2.setText("Categoría:");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jBAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jButton1))
                .addGap(32, 32, 32))
        );

        jLAtras.setForeground(new java.awt.Color(0, 0, 255));
        jLAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLAtras.setText("Inicio");
        jLAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAtrasMouseClicked(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMIRealizarPrestamo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMIRealizarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PrestarLibro-icono.png"))); // NOI18N
        jMIRealizarPrestamo.setText("Prestar libro");
        jMIRealizarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRealizarPrestamoActionPerformed(evt);
            }
        });
        jMenu1.add(jMIRealizarPrestamo);

        jMILibrosPrestados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMILibrosPrestados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LibrosPrestados-icono.png"))); // NOI18N
        jMILibrosPrestados.setText("Libros prestados");
        jMILibrosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILibrosPrestadosActionPerformed(evt);
            }
        });
        jMenu1.add(jMILibrosPrestados);

        jMISalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMISalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir.png"))); // NOI18N
        jMISalir.setText("Salir");
        jMISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMISalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Libros y categorías");

        jmiAgregarLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiAgregarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarDocumento-icono.png"))); // NOI18N
        jmiAgregarLibro.setText("Agregar libro");
        jmiAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarLibroActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAgregarLibro);

        jmiAdministrarLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Libro-icono.png"))); // NOI18N
        jmiAdministrarLibro.setText("Administrar libros");
        jmiAdministrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarLibroActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAdministrarLibro);

        jmiAgregarCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiAgregarCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarSimple-icono.png"))); // NOI18N
        jmiAgregarCategorias.setText("Agregar categorias");
        jMenu2.add(jmiAgregarCategorias);

        jmiAdministrarCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LibrosPrestados-icono.png"))); // NOI18N
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
        jmiAgregarLector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarPersona-icono.png"))); // NOI18N
        jmiAgregarLector.setText("Agregar lector");
        jmiAgregarLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarLectorActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAgregarLector);

        jmiAdministrarLectores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jmiAdministrarLectores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Lector-icono.png"))); // NOI18N
        jmiAdministrarLectores.setText("Administrar lectores");
        jmiAdministrarLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarLectoresActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAdministrarLectores);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Autores y editoriales");

        jMIAgregarAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMIAgregarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarPersona-icono.png"))); // NOI18N
        jMIAgregarAutor.setText("Agregar Autor");
        jMIAgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarAutorActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAgregarAutor);

        jMIAdministrarAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMIAdministrarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/persona-icono.png"))); // NOI18N
        jMIAdministrarAutor.setText("Administrar Autores");
        jMIAdministrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAdministrarAutorActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAdministrarAutor);

        jMIAgregarEditorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMIAgregarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarSimple-icono.png"))); // NOI18N
        jMIAgregarEditorial.setText("Agregar Editorial");
        jMIAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarEditorialActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAgregarEditorial);

        jMIAdministrarEditorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMIAdministrarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editorial-icono.png"))); // NOI18N
        jMIAdministrarEditorial.setText("Administrar Editorial");
        jMIAdministrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAdministrarEditorialActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAdministrarEditorial);

        jMenuBar1.add(jMenu5);

        jMiReportes.setText("Reportes");
        jMenuBar1.add(jMiReportes);

        jMenu7.setText("Ayuda");

        jMIAcercaDe.setText("Acerca de");
        jMIAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAcercaDeActionPerformed(evt);
            }
        });
        jMenu7.add(jMIAcercaDe);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        if (jtfCategoria.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que no hayan campos vacios", "Todos los campos son obligatorios", JOptionPane.WARNING_MESSAGE);
        } else {
            ed.setCategoria(jtfCategoria.getText());
            if (ae.agregarCategoria(ed)) {
                JOptionPane.showMessageDialog(null, "Categoria agregada exitosamente!", "En horabuena!", JOptionPane.INFORMATION_MESSAGE);
                jtfCategoria.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, vuelva a intentarlo mas tarde", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jLAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAtrasMouseClicked
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAtrasMouseClicked

    private void jMIRealizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRealizarPrestamoActionPerformed
        RealizarPrestamo re = new RealizarPrestamo();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIRealizarPrestamoActionPerformed

    private void jMILibrosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILibrosPrestadosActionPerformed
        Prestamos pre = new Prestamos();
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMILibrosPrestadosActionPerformed

    private void jMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMISalirActionPerformed

    private void jmiAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarLibroActionPerformed
        AgregarLibro al = new AgregarLibro();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarLibroActionPerformed

    private void jmiAdministrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarLibroActionPerformed
        MostrarLibros ml = new MostrarLibros();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarLibroActionPerformed

    private void jmiAdministrarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarCategoriasActionPerformed
        MostrarCategoria mc = new MostrarCategoria();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarCategoriasActionPerformed

    private void jmiAgregarLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarLectorActionPerformed
        AgregarLector al = new AgregarLector();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarLectorActionPerformed

    private void jmiAdministrarLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarLectoresActionPerformed
        MostrarLectores ml = new MostrarLectores();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarLectoresActionPerformed

    private void jMIAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarAutorActionPerformed
        AgregarAutor au = new AgregarAutor();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarAutorActionPerformed

    private void jMIAdministrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarAutorActionPerformed
        MostrarAutor showWritter = new MostrarAutor();
        showWritter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarAutorActionPerformed

    private void jMIAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarEditorialActionPerformed
        AgregarEditorial addEd = new AgregarEditorial();
        addEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarEditorialActionPerformed

    private void jMIAdministrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarEditorialActionPerformed
        MostrarEditorial showEd = new MostrarEditorial();
        showEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarEditorialActionPerformed

    private void jMIAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAcercaDeActionPerformed
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_jMIAcercaDeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MostrarCategoria principal = new MostrarCategoria();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMIAcercaDe;
    private javax.swing.JMenuItem jMIAdministrarAutor;
    private javax.swing.JMenuItem jMIAdministrarEditorial;
    private javax.swing.JMenuItem jMIAgregarAutor;
    private javax.swing.JMenuItem jMIAgregarEditorial;
    private javax.swing.JMenuItem jMILibrosPrestados;
    private javax.swing.JMenuItem jMIRealizarPrestamo;
    private javax.swing.JMenuItem jMISalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMiReportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiAdministrarCategorias;
    private javax.swing.JMenuItem jmiAdministrarLectores;
    private javax.swing.JMenuItem jmiAdministrarLibro;
    private javax.swing.JMenuItem jmiAgregarCategorias;
    private javax.swing.JMenuItem jmiAgregarLector;
    private javax.swing.JMenuItem jmiAgregarLibro;
    private javax.swing.JTextField jtfCategoria;
    // End of variables declaration//GEN-END:variables
}
