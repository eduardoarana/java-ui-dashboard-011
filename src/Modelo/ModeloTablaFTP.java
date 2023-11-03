/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javaswigdev.Beans.SaFTPBO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eArana
 */
public class ModeloTablaFTP extends AbstractTableModel {

    private final String[] nombresCol;
    private final Class[] tipoColumnas;
    private ArrayList<SaFTPBO> lista = new ArrayList<SaFTPBO>();

    public ModeloTablaFTP() {
        this.nombresCol = new String[]{"#", "Servidor", "Usuario", "Puerto", "Ruta Directorio Factura", "Ruta Directorio Pedidos", "Ruta Directorio Catalogo", "Conectado"};  //  {"Item", "Producto", "Existencia", "Cantidad", "CantFact", "CantRece", "CostPro", "CostPro$", "Dcto", "CostoNeto", "CostoNeto$", "PrecioSug", "PrecioSug$", "%IVA", "SubTotal", "SubTotal$"}; //, "P.Primaria", "Primaria", "Invertida", "Equivalecnia", "NªDecimales"};
        this.tipoColumnas = new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};//, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};

    }

    public void setlista(ArrayList<SaFTPBO> lista) {
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

    public Object getValueAt(int fila, int columna) {

        switch (columna) {
            case 0:
                return lista.get(fila).getId();
            case 1:
                return lista.get(fila).getNameServidor();
            case 2:
                return lista.get(fila).getUsuario();
            case 3:
                return lista.get(fila).getPuerto();
            case 4:
                return lista.get(fila).getRutaDirectorioFactura();
            case 5:
                return lista.get(fila).getRutaDirectorioPedidos();
            case 6:
                return lista.get(fila).getRutaDirectorioCatalogo();
            case 7:
                return lista.get(fila).getConexion();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                lista.get(rowIndex).setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                lista.get(rowIndex).setNameServidor(aValue.toString());
                break;
            case 2:
                lista.get(rowIndex).setUsuario(aValue.toString());
                break;
            case 3:
                lista.get(rowIndex).setPuerto(aValue.toString());
                break;
            case 4:
                lista.get(rowIndex).setRutaDirectorioFactura(aValue.toString());
                 break;
            case 5:
                lista.get(rowIndex).setRutaDirectorioPedidos(aValue.toString());
                 break;
            case 6:
                lista.get(rowIndex).setRutaDirectorioCatalogo(aValue.toString());
                 break;
            case 7:
                lista.get(rowIndex).setConexion(aValue.toString());
        }
    }

    public void refrescarTable() {
        this.fireTableDataChanged();
    }
}
