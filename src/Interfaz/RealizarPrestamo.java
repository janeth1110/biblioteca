package Interfaz;

import Logica.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RealizarPrestamo extends javax.swing.JFrame {

    AdministrarLector ae = new AdministrarLector();
    AdministrarLibro ali = new AdministrarLibro();
    AdministrarAutor aa = new AdministrarAutor();
    AdministrarIdioma ai = new AdministrarIdioma();
    AdministrarEjemplar aej = new AdministrarEjemplar();
    AdministrarPrestamo ape = new AdministrarPrestamo();
    Prestamos pres = new Prestamos();
    Tablas tabla = new Tablas();

    Prestamo prestamo = new Prestamo();
    Date fecha = new Date();

    /**
     * Creates new form Prestamo
     */
    public RealizarPrestamo() {
        initComponents();
        setLocationRelativeTo(null);
        jTLectores.setModel(mostrarLector());
        tabla.resizeColumnWidth(jTLectores);
        jTLibros.setModel(mostrarLibros());
        tabla.resizeColumnWidth(jTLibros);
        fechaPrestamo();
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

    public DefaultTableModel mostrarLector() {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
        res.addColumn("Condicion");

        ae.mostrarLector();
        lectores2 = ae.mostrarLector();

        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
            res.setValueAt(l.getCondicion(), i, 3);
            i++;
        }
        return res;
    }

    public String selectedReaderId() {
        String id;
        TableModel tablaModelo = (TableModel) jTLectores.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 0));
        if (id.isEmpty()) {
            return null;
        } else {
            prestamo.setIdLector(Integer.parseInt(id));
            return id;
        }
    }

    public String selectedReaderName() {
        String nombre;
        String apellido;
        String res;
        TableModel tablaModelo = (TableModel) jTLectores.getModel();
        nombre = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 1));
        apellido = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 2));
        res = nombre + " " + apellido;
        if (res.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            return res;
        }
    }

    public DefaultTableModel buscarLector(String n) {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
        res.addColumn("Condicion");

        ae.buscarLector(n);
        lectores2 = ae.buscarLector(n);
        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
            res.setValueAt(l.getCondicion(), i, 3);
            i++;
        }
        return res;
    }

    public DefaultTableModel mostrarLibros() {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo libro");
        res.addColumn("Autor");
        res.addColumn("Titulo");
        res.addColumn("Descripción");
        res.addColumn("edicion");
        res.addColumn("Idioma");

        ali.mostrarLibro();
        libros2 = ali.mostrarLibro();

        int i = 0;
        for (Libro l : libros2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 1);
            res.setValueAt(l.getTitulo(), i, 2);
            res.setValueAt(l.getDescripcion(), i, 3);
            res.setValueAt(l.getEdicion(), i, 4);
            res.setValueAt(ai.ObtenerIdio(l.getIdioma()), i, 5);
            i++;
        }
        return res;
    }

    public String selectedBookId() {
        String id;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTLibros.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLibros.getSelectedRow(), 0));
        if (id.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            return id;
        }
    }

    public String selectedBookName() {
        String id;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTLibros.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLibros.getSelectedRow(), 2));
        if (id.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            return id;
        }
    }

    public DefaultTableModel buscarLibros(String n) {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("ID");
        res.addColumn("Autor");
        res.addColumn("Titulo");
        res.addColumn("Descripción");
        res.addColumn("edicion");
        res.addColumn("Idioma");

        ali.mostrarLibro();
        libros2 = ali.buscarLibro(n);

        int i = 0;
        for (Libro l : libros2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 1);
            res.setValueAt(l.getTitulo(), i, 2);
            res.setValueAt(l.getDescripcion(), i, 3);
            res.setValueAt(l.getEdicion(), i, 4);
            res.setValueAt(ai.ObtenerIdio(l.getIdioma()), i, 5);
            i++;
        }
        return res;
    }

    public int ObtenerEjemplares(int y) {
        int g;
        g = ali.mostrarEjemplar(y);
        return g;
    }

    public String ObtenerAut(int y) {
        String g;
        Autor au = new Autor();
        au = aa.obtenerAutor(y);
        g = au.getNombre() + " " + au.getApellido();
        return g;
    }

    public DefaultTableModel mostrarEjemplares(int d) {
        List<Ejemplar> ejemplares2 = new ArrayList<Ejemplar>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Código");
        res.addColumn("Ejemplar");
        res.addColumn("Ubicacion");
        res.addColumn("Disponibilidad");

        aej.mostrarEjemplar(d);
        ejemplares2 = aej.mostrarEjemplar(d);
        int i = 0;
        for (Ejemplar l : ejemplares2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getIdEjemplar(), i, 0);
            res.setValueAt(l.getNumEjemplar(), i, 1);
            res.setValueAt(l.getUbicacion(), i, 2);
            res.setValueAt(ObtenerDisponibilidad(l.getIdEstado()), i, 3);
            i++;
        }
        return res;
    }

    public String ObtenerDisponibilidad(int y) {
        String g;
        g = ape.obtenerDisponibilidad(y);
        return g;
    }

    //Obtiene id de ejemplar seleccionado
    public String selectedNumberBookId() {
        String id;
        TableModel tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 0));
        if (id.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            prestamo.setIdEjemplar(Integer.parseInt(id));
            return id;
        }
    }

    //Obtener ejemplar seleccionado
    public String selectedBookNumber() {
        String id;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 1));

        if (id.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            return id;
        }
    }

    public String selectedBooklocation() {
        String id;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 2));

        if (id.isEmpty()) {
            return "Debe seleccionar un dato";
        } else {
            return id;
        }
    }

    public void fechaPrestamo() {
        ((JTextField) this.jDCPrestamo.getDateEditor()).setEditable(false);
        jDCPrestamo.getCalendarButton().setEnabled(false);
        jDCPrestamo.setDate(fecha);
    }

    //limpia campos después de almacenar datos
    public void limpiar() {
        jTFLector.setText("");
        jTFLibroSeleccionado.setText("");
        jTFEjemplar.setText("");
        jTFUbicacion.setText("");
        jDCFechaDevolucion.setDate(fecha);
        jCBTipoPrestamo.setSelectedIndex(0);
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
        jLabel1 = new javax.swing.JLabel();
        jTFLector = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFLibroSeleccionado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFEjemplar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFUbicacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jDCPrestamo = new com.toedter.calendar.JDateChooser();
        jDCFechaDevolucion = new com.toedter.calendar.JDateChooser();
        jCBTipoPrestamo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jBLimpiarDato = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLectores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTFBuscarNombre = new javax.swing.JTextField();
        jBLimpiarBusquedaNombre = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFBuscarLibro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTLibros = new javax.swing.JTable();
        jBLimpiarLibros = new javax.swing.JButton();
        jLNombreLibro = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTEjemplares = new javax.swing.JTable();
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
        setTitle("Realizar prestamos - Biblioteca Escolar");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Consolas", 3, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Préstamo de libro");
        jLabel6.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del prestamo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel1.setText("Lector: ");

        jTFLector.setEditable(false);

        jLabel4.setText("Libro: ");

        jTFLibroSeleccionado.setEditable(false);

        jLabel5.setText("Ejemplar:");

        jTFEjemplar.setEditable(false);

        jLabel7.setText("Ubicación:");

        jTFUbicacion.setEditable(false);

        jLabel8.setText("Fecha de préstamo: ");

        jLabel9.setText("Fecha de devolución:");

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jCBTipoPrestamo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sala", "Casa" }));

        jLabel10.setText("Tipo de prestamo: ");

        jBLimpiarDato.setText("Limpiar");
        jBLimpiarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarDatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jCBTipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(jDCFechaDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFLector, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFUbicacion))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFEjemplar))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFLibroSeleccionado))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jDCPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jBLimpiarDato)
                        .addGap(26, 26, 26)
                        .addComponent(jBGuardar)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFLibroSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDCPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDCFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpiarDato)
                    .addComponent(jBGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 204));

        jPanel3.setForeground(new java.awt.Color(0, 153, 255));

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
        jTLectores.setMaximumSize(new java.awt.Dimension(60, 64));
        jTLectores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLectoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTLectores);

        jLabel2.setText("Buscar por Nombre:");

        jTFBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyTyped(evt);
            }
        });

        jBLimpiarBusquedaNombre.setText("Limpiar");
        jBLimpiarBusquedaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarBusquedaNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jBLimpiarBusquedaNombre)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiarBusquedaNombre))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Confirmar lector", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Buscar por título:");

        jTFBuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarLibroKeyTyped(evt);
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
        jTLibros.setMaximumSize(new java.awt.Dimension(60, 64));
        jTLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLibrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTLibros);

        jBLimpiarLibros.setText("Limpiar");
        jBLimpiarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarLibrosActionPerformed(evt);
            }
        });

        jLNombreLibro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLNombreLibro.setForeground(new java.awt.Color(0, 102, 204));
        jLNombreLibro.setText("Ejemplares");

        jTEjemplares.setModel(new javax.swing.table.DefaultTableModel(
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
        jTEjemplares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEjemplaresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTEjemplares);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTFBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpiarLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiarLibros))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLNombreLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Confirmar libro", jPanel2);

        jLAtras.setForeground(new java.awt.Color(0, 0, 255));
        jLAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLAtras.setText("Atras");
        jLAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAtrasMouseClicked(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMIRealizarPrestamo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMIRealizarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PrestarLibro-icono.png"))); // NOI18N
        jMIRealizarPrestamo.setText("Prestar libro");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLAtras)
                        .addGap(328, 328, 328)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLAtras))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLimpiarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarLibrosActionPerformed
        jTLibros.setModel(mostrarLibros());
        tabla.resizeColumnWidth(jTLibros);
    }//GEN-LAST:event_jBLimpiarLibrosActionPerformed

    private void jBLimpiarBusquedaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarBusquedaNombreActionPerformed
        jTLectores.setModel(mostrarLector());
        tabla.resizeColumnWidth(jTLectores);
    }//GEN-LAST:event_jBLimpiarBusquedaNombreActionPerformed

    private void jTFBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyTyped
        this.jTLectores.setModel(buscarLector(jTFBuscarNombre.getText()));
        tabla.resizeColumnWidth(jTLectores);
    }//GEN-LAST:event_jTFBuscarNombreKeyTyped

    private void jTLectoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLectoresMouseClicked
        jTFLector.setText(selectedReaderName());
        selectedReaderId();
    }//GEN-LAST:event_jTLectoresMouseClicked

    private void jTFBuscarLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarLibroKeyTyped
        this.jTLibros.setModel(buscarLibros(jTFBuscarLibro.getText()));
        tabla.resizeColumnWidth(jTLibros);
    }//GEN-LAST:event_jTFBuscarLibroKeyTyped

    private void jTLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLibrosMouseClicked
        jTFLibroSeleccionado.setText(selectedBookName());
        jTEjemplares.setModel(mostrarEjemplares(Integer.parseInt(selectedBookId())));
        tabla.resizeColumnWidth(jTEjemplares);
        jTFEjemplar.setText("");
        jTFUbicacion.setText("");
    }//GEN-LAST:event_jTLibrosMouseClicked

    private void jTEjemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEjemplaresMouseClicked
        jTFEjemplar.setText(selectedBookNumber());
        jTFUbicacion.setText(selectedBooklocation());
        selectedNumberBookId();
    }//GEN-LAST:event_jTEjemplaresMouseClicked

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        if (jTFLector.getText().trim().isEmpty()
                || jTFLibroSeleccionado.getText().trim().isEmpty()
                || jTFEjemplar.getText().trim().isEmpty()
                || jTFUbicacion.getText().trim().isEmpty()
                || jDCPrestamo.getDate().toString().trim().isEmpty()
                || jDCFechaDevolucion.getDate().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay uno o mas campos obligatorios vacios.\nPor favor llene todos los campos","Hay campos vacios",JOptionPane.WARNING_MESSAGE);

        } else {
            prestamo.setIdLector(Integer.parseInt(selectedReaderId()));
            prestamo.setIdEjemplar(Integer.parseInt(selectedNumberBookId()));
            prestamo.setDevolucion("pendiente");
            prestamo.setTipoPrestamo(ape.tipoPrestamo(jCBTipoPrestamo));

            java.sql.Date sqlDate, sqlDate2;
            java.util.Date date = jDCFechaDevolucion.getDate();
            java.util.Date date2 = jDCPrestamo.getDate();
            sqlDate = new java.sql.Date(date.getTime());
            sqlDate2 = new java.sql.Date(date2.getTime());

            prestamo.setFechaDevolucion(sqlDate);
            prestamo.setFechaPrestamo(sqlDate2);

            if (ape.agregarPrestamo(prestamo) == true) {
//            JOptionPane.showMessageDialog(null, "Lector agregado exitosamente");
                ape.actualizarEstadoEjemplar(prestamo.getIdEjemplar());
                Principal me = new Principal();
                me.setVisible(true);
                this.dispose();
            } else {
//                JOptionPane.showMessageDialog(null, "Ha sucedido un error, por favor revise los datos ingresados");
            }
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBLimpiarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarDatoActionPerformed
        limpiar();
    }//GEN-LAST:event_jBLimpiarDatoActionPerformed

    private void jLAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAtrasMouseClicked
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAtrasMouseClicked

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
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiarBusquedaNombre;
    private javax.swing.JButton jBLimpiarDato;
    private javax.swing.JButton jBLimpiarLibros;
    private javax.swing.JComboBox<String> jCBTipoPrestamo;
    private com.toedter.calendar.JDateChooser jDCFechaDevolucion;
    private com.toedter.calendar.JDateChooser jDCPrestamo;
    private javax.swing.JLabel jLAtras;
    private javax.swing.JLabel jLNombreLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTEjemplares;
    private javax.swing.JTextField jTFBuscarLibro;
    private javax.swing.JTextField jTFBuscarNombre;
    private javax.swing.JTextField jTFEjemplar;
    private javax.swing.JTextField jTFLector;
    private javax.swing.JTextField jTFLibroSeleccionado;
    private javax.swing.JTextField jTFUbicacion;
    private javax.swing.JTable jTLectores;
    private javax.swing.JTable jTLibros;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem jmiAdministrarCategorias;
    private javax.swing.JMenuItem jmiAdministrarLectores;
    private javax.swing.JMenuItem jmiAdministrarLibro;
    private javax.swing.JMenuItem jmiAgregarCategorias;
    private javax.swing.JMenuItem jmiAgregarLector;
    private javax.swing.JMenuItem jmiAgregarLibro;
    // End of variables declaration//GEN-END:variables
}
