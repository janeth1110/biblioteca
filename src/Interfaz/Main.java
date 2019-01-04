package Interfaz;

public class Main extends javax.swing.JFrame {

    MostrarEditorial me = new MostrarEditorial();
    MostrarLectores ml = new MostrarLectores();
    MostrarLibros mli = new MostrarLibros();
    RealizarPrestamo re = new RealizarPrestamo();
    MostrarCategoria pre = new MostrarCategoria();
    Prestamos pres = new Prestamos();

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

        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jBPrestamo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBLector = new javax.swing.JButton();
        jBEditorial = new javax.swing.JButton();
        jBLibro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBCategorias = new javax.swing.JButton();
        jBRegresarLibro = new javax.swing.JButton();
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
        jMenu7 = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Escolar");
        setAlwaysOnTop(true);
        setResizable(false);

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

        jBCategorias.setText("Categorias");
        jBCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCategoriasActionPerformed(evt);
            }
        });

        jBRegresarLibro.setText("Devolver libro");
        jBRegresarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarLibroActionPerformed(evt);
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
        jmiAgregarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarLibro-icono.png"))); // NOI18N
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
        jmiAgregarCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarSimple.png"))); // NOI18N
        jmiAgregarCategorias.setText("Agregar categorias");
        jmiAgregarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarCategoriasActionPerformed(evt);
            }
        });
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
        jmiAgregarLector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarLector-icono.png"))); // NOI18N
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
        jMIAgregarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarLector-icono.png"))); // NOI18N
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
        jMIAgregarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarLibro-icono.png"))); // NOI18N
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jBPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBRegresarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBLector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBRegresarLibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditorialActionPerformed
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBEditorialActionPerformed

    private void jBLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLectorActionPerformed
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBLectorActionPerformed

    private void jMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMISalirActionPerformed

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

    private void jmiAgregarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarCategoriasActionPerformed
        AgregarCategoria ac = new AgregarCategoria();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAgregarCategoriasActionPerformed

    private void jmiAdministrarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarCategoriasActionPerformed
        MostrarCategoria mc = new MostrarCategoria();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiAdministrarCategoriasActionPerformed

    private void jBLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLibroActionPerformed
        mli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBLibroActionPerformed

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

    private void jBPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrestamoActionPerformed
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBPrestamoActionPerformed

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

    private void jBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCategoriasActionPerformed
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCategoriasActionPerformed

    private void jMIAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarAutorActionPerformed
        AgregarAutor au = new AgregarAutor();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarAutorActionPerformed

    private void jMIAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarEditorialActionPerformed
        AgregarEditorial addEd = new AgregarEditorial();
        addEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAgregarEditorialActionPerformed

    private void jMIAdministrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarAutorActionPerformed
        MostrarAutor showWritter = new MostrarAutor();
        showWritter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarAutorActionPerformed

    private void jMIAdministrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAdministrarEditorialActionPerformed
        MostrarEditorial showEd = new MostrarEditorial();
        showEd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAdministrarEditorialActionPerformed

    private void jBRegresarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarLibroActionPerformed
        pres.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBRegresarLibroActionPerformed

    private void jMIAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAcercaDeActionPerformed
        // TODO add your handling code here:
        About about = new About();
        about.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIAcercaDeActionPerformed

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
    private javax.swing.JButton jBCategorias;
    private javax.swing.JButton jBEditorial;
    private javax.swing.JButton jBLector;
    private javax.swing.JButton jBLibro;
    private javax.swing.JButton jBPrestamo;
    private javax.swing.JButton jBRegresarLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiAdministrarCategorias;
    private javax.swing.JMenuItem jmiAdministrarLectores;
    private javax.swing.JMenuItem jmiAdministrarLibro;
    private javax.swing.JMenuItem jmiAgregarCategorias;
    private javax.swing.JMenuItem jmiAgregarLector;
    private javax.swing.JMenuItem jmiAgregarLibro;
    // End of variables declaration//GEN-END:variables
}
