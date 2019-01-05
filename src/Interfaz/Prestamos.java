package Interfaz;

import Logica.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Prestamos extends javax.swing.JFrame {

    AdministrarPrestamo adpre = new AdministrarPrestamo();
    AdministrarLibro al = new AdministrarLibro();
    AdministrarEjemplar ae = new AdministrarEjemplar();
    AdministrarLector ale = new AdministrarLector();
    Tablas tabla = new Tablas();

    /**
     * Creates new form Prestamos
     */
    public Prestamos() {
        initComponents();
        setLocationRelativeTo(null);
        jTPrestamos.setModel(mostrarPrestamos());
        tabla.resizeColumnWidth(jTPrestamos);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/logo-icono.png"));
        return retValue;
    }

    public DefaultTableModel mostrarPrestamos() {
        List<Prestamo> prestamo2 = new ArrayList<Prestamo>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Libro");
        res.addColumn("Lector");
        res.addColumn("Fecha Prestamo");
        res.addColumn("Devolución");
        res.addColumn("Estado");
        res.addColumn("Tipo");

        adpre.mostrarPrestamo();
        prestamo2 = adpre.mostrarPrestamo();

        int i = 0;
        for (Prestamo l : prestamo2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getIdPrestamo(), i, 0);
            res.setValueAt(ObtenerLibro(l.getIdEjemplar()), i, 1);
            res.setValueAt(ObtenerNombreLector(l.getIdLector()), i, 2);
            res.setValueAt(l.getFechaPrestamo(), i, 3);
            res.setValueAt(l.getFechaDevolucion(), i, 4);
            res.setValueAt(l.getDevolucion(), i, 5);
            res.setValueAt(l.getTipoPrestamo(), i, 6);
            i++;
        }
        return res;
    }

    public DefaultTableModel buscarPrestamos(int n) {
        List<Prestamo> prestamo2 = new ArrayList<Prestamo>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Libro");
        res.addColumn("Lector");
        res.addColumn("Fecha Prestamo");
        res.addColumn("Devolucion");
        res.addColumn("Estado");
        res.addColumn("Tipo");

        adpre.buscarPrestamo(n);
        prestamo2 = adpre.buscarPrestamo(n);

        int i = 0;
        for (Prestamo l : prestamo2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getIdPrestamo(), i, 0);
            res.setValueAt(ObtenerLibro(l.getIdEjemplar()), i, 1);
            res.setValueAt(ObtenerNombreLector(l.getIdLector()), i, 2);
            res.setValueAt(l.getFechaPrestamo(), i, 3);
            res.setValueAt(l.getFechaDevolucion(), i, 4);
            res.setValueAt(l.getDevolucion(), i, 5);
            res.setValueAt(l.getTipoPrestamo(), i, 6);
            i++;
        }
        return res;
    }

    public String ObtenerLibro(int x) {
        String f = "";
        int y = ae.devolverIdLibro(x);
        Libro libro = new Libro();
        libro = al.obtenerLibro(y);
        f = libro.getTitulo();
        return f;
    }

    //devuelve el nombre del lector a partir del id
    public String ObtenerNombreLector(int x) {
        String f = "";
        Lector lector = new Lector();
        lector = ale.obtenerLector(x);
        f = lector.getNombre() + " " + lector.getApellido();
        return f;
    }

    //devuelve el id del lector a partir del nombre
    public int obtenerIdLector(String nombre) {
        int f = 0;
        Lector lector = new Lector();
        lector = ale.obtenerIdLector(nombre);
        f = lector.getId();
        return f;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPrestamos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTFBuscarPrestamoPorLector = new javax.swing.JTextField();
        jBActualizar = new javax.swing.JButton();
        jBDevolver = new javax.swing.JButton();
        jLAtras = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMIRealizarPrestamo = new javax.swing.JMenuItem();
        jMIDevolverLibro = new javax.swing.JMenuItem();
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
        setTitle("Libros prestados");
        setIconImage(getIconImage());

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Consolas", 3, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Listado de libros prestados");
        jLabel6.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prestamos realizados"));

        jTPrestamos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTPrestamos);

        jLabel1.setText("Buscar por lector:");

        jTFBuscarPrestamoPorLector.setToolTipText("Ingrese el nombre completo");
        jTFBuscarPrestamoPorLector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarPrestamoPorLectorKeyPressed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBDevolver.setText("Devolver");
        jBDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFBuscarPrestamoPorLector, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFBuscarPrestamoPorLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBDevolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLAtras.setForeground(new java.awt.Color(0, 0, 255));
        jLAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLAtras.setText("Atras");
        jLAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAtrasMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Listado.png"))); // NOI18N

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

        jMIDevolverLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMIDevolverLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DevolverLibro-icono.png"))); // NOI18N
        jMIDevolverLibro.setText("Devolver libro");
        jMenu1.add(jMIDevolverLibro);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLAtras)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLAtras)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFBuscarPrestamoPorLectorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarPrestamoPorLectorKeyPressed
        this.jTPrestamos.setModel(buscarPrestamos(obtenerIdLector(jTFBuscarPrestamoPorLector.getText())));
        tabla.resizeColumnWidth(jTPrestamos);
    }//GEN-LAST:event_jTFBuscarPrestamoPorLectorKeyPressed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        jTPrestamos.setModel(mostrarPrestamos());
        tabla.resizeColumnWidth(jTPrestamos);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolverActionPerformed
        Devolucion dev = new Devolucion(Integer.parseInt(tabla.selected(jTPrestamos)));
        dev.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBDevolverActionPerformed

    private void jLAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAtrasMouseClicked
        Principal prin = new Principal();
        prin.setVisible(true);
        prin.setVisible(true);
    }//GEN-LAST:event_jLAtrasMouseClicked

    private void jMIRealizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRealizarPrestamoActionPerformed
        RealizarPrestamo re = new RealizarPrestamo();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMIRealizarPrestamoActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBDevolver;
    private javax.swing.JLabel jLAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMIAcercaDe;
    private javax.swing.JMenuItem jMIAdministrarAutor;
    private javax.swing.JMenuItem jMIAdministrarEditorial;
    private javax.swing.JMenuItem jMIAgregarAutor;
    private javax.swing.JMenuItem jMIAgregarEditorial;
    private javax.swing.JMenuItem jMIDevolverLibro;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBuscarPrestamoPorLector;
    private javax.swing.JTable jTPrestamos;
    private javax.swing.JMenuItem jmiAdministrarCategorias;
    private javax.swing.JMenuItem jmiAdministrarLectores;
    private javax.swing.JMenuItem jmiAdministrarLibro;
    private javax.swing.JMenuItem jmiAgregarCategorias;
    private javax.swing.JMenuItem jmiAgregarLector;
    private javax.swing.JMenuItem jmiAgregarLibro;
    // End of variables declaration//GEN-END:variables

    

}
