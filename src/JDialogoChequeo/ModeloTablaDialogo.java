/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogoChequeo;

import java.util.ArrayList;
import javaswigdev.Beans.ListaArchivosBO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class ModeloTablaDialogo extends AbstractTableModel {

    private final String[] nombresCol;
    private final Class[] tipoColumnas;
    private ArrayList<ListaArchivosBO> lista = new ArrayList<ListaArchivosBO>();

    public ModeloTablaDialogo() {
        this.nombresCol = new String[]{"Nombre Archivo", "Fecha Archivo", "Selecione"}; //, "P.Primaria", "Primaria", "Invertida", "Equivalecnia", "NªDecimales"};
        this.tipoColumnas = new Class[]{Object.class, Object.class, Boolean.class};
    }

    public void setlistaRecepcionMercancia(ArrayList<ListaArchivosBO> lista) {
        this.lista = lista;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipoColumnas[columnIndex];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return nombresCol.length;
    }

    @Override
    public String getColumnName(int col) {
        return nombresCol[col];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch (columna) {
            case 0:
                return lista.get(fila).getNombreArchivo();
            case 1:
                return lista.get(fila).getFechaModificado();
            case 2:
                return lista.get(fila).getSeleccion();
            default:
                return null;
        }

    }
    
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
                case 0:
                lista.get(rowIndex).setNombreArchivo(aValue.toString());
                break;
            case 1:
                lista.get(rowIndex).setFechaModificado(aValue.toString());
                break;
            case 2:
                  lista.get(rowIndex).setSeleccion(true);
                break;
                   }
           }
    
     public void refrescarTable() {
        this.fireTableDataChanged();
    }
}
