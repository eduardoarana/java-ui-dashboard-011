/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javaswigdev.Beans.InventarioBO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eArana
 */
public class ModeloTablaCatalogo extends AbstractTableModel {

    private final String[] nombresCol;
    private final Class[] tipoColumnas;
    private ArrayList<InventarioBO> lista = new ArrayList<InventarioBO>();

    public ModeloTablaCatalogo() {
        this.nombresCol = new String[]{"NumeroFactura", "Fecha Factura", "Descripcion del articulo"}; //, "P.Primaria", "Primaria", "Invertida", "Equivalecnia", "NªDecimales"};
        this.tipoColumnas = new Class[]{Object.class, Object.class, Object.class};

    }

    public void setlistaCatalogo(ArrayList<InventarioBO> lista) {
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
                return lista.get(fila).getCodigoArticulo();
            case 1:
                return lista.get(fila).getFechaEmision();
            case 2:
                return lista.get(fila).getArticuloDescripcion();
            default:
                return null;
        }
    }
}
