/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingdev.form;

/**
 *
 * @author eArana
 */
public class VistaDePedidos extends javax.swing.JPanel {

    /**
     * Creates new form VistaDePedidos
     */
    public VistaDePedidos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablePrincipalMercancia = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/importar.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/positivoMas.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Eliminar.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Guardar.png"))); // NOI18N
        jButton7.setToolTipText("Guardar");
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/nuevo.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton2.setText("Catalogo");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 80, 40));

        jButton3.setText("Linea");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 80, 40));

        jButton4.setText("Sub Linea");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 80, 40));

        jButton9.setText("Categoria");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 80, 40));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/update.png"))); // NOI18N
        jButton6.setToolTipText("Actualizar");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 60));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Barra");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Drogueria");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 80, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Codigo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 80, 20));

        jTextField1.setToolTipText("");
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 80, -1));

        jTextField2.setToolTipText("");
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));

        jTextField3.setToolTipText("");
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 80, -1));

        jTextField4.setToolTipText("");
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 60));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jtablePrincipalMercancia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item", "Producto", "Cantidad", "PVP", "DN", "Precio", "Tipo", "Regn", "IVA", "DI", "DP", "DC", "PP", "Neto", "Sub Total", "Drogueria"
            }
        ));
        jtablePrincipalMercancia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jtablePrincipalMercancia);
        if (jtablePrincipalMercancia.getColumnModel().getColumnCount() > 0) {
            jtablePrincipalMercancia.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1200, 260));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Base Imponible:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 100, 20));

        jLabel6.setText("IGTF :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 80, 20));

        jLabel7.setText("Sub-Total :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 100, 20));

        jLabel8.setText("IVA :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 80, 20));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1190, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //        cargarDatosTablaCatalogo("", "todos");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        //        FacturaRenglonBO facturaBO = new FacturaRenglonBO();
        //        facturaBO.setItem(1);
        //        facturaBO.setIVA(0);
        //
        //        modeloTablaRecepcionMercancia.addRow(facturaBO);
        //        modeloTablaRecepcionMercancia.refrescarTable();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //        modeloTablaRecepcionMercancia.removedRow(jtablePrincipalMercancia.getSelectedRow());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //        settearCampos();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTable jtablePrincipalMercancia;
    // End of variables declaration//GEN-END:variables
}
