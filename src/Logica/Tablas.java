package Logica;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Tablas {

    /*
    *Detalla tamaño adecuado para todas las tablas de la aplicacion
     */
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width 
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 200) {
                width = 200;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    /*
    *Devuelve el primer valor de la fila seleccionada en una tabla
    */
    public String selected(JTable tabla) {
        String id = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) tabla.getModel();
        id = String.valueOf(tablaModelo.getValueAt(tabla.getSelectedRow(), 0));

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un dato");
            return null;
        } else {
            return id;
        }
    }
}
