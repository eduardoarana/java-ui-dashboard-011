/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javaswigdev.Beans.FacturaRenglonBO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eArana
 */
public class ModeloTablaRecepcionMercancia extends AbstractTableModel {

    private final String[] nombresCol;
    private final Class[] tipoColumnas;
    private ArrayList<FacturaRenglonBO> lista = new ArrayList<FacturaRenglonBO>();

    public ModeloTablaRecepcionMercancia() {
        this.nombresCol = new String[]{"Item", "Numero Factura", "Cant D", "Cod Barra", "Descripcion del Art", "Precio Suge", "Margen Descuent", "Oferta", "Descuent Comer", "Descuento Inter", "Precio Uni", "IVA", "Neto", "Gaceta", "Numero Pedido" , "Codi Material"};  //  {"Item", "Producto", "Existencia", "Cantidad", "CantFact", "CantRece", "CostPro", "CostPro$", "Dcto", "CostoNeto", "CostoNeto$", "PrecioSug", "PrecioSug$", "%IVA", "SubTotal", "SubTotal$"}; //, "P.Primaria", "Primaria", "Invertida", "Equivalecnia", "NªDecimales"};
        this.tipoColumnas = new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};//, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};
    }

    public void setlistaRecepcionMercancia(ArrayList<FacturaRenglonBO> lista) {
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
                return lista.get(fila).getItem();
            case 1:
                return lista.get(fila).getNumFactura();
            case 2:
                return lista.get(fila).getCantdespachada();
            case 3:
                return lista.get(fila).getCodBarra();
            case 4:
                return lista.get(fila).getDescripcionArt();
            case 5:
                return lista.get(fila).getPrecioVentaS();
            case 6:
                return lista.get(fila).getMargenDescuentos();
            case 7:
                return lista.get(fila).getOferta();
            case 8:
                return lista.get(fila).getDescuentoComercial();
            case 9:
                return lista.get(fila).getDescuentInternet();
            case 10:
                return lista.get(fila).getPrecioUnitario();
            case 11:
                return lista.get(fila).getIVA();
            case 12:
                return lista.get(fila).getTotalNetoReng();
            case 13:
                return lista.get(fila).getGaceta();
            case 14:
                return lista.get(fila).getNumPedidoArti();
            case 15:
                return lista.get(fila).getCodMateriDrolanc();
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
                lista.get(rowIndex).setNumFactura(aValue.toString());
                break;
            case 2:
                lista.get(rowIndex).setCantdespachada(Integer.parseInt(aValue.toString()));
                break;
            case 3:
                lista.get(rowIndex).setCodBarra(aValue.toString());
                break;
            case 4:
                lista.get(rowIndex).setDescripcionArt(aValue.toString());
                break;

            case 5:
                lista.get(rowIndex).setPrecioVentaS(Double.parseDouble(aValue.toString()));
                break;
            case 6:
                lista.get(rowIndex).setMargenDescuentos(Double.parseDouble(aValue.toString()));
                break;
            case 7:
                lista.get(rowIndex).setOferta(aValue.toString());
                break;
            case 8:
                lista.get(rowIndex).setDescuentoComercial(Double.parseDouble(aValue.toString()));
                break;
            case 9:
                lista.get(rowIndex).setDescuentInternet(Double.parseDouble(aValue.toString()));
                break;
            case 10:
                lista.get(rowIndex).setPrecioUnitario(Double.parseDouble(aValue.toString()));
                break;
            case 11:
                lista.get(rowIndex).setIVA(Double.parseDouble(aValue.toString()));
                break;
            case 12:
                lista.get(rowIndex).setTotalNetoReng(Double.parseDouble(aValue.toString()));
                break;
            case 13:
                 lista.get(rowIndex).setGaceta(aValue.toString());
                break;
            case 14:
                lista.get(rowIndex).setNumPedidoArti(Integer.parseInt(aValue.toString()));
                break;
            case 15:
                lista.get(rowIndex).setCodMateriDrolanc(aValue.toString());
                break;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column != 3) {
            return true;
        } else {
            return false;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(FacturaRenglonBO sacturaBO) {
        lista.add(sacturaBO);
        this.fireTableDataChanged();
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
    
    public void limpiarRengloTabla(int cantLineas){
        for (int i = 0; i < cantLineas; i++) {
            this.removedRow(0);
            System.out.println("cantidad de veces " + i);
        }
    }
}
