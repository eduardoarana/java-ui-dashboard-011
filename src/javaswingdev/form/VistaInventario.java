/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingdev.form;

import Modelo.ModeloTablaInventario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javaswigdev.Beans.InventarioBO;
import javax.swing.table.TableColumnModel;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author admin
 */
public class VistaInventario extends javax.swing.JPanel {

    /**
     * Creates new form VistaInventario
     */
    ModeloTablaInventario modeloTablaInventario = new ModeloTablaInventario();

    public VistaInventario() {
        initComponents();

        TableColumnModel columnModel = JtablaInventario.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);//Código del material
        columnModel.getColumn(1).setPreferredWidth(100);//Código de Barra
        columnModel.getColumn(2).setPreferredWidth(160); //Descripción del Materia
        columnModel.getColumn(3).setPreferredWidth(80);// Cod Linea
        columnModel.getColumn(4).setPreferredWidth(160);//Descripción de línea 
        columnModel.getColumn(5).setPreferredWidth(80);//Cant Bulto original
        columnModel.getColumn(6).setPreferredWidth(80);// IVA
        columnModel.getColumn(7).setPreferredWidth(100);//Gaceta
        columnModel.getColumn(8).setPreferredWidth(90);//Precio Referencial
        columnModel.getColumn(9).setPreferredWidth(80);//Existencia
        columnModel.getColumn(10).setPreferredWidth(80);//Entrada Dia
        columnModel.getColumn(11).setPreferredWidth(90);//Descuento L1

        columnModel.getColumn(12).setPreferredWidth(90);//Descuento L2

        columnModel.getColumn(13).setPreferredWidth(90);// Descuento L1

        columnModel.getColumn(14).setPreferredWidth(100);// Tipo Oferta 1
        columnModel.getColumn(15).setPreferredWidth(100);// Cantidad Oferta 1-1

        columnModel.getColumn(16).setPreferredWidth(100);// Porcentaje Oferta 1-1
        columnModel.getColumn(17).setPreferredWidth(100);// Cantidad Oferta 1-2
        columnModel.getColumn(18).setPreferredWidth(100);// Porcentaje Oferta 1-2
        columnModel.getColumn(19).setPreferredWidth(100);// Cantidad Oferta 1-3
        columnModel.getColumn(20).setPreferredWidth(100);// Porcentaje Oferta 1-3
        columnModel.getColumn(21).setPreferredWidth(100);// Cantidad Oferta 2-1
        columnModel.getColumn(22).setPreferredWidth(100);// Porcentaje Oferta 2-1
        columnModel.getColumn(23).setPreferredWidth(100);// Cantidad Oferta 2-3

        columnModel.getColumn(24).setPreferredWidth(100);// Porcentaje Oferta 2-3
        columnModel.getColumn(25).setPreferredWidth(100);// Tipo Oferta 3
        columnModel.getColumn(26).setPreferredWidth(100);// Cantidad Oferta 3-1
        columnModel.getColumn(27).setPreferredWidth(100);// Porcentaje Oferta 3-1
        columnModel.getColumn(28).setPreferredWidth(100);// Cantidad Oferta 3-2
        columnModel.getColumn(29).setPreferredWidth(100);// Porcentaje Oferta 3-2
        columnModel.getColumn(30).setPreferredWidth(100);// Cantidad Oferta 3-3
        columnModel.getColumn(31).setPreferredWidth(100);// Porcentaje Oferta 3-3
        columnModel.getColumn(32).setPreferredWidth(100);// condicion de pago por material
        columnModel.getColumn(33).setPreferredWidth(100);// Descripcion de condicion de pago por material

    }

    //Metodo , Descargar el Archivo factura Seleccionado . 
    public void conectarDescargarArchivo(String archivo) {
        String server = "ftp.drolanca.com";
        int port = 21;
        String user = "18919";
        String pass = "18919";
        String remoteFilePath = "/Inventario/" + archivo;
        String localFilePath = "C:\\DescargasArchivoFTP\\inventario\\" + archivo;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            OutputStream outputStream = new FileOutputStream(localFilePath);
            boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);

            if (success) {
                System.out.println("El archivo se ha Descargado Exitosamente....");

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtablaInventario = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/nuevo.png"))); // NOI18N
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Guardar.png"))); // NOI18N
        jButton7.setToolTipText("Guardar");
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/update.png"))); // NOI18N
        jButton6.setToolTipText("Actualizar");
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Eliminar.png"))); // NOI18N
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/positivoMas.png"))); // NOI18N
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/importar.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        JtablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código del material ", "Código de Barra", "Descripción del Material ", "Código de línea ", "Descripción de línea", "Cantidad de bulto original", "IVA", "Gaceta", "Precio Referencial ", "Existencia", "Entrada del día", "Descuento L1 ", "Descuento L2 ", "Descuento L3", "Tipo Oferta 1 ", "Cantidad Oferta 1-1", "Porcentaje Oferta 1-1 ", "Cantidad Oferta 1-2", "Porcentaje Oferta 1-2 ", "Cantidad Oferta 1-3", "Porcentaje Oferta 1-3", "Tipo Oferta 2", "Cantidad Oferta 2-1", "Porcentaje Oferta 2-1 ", "Cantidad Oferta 2-2 ", "Porcentaje Oferta 2-2", "Cantidad Oferta 2-3 ", "Porcentaje Oferta 2-3", "Tipo Oferta 3 ", "Cantidad Oferta 3-1 ", "Porcentaje Oferta 3-1 ", "Cantidad Oferta 3-2", "Porcentaje Oferta 3-2 ", "Cantidad Oferta 3-3 ", "Porcentaje Oferta 3-3 ", "Condición de pago por material", "Descripción de condición Pago"
            }
        ));
        JtablaInventario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(JtablaInventario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1110, 470));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        //Primero descargo el Archivo ..
        conectarDescargarArchivo("Inventario.txt");
        FileReader fr = null;
        //Ruta donde va hacer leida el Archivo ...
        try {
            File archivo = new File("C:\\DescargasArchivoFTP\\inventario\\" + "inventario.txt");
            // Crear una instancia de la clase FileReader para el archivo que queremos abrir.
            fr = new FileReader(archivo);
            //Lee el Archivo descargado ...
            BufferedReader br = new BufferedReader(fr);
            String linea;
            ArrayList<InventarioBO> listaInventario = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                String[] vectoCadena = linea.split(";");
                System.out.println("" + linea);
                InventarioBO inventarioBO = new InventarioBO();
                inventarioBO.setCodigoArticulo(vectoCadena[0]);
                inventarioBO.setCodigoBarra(vectoCadena[1]);
                inventarioBO.setArticuloDescripcion(vectoCadena[2]);
                inventarioBO.setCodigoLinea(vectoCadena[3]);
                // inventarioBO.setCantBulto(Integer.parseInt(vectoCadena[4]));
                inventarioBO.setIVA(Double.parseDouble(vectoCadena[5]));
                inventarioBO.setGaceta(Double.parseDouble(vectoCadena[6]));
                inventarioBO.setExistencia(Integer.parseInt(vectoCadena[7]));
                inventarioBO.setEntradaDelDia(Double.parseDouble(vectoCadena[8].replace(",", ".")));
                inventarioBO.setDescuentoL1(Double.parseDouble(vectoCadena[9]));
                inventarioBO.setDescuentoL2(Double.parseDouble(vectoCadena[10]));
                inventarioBO.setDescuentoL3(Double.parseDouble(vectoCadena[11].replace(",", "")));
                inventarioBO.setTipoOferta(vectoCadena[12]);
                inventarioBO.setCantidadOferta11(Integer.parseInt(vectoCadena[13].replace(",", "")));
//                inventarioBO.setPorcentajeOferta(Integer.parseInt(vectoCadena[14].replace(",", "")));
                inventarioBO.setCantidadOferta12(Integer.parseInt(vectoCadena[15].replace(",", "")));
                inventarioBO.setPorcentajeOferta12(Double.parseDouble(vectoCadena[16].replace(",", "")));
                inventarioBO.setCantidadOferta13(Integer.parseInt(vectoCadena[17].replace(",", "")));
                inventarioBO.setPorsentajeOferta13(Double.parseDouble(vectoCadena[18].replace(",", "")));
                inventarioBO.setTipoOferta2(vectoCadena[18]);
                inventarioBO.setCantidadOferta21(Integer.parseInt(vectoCadena[19]));
                inventarioBO.setPorcentajeOferta21(Double.parseDouble(vectoCadena[20].replace(",", "")));
//                inventarioBO.setCantidadOferta22(Integer.parseInt(vectoCadena[21].replace(",", "")));
                inventarioBO.setPorcentajeOferta22(Double.parseDouble(vectoCadena[22].replace(",", "")));
                inventarioBO.setCantidadOferta23(Integer.parseInt(vectoCadena[23].replace(",", "")));
                inventarioBO.setPorcentajeOferta23(Double.parseDouble(vectoCadena[24].replace(",", "")));
                inventarioBO.setTipoOferta3(vectoCadena[25]);
                inventarioBO.setCantidadOferta31(Integer.parseInt(vectoCadena[26]));
                inventarioBO.setPorcentajeOferta31(Double.parseDouble(vectoCadena[27].replace(",", "")));
//                inventarioBO.setCantidadOferta32(Integer.parseInt(vectoCadena[28]));
                inventarioBO.setPorcentajeOferta32(Double.parseDouble(vectoCadena[29].replace(",", "")));
                inventarioBO.setCantidadOferta33(Integer.parseInt(vectoCadena[30].replace(",", "")));
                inventarioBO.setPorcentajeOferta33(Double.parseDouble(vectoCadena[31].replace(",", "")));
                inventarioBO.setCondicionPagoMaterial(vectoCadena[32]);
                inventarioBO.setDescripcionCondicionPagoMaterial(vectoCadena[33]);
                listaInventario.add(inventarioBO);
                /*
                    1 )trabajos redaccion de contenido.. 
                    leer textos 
                    2 )asistente virtual
                    3)atension al cliente ..
                    4)Traducciones ..
                    5)Data entry
                 */
            }

            modeloTablaInventario.setlistaInventario(listaInventario);
            JtablaInventario.setModel(modeloTablaInventario);
            TableColumnModel columnModel = JtablaInventario.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);//codigo Material
            columnModel.getColumn(1).setPreferredWidth(100);//Codigo Barra 
            columnModel.getColumn(2).setPreferredWidth(180); //Descripcion del Material
            columnModel.getColumn(3).setPreferredWidth(100);// Codigo Linea
            columnModel.getColumn(4).setPreferredWidth(109);//Descripcion de la Linea 
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

            modeloTablaInventario.refrescarTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    public void cargarDatosInventario() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JtablaInventario;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
