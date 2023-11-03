package javaswingdev.form;

import JDialogoChequeo.ModeloTablaDialogo;
import LeerArchivoFTP.LeerArchivoFtp;
import Modelo.ClienteModelo;
import Modelo.FacturaCompraModelo;
import Modelo.ModeloTablaCatalogo;
import Modelo.ModeloTablaRecepcionMercancia;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswigdev.Beans.FacturaRenglonBO;
import javaswigdev.Beans.FacturaVentaBO;
import javaswigdev.Beans.ListaArchivosBO;
import javaswing.controller.RecepcionMercanciaController;
import javaswing.utilitario.Utilitario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.commons.net.ftp.FTPClient;

public class VistaFacturaCompras extends javax.swing.JPanel {

    int resultado = 0;
    // InventarioBO invetaInventarioCaracasBO = new InventarioBO();
    LeerArchivoFTP.LeerArchivoFtp leerArchivoFtp;
    Modelo.ModeloTablaCatalogo modeloTablaCatalogo = new ModeloTablaCatalogo();
    ModeloTablaRecepcionMercancia modeloTablaRecepcionMercancia = new ModeloTablaRecepcionMercancia();

    ClienteModelo modeloCliente;
    RecepcionMercanciaController controller;
    FacturaCompraModelo modeloFacturaCompra;
    double precio1 = 0, precio$ = 0, montoGravable = 0, montoGravable$ = 0, montoDescuento$, montoExcento$, montoImpuesto$;
    public FacturaRenglonBO facturaRenglonBO;
    public int i = 0;
    double IVA = 0, rentNeto = 0;

    public VistaFacturaCompras(String name) {
        initComponents();
        controller = new RecepcionMercanciaController(this);
        leerArchivoFtp = new LeerArchivoFtp();
        modeloFacturaCompra = new FacturaCompraModelo();
        // lb.setText("Form " + name);
        modeloCliente = new ClienteModelo();
        btnAgregar.addActionListener(controller);
        jtablePrincipalMercancia.setEditingRow(0);
        fechaFactura.setDate(new Date());
        fechaVen.setDate(new Date());
        txtTasa.setValue(modeloFacturaCompra.pObtenerFechaTasa("BSD", Utilitario.fechaActual()).get(0).getTasa_c());

        jComboClientes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboClientes.getEditor().getItem().toString();

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    jComboClientes.setModel(modeloCliente.getListaComboBox(cadenaEscrita, "saProveedor", "prov_des", 1));

                    if (jComboClientes.getItemCount() > 0) {
                        jComboClientes.getEditor().setItem(cadenaEscrita);
                        jComboClientes.showPopup();
                    }
                }
            }
        });

        jComboCondicionPago.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboCondicionPago.getEditor().getItem().toString();

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    jComboCondicionPago.setModel(modeloCliente.getListaComboBox(cadenaEscrita, "saCondicionPago", "cond_des", 1));

                    if (jComboCondicionPago.getItemCount() > 0) {
                        jComboCondicionPago.getEditor().setItem(cadenaEscrita);
                        jComboCondicionPago.showPopup();
                    }
                }
            }
        });

        jComboBoxUnidad.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxUnidad.getEditor().getItem().toString();

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    jComboBoxUnidad.setModel(modeloCliente.getListaComboBox(cadenaEscrita, "saUnidad", "des_uni", 1));

                    if (jComboBoxUnidad.getItemCount() > 0) {
                        jComboBoxUnidad.getEditor().setItem(cadenaEscrita);
                        jComboBoxUnidad.showPopup();
                    }
                }
            }
        });

        jComboBoxAlmacen.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxAlmacen.getEditor().getItem().toString();

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    jComboBoxAlmacen.setModel(modeloCliente.getListaComboBox(cadenaEscrita, "saAlmacen", "des_alma", 1));

                    if (jComboBoxAlmacen.getItemCount() > 0) {
                        jComboBoxAlmacen.getEditor().setItem(cadenaEscrita);
                        jComboBoxAlmacen.showPopup();
                    }
                }
            }
        });
        
         TableColumnModel columnModel = jtablePrincipalMercancia.getColumnModel();
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
//        columnModel.getColumn(15).setPreferredWidth(100);//Codigo Material Drolanca
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogCatalogo = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaCatalogo = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jDialogCliente = new javax.swing.JDialog();
        jDialogSeleccionarArchivos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableListaArchivos = new javax.swing.JTable();
        btnAceptar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fechaFactura = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fechaVen = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtNroFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNroControl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        txtTotal$ = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboClientes = new javax.swing.JComboBox<>();
        jComboCondicionPago = new javax.swing.JComboBox<>();
        txtSubTotal = new javax.swing.JFormattedTextField();
        txtSubTotal$ = new javax.swing.JFormattedTextField();
        txtMontGravable = new javax.swing.JFormattedTextField();
        txtMontoGravable$ = new javax.swing.JFormattedTextField();
        txtMontoDescuento = new javax.swing.JFormattedTextField();
        txtmontoImpuesto = new javax.swing.JFormattedTextField();
        txtmontoImpuesto$ = new javax.swing.JFormattedTextField();
        txtMontoDescuento$ = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jComboBoxUnidad = new javax.swing.JComboBox<>();
        jComboBoxAlmacen = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablePrincipalMercancia = new javax.swing.JTable();
        barraDescarga = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        txtBusquda = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        txtTasa = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        btnCargarArchivoFTP = new javax.swing.JButton();

        jDialogCatalogo.setTitle("Catalogo");

        jTablaCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero de Factura", "Fecha Factura", "ProveedorDescrip", "Estatus Compra", "Automatico Despto"
            }
        ));
        jScrollPane1.setViewportView(jTablaCatalogo);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogCatalogoLayout = new javax.swing.GroupLayout(jDialogCatalogo.getContentPane());
        jDialogCatalogo.getContentPane().setLayout(jDialogCatalogoLayout);
        jDialogCatalogoLayout.setHorizontalGroup(
            jDialogCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCatalogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jDialogCatalogoLayout.setVerticalGroup(
            jDialogCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jDialogCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogClienteLayout = new javax.swing.GroupLayout(jDialogCliente.getContentPane());
        jDialogCliente.getContentPane().setLayout(jDialogClienteLayout);
        jDialogClienteLayout.setHorizontalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialogClienteLayout.setVerticalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jDialogSeleccionarArchivos.setTitle("Archivo FTP");

        jTableListaArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListaArchivos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(jTableListaArchivos);

        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Aceptar.png"))); // NOI18N
        btnAceptar1.setToolTipText("Aceptar");
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancelar.png"))); // NOI18N
        jButton1.setToolTipText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSeleccionarArchivosLayout = new javax.swing.GroupLayout(jDialogSeleccionarArchivos.getContentPane());
        jDialogSeleccionarArchivos.getContentPane().setLayout(jDialogSeleccionarArchivosLayout);
        jDialogSeleccionarArchivosLayout.setHorizontalGroup(
            jDialogSeleccionarArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSeleccionarArchivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jDialogSeleccionarArchivosLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jDialogSeleccionarArchivosLayout.setVerticalGroup(
            jDialogSeleccionarArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSeleccionarArchivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogSeleccionarArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/nuevo.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/update.png"))); // NOI18N
        jButton6.setToolTipText("Actualizar");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Guardar.png"))); // NOI18N
        jButton7.setToolTipText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Eliminar.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/positivoMas.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha Fact:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 12, 68, 22));
        jPanel1.add(fechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 14, 128, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha Ven:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 68, 22));
        jPanel1.add(fechaVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 128, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("N Factura:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 43, 58, -1));

        txtNroFactura.setToolTipText("");
        jPanel1.add(txtNroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 128, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("N Control:");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 69, 58, -1));

        txtNroControl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNroControl.setToolTipText("");
        jPanel1.add(txtNroControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 66, 128, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SubTotal:");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 55, 68, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Gravable:");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 81, 68, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Descuento:");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 109, 68, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Impuesto:");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 137, 68, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total:");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 163, 68, -1));

        txtTotal.setEditable(false);
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtTotal.setText("00");
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 160, 128, -1));

        txtTotal$.setEditable(false);
        txtTotal$.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtTotal$.setText("00");
        jPanel1.add(txtTotal$, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 160, 122, -1));

        jLabel12.setText("Monto en $");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 12, 112, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Prove:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 16, 50, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cond Pago:");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 43, -1, -1));

        jComboClientes.setEditable(true);
        jComboClientes.setToolTipText("Proveedor");
        jComboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClientesActionPerformed(evt);
            }
        });
        jPanel1.add(jComboClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 13, 222, -1));

        jComboCondicionPago.setEditable(true);
        jPanel1.add(jComboCondicionPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 40, 222, -1));

        txtSubTotal.setEditable(false);
        txtSubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtSubTotal.setText("00");
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 52, 128, -1));

        txtSubTotal$.setEditable(false);
        txtSubTotal$.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtSubTotal$.setText("00");
        jPanel1.add(txtSubTotal$, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 52, 122, -1));

        txtMontGravable.setEditable(false);
        txtMontGravable.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtMontGravable.setText("00");
        jPanel1.add(txtMontGravable, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 78, 128, -1));

        txtMontoGravable$.setEditable(false);
        txtMontoGravable$.setText("00");
        jPanel1.add(txtMontoGravable$, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 78, 122, -1));

        txtMontoDescuento.setEditable(false);
        txtMontoDescuento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtMontoDescuento.setText("00");
        jPanel1.add(txtMontoDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 103, 128, -1));

        txtmontoImpuesto.setEditable(false);
        txtmontoImpuesto.setText("00");
        jPanel1.add(txtmontoImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 134, 128, -1));

        txtmontoImpuesto$.setEditable(false);
        txtmontoImpuesto$.setText("00");
        jPanel1.add(txtmontoImpuesto$, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 134, 122, -1));

        txtMontoDescuento$.setEditable(false);
        txtMontoDescuento$.setText("00");
        jPanel1.add(txtMontoDescuento$, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 103, 122, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Descripcion:");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 147, 73, -1));

        txtDescripcion.setToolTipText("descripcion");
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 144, 222, -1));

        jComboBoxUnidad.setEditable(true);
        jPanel1.add(jComboBoxUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 66, 222, -1));

        jComboBoxAlmacen.setEditable(true);
        jPanel1.add(jComboBoxAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 97, 222, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Unidad:");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 69, 63, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Amacen:");
        jLabel18.setToolTipText("");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, 63, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtablePrincipalMercancia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item", "Numero Factura", "Cant D", "Cod Barra", "Descripcion del Art", "Margen Descuento", "Oferta", "Descuento Comer", "Descuento Inter", "Precio Uni", "IVA", "Neto", "Gaceta", "Numero Pedido", "Codi Material"
            }
        ));
        jtablePrincipalMercancia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jtablePrincipalMercancia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraDescarga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Buscar :");

        txtBusquda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBusquda.setToolTipText("Buscar");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/importar.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtTasa.setEditable(false);
        txtTasa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtTasa.setText("00");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tasa :");

        btnCargarArchivoFTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seleccionde Factura.png"))); // NOI18N
        btnCargarArchivoFTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoFTPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarArchivoFTP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTasa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusquda, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarArchivoFTP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        jDialogCatalogo.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        int selection = jTablaCatalogo.getSelectedRow();
        int[] selected = jTablaCatalogo.getSelectedRows();
        Object value;
        ArrayList<FacturaRenglonBO> lista = null;
        System.out.println("Cantidad de Filas  ....." + selected.length);
        if (selected.length > 0) {
            for (int i = 0; i < selected.length; i++) {
                // get Table data

                System.out.println("Iteracion : " + i + " selected[i]  " + selected[i]);
                TableModel tm = jTablaCatalogo.getModel();
                value = tm.getValueAt(i, selection);
                System.out.println("VALUE Codigo: " + jTablaCatalogo.getValueAt(i, 0).toString());
//                lista = leerArchivoFtp.ListaleerArchivoFacturaRenglon(
//                        jTablaCatalogo.getValueAt(i, 0).toString(),
//                        "uno");//(jTablaCatalogo.getValueAt(selection, 0).toString(), "uno");

                //  System.out.println("VALOORORORORO " + leerArchivoFtp.ListaleerArchivoFacturaRenglon(jTablaCatalogo.getValueAt(selection, i).toString(), "uno"));
                System.out.println("tamaño de la lista:" + lista.size());
                modeloTablaRecepcionMercancia.setlistaRecepcionMercancia(lista);
                jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);
                modeloTablaRecepcionMercancia.refrescarTable();
//                txtNroFactura.setText(String.valueOf(lista.get(i).getCodigoFactura()));
//                txtTotal.setValue(lista.get(i).getPrecio1());
//                txtTotal$.setValue(lista.get(i).getPrecio2());

//                fechaFactura//.setDate(lista.get(0).getFechaEmision());
//                        .setDate(Utilitario.obtenerFecha(lista.get(i).getFechaEmision()));
//                fechaVen.setDate(Utilitario.obtenerFecha(lista.get(i).getFechaEmision()));
            }
            int cantidadRows = jTablaCatalogo.getRowCount();
            for (int i = 0; i < cantidadRows; i++) {

            }
        }
        System.out.println("seleccion ....." + selection);

        System.out.println("Datos ....." + jTablaCatalogo.getValueAt(selection, 0).toString());

        jDialogCatalogo.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jComboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClientesActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        FacturaRenglonBO facturaBO = new FacturaRenglonBO();
        facturaBO.setItem(1);
        facturaBO.setIVA(0);

        modeloTablaRecepcionMercancia.addRow(facturaBO);
        modeloTablaRecepcionMercancia.refrescarTable();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        modeloTablaRecepcionMercancia.removedRow(jtablePrincipalMercancia.getSelectedRow());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        settearCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCargarArchivoFTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoFTPActionPerformed
        // TODO add your handling code here:
        i = 1;
        cargarDatosArchivos();
        jDialogSeleccionarArchivos.setSize(503, 510);
        jDialogSeleccionarArchivos.setLocationRelativeTo(null);

        jDialogSeleccionarArchivos.setVisible(true);
//        JDialogoChequeo.JDialoChequearArchivos dialoChequearArchivos = new JDialoChequearArchivos(null, true);
//        dialoChequearArchivos.setSize(503, 510);
//        dialoChequearArchivos.setVisible(true);
    }//GEN-LAST:event_btnCargarArchivoFTPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jDialogSeleccionarArchivos.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        // TODO add your handling code here:
        //

        // Validar el campo Tasa 
        ArrayList<FacturaRenglonBO> listaRenglon = new ArrayList<FacturaRenglonBO>();
        ArrayList<FacturaVentaBO> listaFactura = new ArrayList<>();

        int select = jTableListaArchivos.getSelectedRowCount();
        if (txtTasa.getText().toString().equals("00")) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe colocar la tasa", "Software", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (select <= 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar un archivo", "Software", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int[] filasArchivosSeleccionadas = jTableListaArchivos.getSelectedRows();
        for (int filaSeleccionada : filasArchivosSeleccionadas) {
            FileReader fr = null;
            try {
                String archivoSeleccionado = (String) jTableListaArchivos.getValueAt(filaSeleccionada, 0);
                conectarDescargarArchivo(archivoSeleccionado);
                System.out.println("Valor seleccionado: " + archivoSeleccionado);
                //Ruta donde va hacer leida el Archivo ...
                File archivo = new File("C:\\DescargasArchivoFTP\\Factura\\" + archivoSeleccionado);
                // Crear una instancia de la clase FileReader para el archivo que queremos abrir.
                fr = new FileReader(archivo);
                //Lee el Archivo descargado ...
                BufferedReader br = new BufferedReader(fr);
                String linea;

                while ((linea = br.readLine()) != null) {

                    String[] vectoCadena = linea.split(";");
                    if (vectoCadena[0].equals("D")) {
                        if (vectoCadena[11].isEmpty()) {
                            IVA = 0.0;
                        } else {
                            IVA = Double.parseDouble(vectoCadena[11].replaceAll(",", "."));
                        }
                        if (vectoCadena[12].isEmpty()) {
                            rentNeto = 00;
                        } else {
                            rentNeto = Double.parseDouble(vectoCadena[12].replaceAll(",", ".").replace(".", ""));
                        }

                        facturaRenglonBO = new FacturaRenglonBO();
                        facturaRenglonBO.setItem(i);
                        facturaRenglonBO.setNumFactura(vectoCadena[1]);
                        facturaRenglonBO.setCantdespachada(Integer.parseInt(vectoCadena[2]));
                        facturaRenglonBO.setCodBarra(vectoCadena[3]);
                        facturaRenglonBO.setDescripcionArt(vectoCadena[4]);
                        facturaRenglonBO.setPrecioVentaS(Double.parseDouble(vectoCadena[5].replaceAll(",", ".").replace(".", "")));
                        facturaRenglonBO.setMargenDescuentos(Double.parseDouble(vectoCadena[6].replaceAll(",", ".")));
                        facturaRenglonBO.setOferta1(vectoCadena[7]);
                        facturaRenglonBO.setDescuentoComercial(Double.parseDouble(vectoCadena[8].replaceAll(",", ".")));
                        facturaRenglonBO.setDescuentInternet(Double.parseDouble(vectoCadena[9].replaceAll(",", ".")));
                        facturaRenglonBO.setPrecioUnitario(Double.parseDouble(vectoCadena[10].replaceAll(",", ".")));
                        facturaRenglonBO.setIVA(IVA);
                        facturaRenglonBO.setTotalNetoReng(rentNeto);
                        facturaRenglonBO.setGaceta(vectoCadena[13]);
                        facturaRenglonBO.setNumPedidoArti(Integer.parseInt(vectoCadena[14]));
                        facturaRenglonBO.setCodMateriDrolanc(vectoCadena[15]);
//                        facturaRenglonBO.setOferta1(vectoCadena[16]);
                        listaRenglon.add(facturaRenglonBO);
                        i++;
                    } else if (vectoCadena[0].equals("S")) {

                        System.out.println("Entrando a lacondicion ");
                        FacturaVentaBO facturaVentaBO = new FacturaVentaBO();
                        facturaVentaBO.setTotalOtorgadoDescuentoInternet(Double.parseDouble(vectoCadena[1].replaceAll(",", ".")));
                        facturaVentaBO.setTotalDescuentoespecial(Double.parseDouble(vectoCadena[2].replaceAll(",", ".")));
                        facturaVentaBO.setNetoFactura(Double.parseDouble(vectoCadena[3].replace(".", "").replace(",", ".")));
                        facturaVentaBO.setBaseImponible(Double.parseDouble(vectoCadena[4].replaceAll(",", ".").replace(".", "")));
                        facturaVentaBO.setIvaPorc(Double.parseDouble(vectoCadena[5].replaceAll(",", ".")));
                        facturaVentaBO.setTotalIVA(Double.parseDouble(vectoCadena[6].replaceAll(",", ".")));
                        facturaVentaBO.setTotalFactura(Double.parseDouble(vectoCadena[7].replace(".", "").replace(",", ".")));
                        facturaVentaBO.setDescuentoProntoPago(Double.parseDouble(vectoCadena[8].replaceAll(",", ".").replace(".", "")));
                        facturaVentaBO.setTotalProntoPago(Double.parseDouble(vectoCadena[9].replaceAll(",", ".").replace(".", "")));
                        facturaVentaBO.setFechaFactura(vectoCadena[10].replaceAll(",", "."));
                        facturaVentaBO.setNroBultos(Integer.parseInt(vectoCadena[11].replaceAll(",", ".")));
                        facturaVentaBO.setTotalUnidades(Double.parseDouble(vectoCadena[12].replaceAll(",", ".")));
                        facturaVentaBO.setTotalRenglones(Double.parseDouble(vectoCadena[12].replaceAll(",", ".")));
                        facturaVentaBO.setProductoPrecioMarcadosBsF(Double.parseDouble(vectoCadena[13].replaceAll(",", ".")));
                        facturaVentaBO.setBaseExentoIva(Double.parseDouble(vectoCadena[14].replaceAll(",", ".").replace(".", "")));
                        facturaVentaBO.setProductoSinPrecioMarcadosBsF(Double.parseDouble(vectoCadena[15].replaceAll(",", ".").replace(".", "")));
                        listaFactura.add(facturaVentaBO);
                    }
                    i = i;
                }
                br.close();
                modeloTablaRecepcionMercancia.setlistaRecepcionMercancia(listaRenglon);
                jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);
                TableColumnModel columnModel = jtablePrincipalMercancia.getColumnModel();
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
                System.out.println("TORTAL FACTURA   " + listaFactura.size());
                double total = 0, total$ = 0, subTotal = 0, subTotal$ = 0, tasa = 0;
                for (int j = 0; j < listaFactura.size(); j++) {
                    total = total + listaFactura.get(j).getNetoFactura();
                    subTotal += listaFactura.get(j).getTotalFactura(); //setTotalFactura
                }
                tasa = Double.parseDouble(txtTasa.getValue().toString());
                total$ = total / tasa;
                subTotal$ = subTotal / tasa;
                System.out.println("SUMA TOTAL" + total + " getNetoFactura()  " + listaFactura.get(0).getNetoFactura());
                txtTotal.setValue(total);
                txtSubTotal.setValue(subTotal);
                txtSubTotal$.setValue(subTotal$);
                txtTotal$.setValue(total$);
                modeloTablaRecepcionMercancia.refrescarTable();
                jDialogSeleccionarArchivos.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VistaFacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VistaFacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(VistaFacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        int cantidaRow = jtablePrincipalMercancia.getRowCount();
        if (cantidaRow == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "El Documento no puede ser grabado sin renglones", "Software", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (jComboClientes.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar un Proveedor", "Software", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (jComboCondicionPago.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una Condicion de Pago ", "Software", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (jComboBoxUnidad.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una Unidad de Pago ", "Software", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (jComboBoxAlmacen.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar un Almacen ", "Software", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int e = 0; e < cantidaRow; e++) {
            //valida si existe la unidad del articulo relacionado
            int existe = modeloFacturaCompra.existeArticuloUnidad(jtablePrincipalMercancia.getValueAt(e, 3).toString(),
                    jComboBoxUnidad.getSelectedItem().toString());
            if (existe == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "No existe relacion Cod unidad : "
                        + jComboBoxUnidad.getSelectedItem().toString() + ", para el articulo : " + jtablePrincipalMercancia.getValueAt(e, 3).toString(),
                        "Software", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        resultado = modeloFacturaCompra.
                pInsertarCotizacionProveedor(
                        txtNroFactura.getText(),//sDoc_Num,
                        null, //sNro_Fact, 
                        txtDescripcion.getText(), // sDescrip, 
                        jComboClientes.getSelectedItem().toString(),// sCo_Prov
                        null, //sCo_Cta_Ingr_Egr,
                        "BS",//sCo_Mone, 
                        jComboCondicionPago.getSelectedItem().toString(), //sCo_Cond, 
                        txtNroControl.getText(), // sN_Control, 
                        "00", // sPorc_Desc_Glob, 
                        Utilitario.obtenerFecha(fechaFactura), //sdFec_Emis,
                        Utilitario.obtenerFecha(fechaVen),//sdFec_Venc,
                        Utilitario.obtenerFecha(fechaFactura), //sdFec_Reg,
                        0,//@bAnulado
                        "0",// sStatus,
                        Double.parseDouble(txtTasa.getText().replace(",", ".")),//@deTasa
                        "0",//sPorc_Reca,
                        Double.parseDouble(txtSubTotal.getValue().toString()),//@deSaldo
                        Double.parseDouble(txtTotal.getValue().toString()), //@deTotal_Bruto
                        Double.parseDouble(txtTotal.getValue().toString()),//@deTotal_Neto
                        0,///@deMonto_Desc_Glob
                        0,//@deMonto_Reca
                        0,//@deOtros1
                        0,//@deOtros2
                        0,//@deOtros3
                        0, //deMonto_Imp 
                        0, //@deMonto_Imp2
                        0,//@deMonto_Imp3
                        "Direccion Entrega", //@sDir_Ent
                        "Comentario ",//sComentario,
                        0,//@bImpresa
                        null, //sSalestax,
                        null, //sDis_cen,
                        null, //sCampo1, 
                        null, //sCampo2,
                        null, //sCampo3, 
                        null, //sCampo4, 
                        null, //sCampo5, 
                        null, //sCampo6,
                        null, //sCampo7, 
                        null, //sCampo8,
                        null, // sRevisado,
                        null, // sTrasnfe,
                        "", //sCo_Us_In,
                        "val",// sCo_Sucu_In,
                        Utilitario.nombreHost(), //sMaquina,
                        0 //resulta
                );

        for (int j = 0; j < cantidaRow; j++) {
            modeloFacturaCompra.pInsertarRenglonesCotizacionProveedor(
                    Integer.parseInt(jtablePrincipalMercancia.getValueAt(j, 0).toString()), //iReng_Num
                    txtNroFactura.getText(),// sDoc_num,
                    jtablePrincipalMercancia.getValueAt(j, 4).toString(), //sCo_art,
                    jtablePrincipalMercancia.getValueAt(j, 4).toString(),// sDes_Art,
                    jComboBoxUnidad.getSelectedItem().toString(), // sCo_Uni,
                    null, // sSCo_Uni, 
                    jComboBoxAlmacen.getSelectedItem().toString(), // sCo_Almacen, 
                    "1",// sTipo_imp,
                    "0", // sTipo_Imp2,
                    "0", //sTipo_Imp3,
                    null, // sTipo_Doc,
                    "0", // sPorc_Desc,
                    null,// sNum_Doc,
                    null, //gRowGuid_Doc,
                    Double.parseDouble(jtablePrincipalMercancia.getValueAt(j, 12).toString()),// deReng_Neto
                    Double.parseDouble(jtablePrincipalMercancia.getValueAt(j, 10).toString()),//deCost_Unit
                    0,//@deCost_Unit_OM
                    Double.parseDouble(jtablePrincipalMercancia.getValueAt(j, 2).toString()),//@deTotal_Art
                    0,//deSTotal_Art
                    0,//deOtros
                    1,//dePorc_Imp
                    2,//dePorc_Imp2 
                    0,//dePorc_Imp3
                    0,//deMonto_Imp
                    0,//deMonto_Imp2
                    0,//deMonto_Imp3
                    0,//dePorc_Gas
                    0,//deTotal_Dev
                    0,//deMonto_Dev
                    0,//@dePendiente2
                    "comentario", //comentario
                    0,//@bLote_Asignado
                    0,//@deMonto_Desc_Glob
                    0,//@deMonto_reca_Glob
                    0,//@deOtros1_glob
                    0,//@deOtros2_glob
                    0,//@deOtros3_glob
                    0,//@deMonto_imp_afec_glob
                    0,//@deMonto_imp2_afec_glob
                    0,//@deMonto_imp3_afec_glob
                    0,//@deMonto_Desc
                    0,//@dePendiente
                    0,//@iReng_Doc
                    null,//@sDis_Cen
                    "VAL",///sCo_Sucu_In,
                    "999", //sCo_Us_In,
                    "0", //sRevisado,
                    "0", //sTrasnfe,
                    Utilitario.nombreHost(), //sMaquina,
                    0,//@deCosto_Adi1
                    0, //@deCosto_Adi2,
                    0 ///@deCosto_Adi3
            );

        }

        if (resultado != 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Se ha Guardado Satisfactoriamente", "Software", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    public void cargarDatosTablaCatalogo(String codiFactura, String opcion) {
        ArrayList<FacturaRenglonBO> lista ;
        lista = leerArchivoFtp.ListaleerArchivoFacturaRenglon(codiFactura, opcion);
        modeloTablaRecepcionMercancia.setlistaRecepcionMercancia(lista);
        jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);

        TableColumnModel columnModel = jtablePrincipalMercancia.getColumnModel();
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

//        for (int i = 0; i < lista.size(); i++) {
//
//            montoGravable += lista.get(i).getTotalNetoReng();
//            System.out.println(": i :" + lista.get(i).getTotalNetoReng());
//            System.out.println(": MM :" + montoGravable);
////             precio1+= lista.get(i).getPrecio1();
////             precio$+= lista.get(i).getPrecio2();
//        }
        /*     listaFactura = leerArchivoFtp.ListaleerArchivoFActuraEncabezado();
        System.out.println("FECHA" + listaFactura.get(0).getFechaFactura());
        listaFactura.get(0).getFechaFactura();

        fechaFactura.setDate(new Date());
        txtSubTotal.setValue(listaFactura.get(0).getBaseExentoIva());
        txtMontGravable.setValue(listaFactura.get(0).getBaseImponible());
        txtMontoDescuento.setValue(listaFactura.get(0).getDescuentoProntoPago());
        txtmontoImpuesto.setValue(listaFactura.get(0).getTotalIVA());
        txtTotal.setValue(montoGravable);
        montoGravable$ = montoGravable * 33 / 100;
        montoExcento$ = listaFactura.get(0).getBaseExentoIva() * 33 / 100;
        montoImpuesto$ = listaFactura.get(0).getTotalIVA() * 33 / 100;

        txtTotal$.setValue(montoGravable$);
        txtSubTotal$.setValue(montoExcento$);
        txtmontoImpuesto$.setValue(montoImpuesto$);
        txtMontoGravable$.setValue(0);
        txtMontoDescuento$.setValue(0);
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
         */
        montoGravable = 0;
        // setCantidadListRengl(lista.size());
    }

    public void cargarDatosArchivos() {
        ModeloTablaDialogo modeloTablaDialogo = new ModeloTablaDialogo();
        leerArchivoFtp = new LeerArchivoFtp();

        // Leer los Archivo que se encuentra en la Carpeta  C:\\DescargasArchivoFTP\\Factura\\
        ArrayList<ListaArchivosBO> lista = leerArchivoFtp.listarNameArchivos();
        modeloTablaDialogo.setlistaRecepcionMercancia(lista);
        jTableListaArchivos.setModel(modeloTablaDialogo);
        JTableHeader jTableHeader = jTableListaArchivos.getTableHeader();
        jTableListaArchivos.getTableHeader().setReorderingAllowed(false);
        TableColumnModel columnModel = jTableListaArchivos.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(250);//Item
        columnModel.getColumn(1).setPreferredWidth(200);//Numero Factura 
        columnModel.getColumn(2).setPreferredWidth(100);//Numero Factura 
        modeloTablaDialogo.refrescarTable();
    }

    public void settearCampos() {
//        jFormattedTextField1.setText("00");
//        jFormattedTextField1.setText("00");

        txtSubTotal.setText("00");
        txtSubTotal$.setText("00");
        txtMontGravable.setText("00");
        txtMontoGravable$.setText("00");
//        jFormattedTextField1.setText("00");
        //  jFormattedTextField1.setText("00");
        txtNroControl.setText("");
        txtNroFactura.setText("");
        txtTotal.setValue(00);
        txtTotal$.setValue(00);
        jtablePrincipalMercancia.removeAll();
//       jtablePrincipalMercancia.
    }

    //Metodo , Descargar el Archivo factura Seleccionado . 
    public void conectarDescargarArchivo(String archivo) {
        String server = "ftp.drolanca.com";
        int port = 21;
        String user = "18919";
        String pass = "18919";
        String remoteFilePath = "/RFacturas/" + archivo;
        String localFilePath = "C:\\DescargasArchivoFTP\\Factura\\" + archivo;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barraDescarga;
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnAceptar1;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCargarArchivoFTP;
    public com.toedter.calendar.JDateChooser fechaFactura;
    public com.toedter.calendar.JDateChooser fechaVen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    public javax.swing.JComboBox<String> jComboBoxAlmacen;
    public javax.swing.JComboBox<String> jComboBoxUnidad;
    public javax.swing.JComboBox<String> jComboClientes;
    public javax.swing.JComboBox<String> jComboCondicionPago;
    private javax.swing.JDialog jDialogCatalogo;
    public javax.swing.JDialog jDialogCliente;
    private javax.swing.JDialog jDialogSeleccionarArchivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTablaCatalogo;
    public javax.swing.JTable jTableListaArchivos;
    public javax.swing.JTable jtablePrincipalMercancia;
    public javax.swing.JTextField txtBusquda;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JFormattedTextField txtMontGravable;
    public javax.swing.JFormattedTextField txtMontoDescuento;
    public javax.swing.JFormattedTextField txtMontoDescuento$;
    public javax.swing.JFormattedTextField txtMontoGravable$;
    public javax.swing.JTextField txtNroControl;
    public javax.swing.JTextField txtNroFactura;
    public javax.swing.JFormattedTextField txtSubTotal;
    public javax.swing.JFormattedTextField txtSubTotal$;
    public javax.swing.JFormattedTextField txtTasa;
    public javax.swing.JFormattedTextField txtTotal;
    public javax.swing.JFormattedTextField txtTotal$;
    public javax.swing.JFormattedTextField txtmontoImpuesto;
    public javax.swing.JFormattedTextField txtmontoImpuesto$;
    // End of variables declaration//GEN-END:variables
}
