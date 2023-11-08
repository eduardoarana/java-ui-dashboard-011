package javaswingdev.form;

import LeerArchivoFTP.LeerArchivoFtp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswing.controller.FTPController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;
import org.apache.commons.net.ftp.FTPClient;

public class VistaFTP extends javax.swing.JPanel {

    FTPController controller;
  public List<JTextField> textos ;
  int indice =0 ;
    public VistaFTP(String name) {
        initComponents();
        textos = new ArrayList<>();
        controller = new FTPController(this);
        controller.cargarDatosFTP();
        btnGuardar.addActionListener(controller);
        btnConectar.addActionListener(controller);
        btnEliminar.addActionListener(controller);
        btnNuevo.addActionListener(controller);
        jtablaFTP.addMouseListener(controller);
      
        // lb.setText ("Form " + name);

        TableColumnModel columnModel = jtablaFTP.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);//Item
        columnModel.getColumn(1).setPreferredWidth(103);//Servidor
        columnModel.getColumn(2).setPreferredWidth(103);//Usuario
        columnModel.getColumn(3).setPreferredWidth(60);//puerto
        columnModel.getColumn(4).setPreferredWidth(208);//directorio Factura
        columnModel.getColumn(5).setPreferredWidth(208);//directorio Factura
        columnModel.getColumn(6).setPreferredWidth(208);//directorio Factura
        columnModel.getColumn(7).setPreferredWidth(100);//directorio Factura
    }

    public void settearCampo(){
        txtPasswor.setText("");
        txtPuerto.setText("");
        txtServidor.setText("");
        txtUsuario.setText("");
        txtDirectorioCatalogo.setText("");
        txtDirectorioFactura.setText("");
        txtDirectorioPedidos.setText("");
        txtArchivoCatalogo.setText("");
        txtArchivoFactura.setText("");
        txtArchivoPedidos.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPasswor = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaFTP = new javaswingdev.swing.table.Table();
        jLabel5 = new javax.swing.JLabel();
        txtDirectorioFactura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDirectorioCatalogo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDirectorioPedidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtArchivoFactura = new javax.swing.JTextField();
        txtArchivoCatalogo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtArchivoPedidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreArchivoFactura = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtSeparadores = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCabecera = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        paneldeCampos = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVIDOR");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 73, 20));

        txtServidor.setToolTipText("SERVIDOR");
        jPanel2.add(txtServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, -1));

        txtPuerto.setToolTipText("PUERTO");
        jPanel2.add(txtPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 80, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PUERTO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 73, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USUARIO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 73, 20));

        txtUsuario.setToolTipText("USUARIO");
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 230, -1));

        txtPasswor.setToolTipText("PASSWORD");
        jPanel2.add(txtPasswor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PASSWORD");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 73, 20));

        btnConectar.setText("Conectar");
        btnConectar.setToolTipText("");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 119, 29));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jtablaFTP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtablaFTP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtablaFTP);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1070, 370));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Directorio Pedidos:");
        jLabel5.setToolTipText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 110, 20));

        txtDirectorioFactura.setToolTipText("Ruta Directorio Factura");
        jPanel2.add(txtDirectorioFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 280, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Archivo Factura:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 110, 20));

        txtDirectorioCatalogo.setToolTipText("Directorio Catalogo");
        jPanel2.add(txtDirectorioCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 280, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Directorio Catalogo:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 110, 20));

        txtDirectorioPedidos.setToolTipText("Directorio Pedidos");
        jPanel2.add(txtDirectorioPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 280, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Directorio Factura:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 110, 20));
        jPanel2.add(txtArchivoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 180, -1));
        jPanel2.add(txtArchivoCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 180, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Archivo Catalogo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 110, 20));
        jPanel2.add(txtArchivoPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 180, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Archivo Pedidos:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 110, 20));

        jTabbedPane1.addTab("General ", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Nombre Archivo :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 100, 20));

        txtNombreArchivoFactura.setToolTipText("Nombre de  Archivo");
        jPanel1.add(txtNombreArchivoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 240, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cantidad de Columnas :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 110, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Separadores :");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 140, 150, -1));

        txtSeparadores.setToolTipText("Separadores");
        jPanel1.add(txtSeparadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 110, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cabezera :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, -1));

        txtCabecera.setToolTipText("Cabecera");
        jPanel1.add(txtCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 110, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Detalle :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 220, 120, -1));

        txtDetalles.setToolTipText("Detalles");
        jPanel1.add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 110, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("FACTURA");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1080, 30));

        paneldeCampos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres de Campos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 14))); // NOI18N

        javax.swing.GroupLayout paneldeCamposLayout = new javax.swing.GroupLayout(paneldeCampos);
        paneldeCampos.setLayout(paneldeCamposLayout);
        paneldeCamposLayout.setHorizontalGroup(
            paneldeCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        paneldeCamposLayout.setVerticalGroup(
            paneldeCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        jPanel1.add(paneldeCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1050, 230));

        btnAgregar.setText("Agregar Campos");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, -1));

        jTabbedPane1.addTab("Configuracion Archivo Factura", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1090, 570));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/update.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualizar");
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/nuevo.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
//        settearCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        // TODO add your handling code here:

        int resultado = 0;
        FTPClient ftpClient = new FTPClient();
        try {
            // Set the connection parameters
            ftpClient.connect(txtServidor.getText(), Integer.parseInt(txtPuerto.getText()));
            System.out.println("PASSSSSWORD" + txtPasswor.getPassword().toString());
            ftpClient.login(txtUsuario.getText(), txtPasswor.getPassword().toString());

            // Check if the connection was successful
            if (ftpClient.isConnected()) {
                JOptionPane.showMessageDialog(new JFrame(), "Conexion Exitosa", "Software", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Conexion Fallida", "Software", JOptionPane.ERROR_MESSAGE);
            }
            // Close the connection
            ftpClient.disconnect();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Conexion Fallida", "Software", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException n ){
            JOptionPane.showMessageDialog(new JFrame(), "Conexion Fallida Puerto ", "Software", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        JTextField campoDinamico = new JTextField();
        System.out.println("Agregando Componentes ...");
        paneldeCampos.add(campoDinamico);
        textos.add(campoDinamico);
        indice ++ ;
        paneldeCampos.updateUI();
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnConectar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javaswingdev.swing.table.Table jtablaFTP;
    private javax.swing.JPanel paneldeCampos;
    private javaswingdev.swing.RoundPanel roundPanel1;
    public javax.swing.JTextField txtArchivoCatalogo;
    public javax.swing.JTextField txtArchivoFactura;
    public javax.swing.JTextField txtArchivoPedidos;
    public javax.swing.JTextField txtCabecera;
    public javax.swing.JTextField txtDetalles;
    public javax.swing.JTextField txtDirectorioCatalogo;
    public javax.swing.JTextField txtDirectorioFactura;
    public javax.swing.JTextField txtDirectorioPedidos;
    public javax.swing.JTextField txtNombreArchivoFactura;
    public javax.swing.JPasswordField txtPasswor;
    public javax.swing.JTextField txtPuerto;
    public javax.swing.JTextField txtSeparadores;
    public javax.swing.JTextField txtServidor;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
