/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.*;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author delmy
 */
public class RealizarPrestamo extends javax.swing.JFrame {

    AdministrarLector ae = new AdministrarLector();
    AdministrarLibro ali = new AdministrarLibro();
    AdministrarAutor aa = new AdministrarAutor();
    AdministrarIdioma ai = new AdministrarIdioma();
    AdministrarEjemplar aej = new AdministrarEjemplar();
    AdministrarPrestamo ape = new AdministrarPrestamo();

    Prestamo prestamo = new Prestamo();
    Date fecha = new Date();

    /**
     * Creates new form Prestamo
     */
    public RealizarPrestamo() {
        initComponents();
        setLocationRelativeTo(null);
        jTLectores.setModel(mostrarLector());
        tamañosLector(jTLectores);
        jTLibros.setModel(mostrarLibros());
        tamanosLibro(jTLibros);
        fechaPrestamo();
    }

    public DefaultTableModel mostrarLector() {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
//        res.addColumn("Sexo");
//        res.addColumn("Fecha Nacimiento");
//        res.addColumn("Telefono");
        res.addColumn("Condicion");

        ae.mostrarLector();
        lectores2 = ae.mostrarLector();

        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
//            res.setValueAt(l.getSexo(), i, 3);
//            res.setValueAt(l.getFecha_nac(), i, 4);
//            res.setValueAt(l.getTelefono(), i, 5);
            res.setValueAt(l.getCondicion(), i, 3);
            i++;
        }
        return res;
    }

    public String selectedReaderId() {
        String id = null;
        TableModel tablaModelo = (TableModel) jTLectores.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 0));
        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            prestamo.setIdLector(Integer.parseInt(id));
            return id;
        }
    }

    public String selectedReaderName() {
        String nombre = null;
        String apellido = null;
        String res = null;
        TableModel tablaModelo = (TableModel) jTLectores.getModel();
        nombre = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 1));
        apellido = String.valueOf(tablaModelo.getValueAt(jTLectores.getSelectedRow(), 2));
        res = nombre + " " + apellido;
        if (res.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return res;
        }
    }

    public void tamañosLector(JTable tabla) {
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(45);
        columnModel.getColumn(2).setPreferredWidth(45);
//        columnModel.getColumn(3).setPreferredWidth(1);
//        columnModel.getColumn(4).setPreferredWidth(100);
//        columnModel.getColumn(5).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(9);
    }

    public DefaultTableModel buscarLector(String n) {
        List<Lector> lectores2 = new ArrayList<Lector>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
//        res.addColumn("Sexo");
//        res.addColumn("Fecha Nacimiento");
//        res.addColumn("Telefono");
        res.addColumn("Condicion");

        ae.buscarLector(n);
        lectores2 = ae.buscarLector(n);
        int i = 0;
        for (Lector l : lectores2) {
            res.addRow(new Object[]{});
            res.setValueAt(l.getId(), i, 0);
            res.setValueAt(l.getNombre(), i, 1);
            res.setValueAt(l.getApellido(), i, 2);
//            res.setValueAt(l.getSexo(), i, 3);
//            res.setValueAt(l.getFecha_nac(), i, 4);
//            res.setValueAt(l.getTelefono(), i, 5);
            res.setValueAt(l.getCondicion(), i, 3);
            i++;
        }
        return res;
    }

    public DefaultTableModel mostrarLibros() {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo libro");
//        res.addColumn("Ejemplares");
//        res.addColumn("Categoria");
        res.addColumn("Autor");
//        res.addColumn("ISBN");
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
//            res.setValueAt(ObtenerEjemplares(l.getId()), i, 1);
//            res.setValueAt(l.getIdEditorial(), i, 1);
//            res.setValueAt(obtenerCate(l.getIdCategoria()), i, 2);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 1);
//            res.setValueAt(l.getISBN(), i, 4);
            res.setValueAt(l.getTitulo(), i, 2);
//            res.setValueAt(l.getAño(), i, 5);
            res.setValueAt(l.getDescripcion(), i, 3);
            res.setValueAt(l.getEdicion(), i, 4);
            res.setValueAt(ObtenerIdio(l.getIdioma()), i, 5);
            i++;
        }
        return res;
    }

    public String selectedBookId() {
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

    public String selectedBookName() {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTLibros.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTLibros.getSelectedRow(), 2));
        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return id;
        }
    }

    public void tamanosLibro(JTable tabla) {
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
//        columnModel.getColumn(1).setPreferredWidth(10);
//        columnModel.getColumn(2).setPreferredWidth(25);
//        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(125);
//        columnModel.getColumn(5).setPreferredWidth(25);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(25);
        columnModel.getColumn(5).setPreferredWidth(25);
    }

    public DefaultTableModel buscarLibros(String n) {
        List<Libro> libros2 = new ArrayList<Libro>();
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Codigo libro");
//        res.addColumn("Ejemplares");
//        res.addColumn("Categoria");
        res.addColumn("Autor");
//        res.addColumn("ISBN");
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
//            res.setValueAt(ObtenerEjemplares(l.getId()), i, 1);
//            res.setValueAt(l.getIdEditorial(), i, 1);
//            res.setValueAt(obtenerCate(l.getIdCategoria()), i, 2);
            res.setValueAt(ObtenerAut(l.getIdAutor()), i, 1);
//            res.setValueAt(l.getISBN(), i, 4);
            res.setValueAt(l.getTitulo(), i, 2);
//            res.setValueAt(l.getAño(), i, 5);
            res.setValueAt(l.getDescripcion(), i, 3);
            res.setValueAt(l.getEdicion(), i, 4);
            res.setValueAt(ObtenerIdio(l.getIdioma()), i, 5);
            i++;
        }
        return res;
    }

    public int ObtenerEjemplares(int y) {
        int g;
        g = ali.mostrarEjemplar(y);
//        g = id.getIdioma();
        return g;
    }

    public String ObtenerAut(int y) {
        String g;
        Autor au = new Autor();
        au = aa.obtenerAutor(y);
        g = au.getNombre() + " " + au.getApellido();
        return g;
    }

    // obtener idioma desde id idioma
    public String ObtenerIdio(int y) {
        String g;
        Idioma id = new Idioma();
        id = ai.devolverIdioma(y);
        g = id.getIdioma();
        return g;
    }

    public DefaultTableModel mostrarEjemplares(int d) {
//        String estado="Prestado";
//        int estad;
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
        String id = null;
        TableModel tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 0));
        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            prestamo.setIdEjemplar(Integer.parseInt(id));
            return id;
        }
    }

    //Obtener ejemplar seleccionado
    public String selectedBookNumber() {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 1));

        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return id;
        }
    }

    public String selectedBooklocation() {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) jTEjemplares.getModel();
        id = String.valueOf(tablaModelo.getValueAt(jTEjemplares.getSelectedRow(), 2));

        if (id.isEmpty()) {
//           JOptionPane.showMessageDialog(null, id);
            return "Debe seleccionar un dato";
        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Editorial");
            return id;
        }
    }

    public void tamanosEjemplar(JTable tabla) {
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(25);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(25);
    }

    public void fechaPrestamo() {
        ((JTextField) this.jDCPrestamo.getDateEditor()).setEditable(false);
        jDCPrestamo.getCalendarButton().setEnabled(false);
        jDCPrestamo.setDate(fecha);
    }

//    public Date convertirFechaprestamo(JDateChooser fech) {
//        java.sql.Date sqlDate;
//        try {
//            java.util.Date date = jDCPrestamo.getDate();
//            sqlDate = new java.sql.Date(date.getTime());
//            return sqlDate;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//    }
//
//    public Date convertirFechaDevolucion(JDateChooser fech) {
//        java.sql.Date sqlDate;
//        try {
//            java.util.Date date = fech.getDate();
//            sqlDate = new java.sql.Date(date.getTime());
//            return sqlDate;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//    }

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLectores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTFBuscarNombre = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFBuscarLibro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTLibros = new javax.swing.JTable();
        jBLimpiarLibros = new javax.swing.JButton();
        jLNombreLibro = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTEjemplares = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Préstamo de libro");

        jBAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Maiandra GD", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Préstamo de libro");
        jLabel6.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del prestamo"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jBGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jCBTipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
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
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addGap(45, 45, 45)
                .addComponent(jBGuardar)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBLimpiar)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
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

        jLNombreLibro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                        .addComponent(jBLimpiarLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Confirmar libro", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        // TODO add your handling code here:
        Main me = new Main();
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jBLimpiarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarLibrosActionPerformed
        // TODO add your handling code here:
        jTLibros.setModel(mostrarLibros());
        tamanosLibro(jTLibros);
    }//GEN-LAST:event_jBLimpiarLibrosActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        jTLectores.setModel(mostrarLector());
        tamañosLector(jTLectores);
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyTyped
        // TODO add your handling code here:
        this.jTLectores.setModel(buscarLector(jTFBuscarNombre.getText()));
        tamañosLector(jTLectores);
    }//GEN-LAST:event_jTFBuscarNombreKeyTyped

    private void jTLectoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLectoresMouseClicked
        // TODO add your handling code here:
        jTFLector.setText(selectedReaderName());
        selectedReaderId();
    }//GEN-LAST:event_jTLectoresMouseClicked

    private void jTFBuscarLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarLibroKeyTyped
        // TODO add your handling code here:
        this.jTLibros.setModel(buscarLibros(jTFBuscarLibro.getText()));
        tamanosLibro(jTLibros);
    }//GEN-LAST:event_jTFBuscarLibroKeyTyped

    private void jTLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLibrosMouseClicked
        // TODO add your handling code here:
        jTFLibroSeleccionado.setText(selectedBookName());
        jTEjemplares.setModel(mostrarEjemplares(Integer.parseInt(selectedBookId())));
        tamanosEjemplar(jTEjemplares);
        jTFEjemplar.setText("");
        jTFUbicacion.setText("");
    }//GEN-LAST:event_jTLibrosMouseClicked

    private void jTEjemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEjemplaresMouseClicked
        // TODO add your handling code here:
        jTFEjemplar.setText(selectedBookNumber());
        jTFUbicacion.setText(selectedBooklocation());
        selectedNumberBookId();
    }//GEN-LAST:event_jTEjemplaresMouseClicked

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
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
        
        if (ape.agregarPrestamo(prestamo)== true) {
//            JOptionPane.showMessageDialog(null, "Lector agregado exitosamente");
//                limpiar();
            } else {
//                JOptionPane.showMessageDialog(null, "Ha sucedido un error, por favor revise los datos ingresados");
            }
    }//GEN-LAST:event_jBGuardarActionPerformed

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
    private javax.swing.JButton jBAtras;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBLimpiarLibros;
    private javax.swing.JComboBox<String> jCBTipoPrestamo;
    private com.toedter.calendar.JDateChooser jDCFechaDevolucion;
    private com.toedter.calendar.JDateChooser jDCPrestamo;
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
    // End of variables declaration//GEN-END:variables
}
