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
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswing.conection.Conexion;
/**
 *
 * @author eArana
 */
public class PedidosVentasModelo {
  
    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public int resultado = 0;

    public PedidosVentasModelo() {
        con = conexion.conexionControlCenter("demoa", "profit", "profit");
    }

    public int pInsertarPedidoVenta(
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
            int bAnulado,
            String sStatus,
            double deTasa,
            String sN_Control,
            String sNro_Doc,
            String sPorc_Desc_Glob,
            double deMonto_Desc_Glob,
            String sPorc_Reca,
            double deMonto_Reca,
            double deSaldo,
            double deTotal_Bruto,
            double deMonto_Imp,
            double deMonto_Imp2,
            double deMonto_Imp3,
            double deOtros1,
            double deOtros2,
            double deOtros3,
            double deTotal_Neto,
            String sDis_Cen,
            String sComentario,
            String sDir_Ent,
            int bContrib,
            int bImpresa,
            // int @iSeriales_S       INT, 
            String sSalestax,
            String sImpfis,
            String sImpfisfac,
            int bVen_Ter,
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
            cstmt = con.prepareCall("{CALL pInsertarPedidoVenta("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + " )}");

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
            cstmt.setInt(12, bAnulado);
            cstmt.setString(13, sStatus);
            cstmt.setDouble(14, deTasa);
            cstmt.setString(15, sN_Control);
            cstmt.setString(16, sNro_Doc);
            cstmt.setString(17, sPorc_Desc_Glob);
            cstmt.setDouble(18, deMonto_Desc_Glob);
            cstmt.setString(19, sPorc_Reca);
            cstmt.setDouble(20, deMonto_Reca);
            cstmt.setDouble(21, deSaldo);
            cstmt.setDouble(22, deTotal_Bruto);
            cstmt.setDouble(23, deMonto_Imp);
            cstmt.setDouble(24, deMonto_Imp2);
            cstmt.setDouble(25, deMonto_Imp3);
            cstmt.setDouble(26, deOtros1);
            cstmt.setDouble(27, deOtros2);
            cstmt.setDouble(28, deOtros3);
            cstmt.setDouble(29, deTotal_Neto);
            cstmt.setString(30, sDis_Cen);
            cstmt.setString(31, sComentario);
            cstmt.setString(32, sDir_Ent);
            cstmt.setInt(33, bContrib);
            cstmt.setInt(34, bImpresa);
            cstmt.setString(35, sSalestax);
            cstmt.setString(36, sImpfis);
            cstmt.setString(37, sImpfisfac);
            cstmt.setInt(38, bVen_Ter);
            cstmt.setString(39, sCampo1);
            cstmt.setString(40, sCampo2);
            cstmt.setString(41, sCampo3);
            cstmt.setString(42, sCampo4);
            cstmt.setString(43, sCampo5);
            cstmt.setString(44, sCampo6);
            cstmt.setString(45, sCampo7);
            cstmt.setString(46, sCampo8);
            cstmt.setString(47, sCo_Us_In);
            cstmt.setString(48, sCo_Sucu_In);
            cstmt.setString(49, sRevisado);
            cstmt.setString(50, sTrasnfe);
            cstmt.setString(51, sMaquina);

        } catch (SQLException ex) {
            Logger.getLogger(PedidosVentasModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}