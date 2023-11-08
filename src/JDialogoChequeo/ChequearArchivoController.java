/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogoChequeo;

import Modelo.ModeloTablaRecepcionMercancia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswigdev.Beans.FacturaRenglonBO;
import javaswingdev.form.VistaFacturaCompras;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author admin
 */
public class ChequearArchivoController implements ActionListener {

    JDialoChequearArchivos vista;
    VistaFacturaCompras vistaRecepcionMercancia;
    LeerArchivoFTP.LeerArchivoFtp leerArchivoFtp;
    ModeloTablaRecepcionMercancia modeloTablaRecepcionMercancia = new ModeloTablaRecepcionMercancia();
    public FacturaRenglonBO facturaBO;
    double IVA = 0, rentNeto = 0;

    public ChequearArchivoController(JDialoChequearArchivos vista) {
        this.vista = vista;
        vistaRecepcionMercancia = new VistaFacturaCompras("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ArrayList<FacturaRenglonBO> lista = new ArrayList<FacturaRenglonBO>();
        if (event.getSource() == vista.btnAceptar) {
            int select = vista.jTableListaArchivos.getSelectedRowCount();
            ArrayList<File> listaArchivos = new ArrayList<>();

            // selecino los nombres de los archivos 
            int[] filasleccionadas = vista.jTableListaArchivos.getSelectedRows();
            //Recorro el ciclo . para obtener los valores de las filas seleccionadas 
            for (int filaSeleccionada : filasleccionadas) {
                //System.out.println(vista.jTableListaArchivos.getValueAt(filaSeleccionada, 0));
                //leer el contenido de cada archivo seleccionado
                listaArchivos.add(new File("C:\\DescargasArchivoFTP\\Factura\\" + vista.jTableListaArchivos.getValueAt(filaSeleccionada, 0)));
//                    new File("C:\\DescargasArchivoFTP\\Factura\\" + vista.jTableListaArchivos.getValueAt(filaSeleccionada, 0))
            }

            for (int i = 0; i < select; i++) {
                FileReader fr = null;
                System.out.println("Acrvuivuivuiv  ::::::::::" + listaArchivos.get(i).getAbsoluteFile());
                try {
                    // Abrir el archivo
                    fr = new FileReader(listaArchivos.get(i).getAbsoluteFile());
                    // Crear un lector de datos
                    BufferedReader br = new BufferedReader(fr);
                    // Leer el contenido del archivo
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] vectoCadena = line.split(";");
                        if (vectoCadena[0].equals("S")) {

                        } else if (vectoCadena[0].equalsIgnoreCase("D")) {
                            facturaBO = new FacturaRenglonBO();
                            if (vectoCadena[11].isEmpty()) {
                                IVA = 0.0;
                            } else {
                                IVA = Double.parseDouble(vectoCadena[11]);
                            }

                            System.err.println("VALOR ::::::" + vectoCadena[12]);

//                        rentNeto = Double.parseDouble(vectoCadena[12].replaceAll(".", "") ) ;
                            facturaBO.setItem(i);
                            facturaBO.setNumFactura(vectoCadena[1]);
                            facturaBO.setCantdespachada(Integer.parseInt(vectoCadena[2]));
                            facturaBO.setCodBarra(vectoCadena[3]);
                            facturaBO.setDescripcionArt(vectoCadena[4]);
                            facturaBO.setPrecioVentaS(Double.parseDouble(vectoCadena[5].replaceAll(",", ".")));
                            facturaBO.setMargenDescuentos(Double.parseDouble(vectoCadena[6].replaceAll(",", ".")));
                            facturaBO.setOferta1(vectoCadena[7]);
                            facturaBO.setDescuentoComercial(Double.parseDouble(vectoCadena[8].replaceAll(",", ".")));
                            facturaBO.setDescuentInternet(Double.parseDouble(vectoCadena[9].replaceAll(",", ".")));
                            facturaBO.setPrecioUnitario(Double.parseDouble(vectoCadena[10].replaceAll(",", ".")));
                            facturaBO.setIVA(IVA);
                            facturaBO.setTotalNetoReng(rentNeto);
                            facturaBO.setGaceta(vectoCadena[13]);
                            facturaBO.setNumPedidoArti(Integer.parseInt(vectoCadena[14]));
                            facturaBO.setCodMateriDrolanc(vectoCadena[15]);
//                        facturaBO.setOferta1(vectoCadena[16]);
                            lista.add(facturaBO);
                        }

                        //Contenido 
                        System.out.println(line);
                    }       // Cerrar el archivo
                    br.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ChequearArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ChequearArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fr.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ChequearArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            modeloTablaRecepcionMercancia.setlistaRecepcionMercancia(lista);
            vistaRecepcionMercancia.jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);

            JTableHeader jTableHeader = vistaRecepcionMercancia.jtablePrincipalMercancia.getTableHeader();
            vistaRecepcionMercancia.jtablePrincipalMercancia.getTableHeader().setReorderingAllowed(false);
            TableColumnModel columnModel = vistaRecepcionMercancia.jtablePrincipalMercancia.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(60);//Item
            columnModel.getColumn(1).setPreferredWidth(100);//Numero Factura 
            columnModel.getColumn(2).setPreferredWidth(60); //Cantidad Despacho
            columnModel.getColumn(3).setPreferredWidth(120);// Cod Barra
            columnModel.getColumn(4).setPreferredWidth(439);//Descripcion Aproducto 
            columnModel.getColumn(5).setPreferredWidth(100);//Precio Sugerido
            columnModel.getColumn(6).setPreferredWidth(90);// Margen Descuento
            columnModel.getColumn(7).setPreferredWidth(90);//Oferta 1
            columnModel.getColumn(8).setPreferredWidth(120);//Descuento comercial
            columnModel.getColumn(9).setPreferredWidth(120);//Descuento de Internet
            columnModel.getColumn(10).setPreferredWidth(90);//Precio unitario del producto
            columnModel.getColumn(11).setPreferredWidth(90);//iva
            columnModel.getColumn(12).setPreferredWidth(90);//Total neto por renglón
            columnModel.getColumn(13).setPreferredWidth(90);// gaceta
            columnModel.getColumn(14).setPreferredWidth(100);// Número de pedido de Drolanca
            columnModel.getColumn(15).setPreferredWidth(100);//Codigo Material Drolanca

            modeloTablaRecepcionMercancia.refrescarTable();
            double precio1 = 0, precio$ = 0;
        }
//            System.out.println("cant archivos" +files );
    }

    public void cargarDatosTablaCatalogo(String codiFactura, String opcion) {
        ArrayList<FacturaRenglonBO> lista = new ArrayList<FacturaRenglonBO>();
        lista = leerArchivoFtp.ListaleerArchivoFacturaRenglon(codiFactura, opcion);

        modeloTablaRecepcionMercancia.setlistaRecepcionMercancia(lista);
        vistaRecepcionMercancia.jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);

        JTableHeader jTableHeader = vistaRecepcionMercancia.jtablePrincipalMercancia.getTableHeader();
        vistaRecepcionMercancia.jtablePrincipalMercancia.getTableHeader().setReorderingAllowed(false);
        TableColumnModel columnModel = vistaRecepcionMercancia.jtablePrincipalMercancia.getColumnModel();
        System.out.println("PARRA");
        columnModel.getColumn(0).setPreferredWidth(60);//Item
        columnModel.getColumn(1).setPreferredWidth(100);//Numero Factura 
        columnModel.getColumn(2).setPreferredWidth(60); //Cantidad Despacho
        columnModel.getColumn(3).setPreferredWidth(120);// Cod Barra
        columnModel.getColumn(4).setPreferredWidth(439);//Descripcion Aproducto 
        columnModel.getColumn(5).setPreferredWidth(100);//Precio Sugerido
        columnModel.getColumn(6).setPreferredWidth(90);// Margen Descuento
        columnModel.getColumn(7).setPreferredWidth(90);//Oferta 1
        columnModel.getColumn(8).setPreferredWidth(120);//Descuento comercial
        columnModel.getColumn(9).setPreferredWidth(120);//Descuento de Internet
        columnModel.getColumn(10).setPreferredWidth(90);//Precio unitario del producto
        columnModel.getColumn(11).setPreferredWidth(90);//iva
        columnModel.getColumn(12).setPreferredWidth(90);//Total neto por renglón
        columnModel.getColumn(13).setPreferredWidth(90);// gaceta
        columnModel.getColumn(14).setPreferredWidth(100);// Número de pedido de Drolanca
        columnModel.getColumn(15).setPreferredWidth(100);//Codigo Material Drolanca

        modeloTablaRecepcionMercancia.refrescarTable();
        double precio1 = 0, precio$ = 0;

        /* listaFactura = leerArchivoFtp.ListaleerArchivoFActuraEncabezado();
        
        txtTotal.setValue(listaFactura.get(0).getTotalFactura());
        txtExento.setValue(listaFactura.get(0).getBaseExentoIva());
        txtMontGravable.setValue(listaFactura.get(0).getBaseImponible());
        txtMontoDescuento.setValue(listaFactura.get(0).getDescuentoProntoPago());
        txtmontoImpuesto.setValue(listaFactura.get(0).getTotalIVA());
        
        System.out.println("Neto Factura" + listaFactura.get(0).getNetoFactura()
                + "\n Total otorgado por descuento de internet" + listaFactura.get(0).getTotalDescuentoespecial()
                + "\n Base imponible " + listaFactura.get(0).getBaseImponible()
                + "\n IvaPorc " + listaFactura.get(0).getIvaPorc()
                + "\n TotalIV " + listaFactura.get(0).getTotalIVA()
                + "\n DescuentoProntoPago " + listaFactura.get(0).getDescuentoProntoPago()
                + "\n otalProntoPago " + listaFactura.get(0).getTotalProntoPago()
                + "\n FechaFactura " + listaFactura.get(0).getFechaFactura()
                + "\n Nu de Bultos " + listaFactura.get(0).getNroBultos()
                + "\n Total unidades " + listaFactura.get(0).getTotalUnidades()
                + "\n Total Renglones " + listaFactura.get(0).getTotalRenglones()
                + "\n sF Productos con Precio Marcado " + listaFactura.get(0).getProductoPrecioMarcadosBsF()
                + "\n Exce " + listaFactura.get(0).getBaseExentoIva()
                + "\n getProductoSinPrecioMarcadosBsF " + listaFactura.get(0).getProductoSinPrecioMarcadosBsF()
        );
        
        txtTotal$.setValue(precio$);*/
        // setCantidadListRengl(lista.size());
    }

}
