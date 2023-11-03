/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaswing.conection.Conexion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eArana
 */
public class RecepcionMercanciaModelo {
    
    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public int resultado = 0;

    public RecepcionMercanciaModelo() {
        con = conexion.conexions();

    }
    
    
    
    public int pInsertarFacturaVenta(
            String sDoc_Num,
            String sDescrip,
            String sCo_Cli,
            String sCo_Tran,
            String sCo_Mone,
            String sCo_Cta_Ingr_Egr,
            String sCo_Ven,
            String sCo_Cond,
            String sdFec_Emis,
            String sdFec_Venc,
            String sdFec_Reg,
            String bAnulado,
            String sStatus,
            String deTasa,
            String sN_Control,
            String sPorc_Desc_Glob,
            String deMonto_Desc_Glob,
            String sPorc_Reca,
            String deMonto_Reca,
            String deSaldo,
            String deTotal_Bruto,
            String deMonto_Imp,
            String deMonto_Imp2,
            String deMonto_Imp3,
            String deOtros1,
            String deOtros2,
            String deOtros3,
            String deTotal_Neto,
            String sDis_Cen,
            String sComentario,
            String sDir_Ent,
            String bContrib,
            String bImpresa,
            String sSalestax,
            String sImpfis,
            String sImpfisfac,
            String bVen_Ter,
            String sCampo1,
            String sCampo2,
            String sCampo3,
            String sCampo4,
            String sCampo5,
            String sCampo6,
            String sCampo7,
            String sCampo8,
            String sCo_Us_In,
            String sCo_Sucu_In,
            String sRevisado,
            String sTrasnfe,
            String sMaquina
    ) {
        try {
            cstmt = con.prepareCall("{CALL pInsertarFacturaVenta("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,?,?"
                    + ") }");

            cstmt.setString(1, sDoc_Num);
            cstmt.setString(2, sDescrip);
            cstmt.setString(3, sCo_Cli);
            cstmt.setString(4, sCo_Tran);
            cstmt.setString(5, sCo_Mone);
            cstmt.setString(6, sCo_Cta_Ingr_Egr);
            cstmt.setString(7, sCo_Ven);
            cstmt.setString(8, sCo_Cond);
            cstmt.setString(9, sdFec_Emis);
            cstmt.setString(10, sdFec_Venc);
            cstmt.setString(11, sdFec_Reg);
            cstmt.setString(12, bAnulado);
            cstmt.setString(13, sStatus);
            cstmt.setString(14, deTasa);
            cstmt.setString(15, sN_Control);
            cstmt.setString(16, sPorc_Desc_Glob);
            cstmt.setString(17, deMonto_Desc_Glob);
            cstmt.setString(18, sPorc_Reca);
            cstmt.setString(19, deMonto_Reca);
            cstmt.setString(20, deSaldo);
            cstmt.setString(21, deTotal_Bruto);
            cstmt.setString(22, deMonto_Imp);
            cstmt.setString(23, deMonto_Imp2);
            cstmt.setString(24, deMonto_Imp3);
            cstmt.setString(25, deOtros1);
            cstmt.setString(26, deOtros2);
            cstmt.setString(27, deOtros3);
            cstmt.setString(28, deTotal_Neto);
            cstmt.setString(29, sDis_Cen);
            cstmt.setString(30, sComentario);
            cstmt.setString(31, sDir_Ent);
            cstmt.setString(32, bContrib);
            cstmt.setString(33, bImpresa);
            cstmt.setString(34, sSalestax);
            cstmt.setString(35, sImpfis);
            cstmt.setString(36, sImpfisfac);
            cstmt.setString(37, bVen_Ter);
            cstmt.setString(38, sCampo1);
            cstmt.setString(39, sCampo2);
            cstmt.setString(40, sCampo3);
            cstmt.setString(41, sCampo4);
            cstmt.setString(42, sCampo5);
            cstmt.setString(43, sCampo6);
            cstmt.setString(44, sCampo7);
            cstmt.setString(45, sCampo8);
            cstmt.setString(46, sCo_Us_In);
            cstmt.setString(47, sCo_Sucu_In);
            cstmt.setString(48, sRevisado);
            cstmt.setString(49, sTrasnfe);
            cstmt.setString(50, sMaquina);
            resultado = cstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), e, "Software", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }
    
    
    
}
