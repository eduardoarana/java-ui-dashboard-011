/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javaswigdev.Beans.InventarioBO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class ModeloTablaInventario extends AbstractTableModel {

    private final String[] nombresCol;
    private final Class[] tipoColumnas;
    private ArrayList<InventarioBO> lista = new ArrayList<>();

    public ModeloTablaInventario() {
        this.nombresCol = new String[]{"Código del material", "Código de Barra", "Descripción del Material", "Código de línea", "Descripcion de linea", "Cantidad de bulto original", "IVA", "Gaceta", "Precio Referencia", "Existencia", "Entrada del día", "Descuento L1", "Descuento L2", "Descuento L3", "Numero Pedido", "Tipo Oferta 1"};  //  {"Item", "Producto", "Existencia", "Cantidad", "CantFact", "CantRece", "CostPro", "CostPro$", "Dcto", "CostoNeto", "CostoNeto$", "PrecioSug", "PrecioSug$", "%IVA", "SubTotal", "SubTotal$"}; //, "P.Primaria", "Primaria", "Invertida", "Equivalecnia", "NªDecimales"};
        this.tipoColumnas = new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};//, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};

    }

    public void setlistaInventario(ArrayList<InventarioBO> lista) {
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
                return lista.get(fila).getCodigoMaterial();
            case 1:
                return lista.get(fila).getCodigoBarra();
            case 2:
                return lista.get(fila).getDescripcionMaterial();
            case 3:
                return lista.get(fila).getCodigoLinea();
            case 4:
                return lista.get(fila).getCantBultoOriginal();
            case 5:
                return lista.get(fila).getIVA();
            case 6:
                return lista.get(fila).getGaceta();
            case 7:
                return lista.get(fila).getPrecioPreferencial();
            case 8:
                return lista.get(fila).getExistencia();
            case 9:
                return lista.get(fila).getEntradaDelDia();
            case 10:
                return lista.get(fila).getDescuentoL1();
            case 11:
                return lista.get(fila).getDescuentoL2();
            case 12:
                return lista.get(fila).getDescuentoL3();
            case 13:
                return lista.get(fila).getTipoOferta();
            case 14:
                return lista.get(fila).getCantidadOferta11();
            case 15:
                return lista.get(fila).getPorcentajeOfeta11();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                lista.get(rowIndex).setItem(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                lista.get(rowIndex).setCodigoMaterial(aValue.toString());
                break;
            case 2:
                lista.get(rowIndex).setCodigoBarra(aValue.toString());
                break;
            case 3:
                lista.get(rowIndex).setDescripcionMaterial(aValue.toString());
                break;
            case 4:
                lista.get(rowIndex).setCodigoLinea(aValue.toString());
                break;

            case 5:
                lista.get(rowIndex).setCantBultoOriginal(Integer.parseInt(aValue.toString()));
                break;
            case 6:
                lista.get(rowIndex).setIVA(Double.parseDouble(aValue.toString()));
                break;
            case 7:
                lista.get(rowIndex).setGaceta(Double.parseDouble(aValue.toString()));
                break;
            case 8:
                lista.get(rowIndex).setPrecioPreferencial(Double.parseDouble(aValue.toString()));
                break;
            case 9:
                lista.get(rowIndex).setExistencia(Integer.parseInt(aValue.toString()));
                break;
            case 10:
                lista.get(rowIndex).setEntradaDelDia(Double.parseDouble(aValue.toString()));
                break;
            case 11:
                lista.get(rowIndex).setDescuentoL1(Double.parseDouble(aValue.toString()));
                break;
            case 12:
                lista.get(rowIndex).setDescuentoL2(Double.parseDouble(aValue.toString()));
                break;
            case 13:
                lista.get(rowIndex).setDescuentoL3(Double.parseDouble(aValue.toString()));
                break;
            case 14:
                lista.get(rowIndex).setTipoOferta(aValue.toString());
                break;
            case 15:
                lista.get(rowIndex).setCantidadOferta11(Integer.parseInt(aValue.toString()));
                break;
        }
    }

    public void removedRow(int linea) {
        try {
            this.lista.remove(linea);
            this.fireTableRowsDeleted(linea, linea);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(new JFrame(), "You must select a Row", "Software", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refrescarTable() {

        this.fireTableDataChanged();
    }

    public void limpiarRengloTabla(int cantLineas) {
        for (int i = 0; i < cantLineas; i++) {
            this.removedRow(0);
            System.out.println("cantidad de veces " + i);
        }
    }

}
