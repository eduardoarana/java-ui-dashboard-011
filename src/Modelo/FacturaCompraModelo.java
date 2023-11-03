/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswigdev.Beans.TasaBO;
import javaswing.conection.Conexion;
import javaswing.utilitario.Utilitario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eArana
 */
public class FacturaCompraModelo {

    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public int resultado = 0;
    public PreparedStatement ps;

    public FacturaCompraModelo() {
        con = conexion.conexionControlCenter("demoa", "profit", "profit");
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
            String sImp_nro_z,
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
            cstmt.setString(37, sImp_nro_z);
            cstmt.setString(38, bVen_Ter);
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
            resultado = cstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), e, "Software", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }

    public int pInsertarRenglonesFacturaVenta(
            int iReng_Num,
            String sDoc_Num,
            String sCo_Art,
            String sDes_Art,
            String sCo_Uni,
            String sSco_Uni,
            String sCo_Alma,
            String sCo_Precio,
            String sTipo_Imp,
            String sTipo_Imp2,
            String sTipo_Imp3,
            double deTotal_Art,
            double deSTotal_Art,
            double dePrec_Vta,
            double sPorc_Desc,
            double deMonto_Desc,
            double deReng_Neto,
            double dePendiente,
            double dePendiente2,
            double deMonto_Desc_Glob,
            double deMonto_reca_Glob,
            double deOtros1_glob,
            double deOtros2_glob,
            double deOtros3_glob,
            double deMonto_imp_afec_glob,
            double deMonto_imp2_afec_glob,
            String deMonto_imp3_afec_glob,
            String sTipo_Doc,
            String gRowguid_Doc,
            String sNum_Doc,
            String dePorc_Imp,
            String dePorc_Imp2,
            String dePorc_Imp3,
            String deMonto_Imp,
            String deMonto_Imp2,
            String deMonto_Imp3,
            String deOtros,
            String deTotal_Dev,
            String deMonto_Dev,
            String sComentario,
            String sDis_Cen,
            String sCo_Sucu_In,
            String sCo_Us_In,
            String sREVISADO,
            String sTRASNFE,
            String sMaquina
    //String lote_asignado
    ) {
        try {

            cstmt = con.prepareCall("{CAll pInsertarRenglonesFacturaVenta("
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
                    // + "?,"
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
                    + "?"
                    + ")}");
            cstmt.setInt(1, iReng_Num);
            cstmt.setString(2, sDoc_Num);
            cstmt.setString(3, sCo_Art);
            cstmt.setString(4, sDes_Art);
            cstmt.setString(5, sCo_Uni);
            cstmt.setString(6, sSco_Uni);
            cstmt.setString(7, sCo_Alma);
            cstmt.setString(8, sCo_Precio);
            cstmt.setString(9, sTipo_Imp);
            cstmt.setString(10, sTipo_Imp2);
            cstmt.setString(11, sTipo_Imp3);
            cstmt.setDouble(12, deTotal_Art);
            cstmt.setDouble(13, deSTotal_Art);
            cstmt.setDouble(14, dePrec_Vta);
            cstmt.setDouble(15, sPorc_Desc);
            cstmt.setDouble(16, deMonto_Desc);
            cstmt.setDouble(17, deReng_Neto);
            cstmt.setDouble(18, dePendiente);
            cstmt.setDouble(19, dePendiente2);
            cstmt.setDouble(20, deMonto_Desc_Glob);
            cstmt.setDouble(21, deMonto_reca_Glob);
            cstmt.setDouble(22, deOtros1_glob);
            cstmt.setDouble(23, deOtros2_glob);
            cstmt.setDouble(24, deOtros3_glob);
            cstmt.setDouble(25, deMonto_imp_afec_glob);
            cstmt.setDouble(26, deMonto_imp2_afec_glob);
            cstmt.setString(27, deMonto_imp3_afec_glob);
            cstmt.setString(28, sTipo_Doc);
            cstmt.setString(29, gRowguid_Doc);
            cstmt.setString(30, sNum_Doc);
            cstmt.setString(31, dePorc_Imp);
            cstmt.setString(32, dePorc_Imp2);
            cstmt.setString(33, dePorc_Imp3);
            cstmt.setString(34, deMonto_Imp);
            cstmt.setString(35, deMonto_Imp2);
            cstmt.setString(36, deMonto_Imp3);
            cstmt.setString(37, deOtros);
            cstmt.setString(38, deTotal_Dev);
            cstmt.setString(39, deMonto_Dev);
            cstmt.setString(40, sComentario);
            cstmt.setString(41, sDis_Cen);
            cstmt.setString(42, sCo_Sucu_In);
            cstmt.setString(43, sCo_Us_In);
            cstmt.setString(44, sREVISADO);
            cstmt.setString(45, sTRASNFE);
            cstmt.setString(46, sMaquina);
            // cstmt.setStrin(46, lote_asignado);

            resultado = cstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int pInsertarDocumentoVenta(
            String sCo_Tipo_Doc,
            String sNro_Doc,
            String sCo_cli,
            String sCo_ven,
            String sCo_Mone,
            String sMov_Ban,
            String sCo_Cta_Ingr_Egr,
            double deTasa,
            String sObserva,
            String dFec_Reg,
            String dFec_Emis,
            String dFec_Venc,
            int bAnulado,
            int bAut,
            int bContribu,
            String sDoc_Orig,
            String sNro_Orig,
            String sNro_Che,
            double deMonto_Imp,
            double deSaldo,
            double deTotal_Bruto,
            double deMonto_Desc_Glob,
            String sPorc_Desc_Glob,
            String sPorc_Reca,
            double deMonto_Reca,
            double deTotal_Neto,
            double deMonto_imp2,
            double deMonto_imp3,
            String sTipo_Imp,
            String iTipo_Origen,
            double dePorc_Imp,
            double dePorc_Imp2,
            double dePorc_Imp3,
            String sNum_Comprobante,
            String sN_Control,
            String sDis_Cen,
            double deComis1,
            double deComis2,
            double deComis3,
            double deComis4,
            double deComis5,
            double deComis6,
            double deAdicional,
            String sSalestax,
            int bVen_Ter,
            String sImpfis,
            String sImpfisfac,
            String sImp_nro_z,
            double deOtros1,
            double deOtros2,
            double deOtros3,
            String sCampo1,
            String sCampo2,
            String sCampo3,
            String sCampo4,
            String sCampo5,
            String sCampo6,
            String sCampo7,
            String sCampo8,
            String sRevisado,
            String sTrasnfe,
            String sCo_Sucu_In,
            String sCo_Us_In,
            String sMaquina // 64
    ) {

        try {
            //pInsertarDocumentoVenta

            cstmt = con.prepareCall("{CALL pInsertarDocumentoVenta("
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
                    + "?"
                    + ") }"); //64

            cstmt.setString(1, sCo_Tipo_Doc);
            cstmt.setString(2, sNro_Doc);
            cstmt.setString(3, sCo_cli);
            cstmt.setString(4, sCo_ven);
            cstmt.setString(5, sCo_Mone);
            cstmt.setString(6, sMov_Ban);
            cstmt.setString(7, sCo_Cta_Ingr_Egr);
            cstmt.setDouble(8, deTasa);
            cstmt.setString(9, sObserva);
            cstmt.setString(10, dFec_Reg);
            cstmt.setString(11, dFec_Emis);
            cstmt.setString(12, dFec_Venc);
            cstmt.setInt(13, bAnulado);
            cstmt.setInt(14, bAut);
            cstmt.setInt(15, bContribu);
            cstmt.setString(16, sDoc_Orig);
            cstmt.setString(17, sNro_Orig);
            cstmt.setString(18, sNro_Che);
            cstmt.setDouble(19, deMonto_Imp);
            cstmt.setDouble(20, deSaldo);
            cstmt.setDouble(21, deTotal_Bruto);
            cstmt.setDouble(22, deMonto_Desc_Glob);
            cstmt.setString(23, sPorc_Desc_Glob);
            cstmt.setString(24, sPorc_Reca);
            cstmt.setDouble(25, deMonto_Reca);
            cstmt.setDouble(26, deTotal_Neto);
            cstmt.setDouble(27, deMonto_imp2);
            cstmt.setDouble(28, deMonto_imp3);
            cstmt.setString(29, sTipo_Imp);
            cstmt.setString(30, iTipo_Origen);
            cstmt.setDouble(31, dePorc_Imp);
            cstmt.setDouble(32, dePorc_Imp2);
            cstmt.setDouble(33, dePorc_Imp3);
            cstmt.setString(34, sNum_Comprobante);
            cstmt.setString(35, sN_Control);
            cstmt.setString(36, sDis_Cen);
            cstmt.setDouble(37, deComis1);
            cstmt.setDouble(38, deComis2);
            cstmt.setDouble(39, deComis3);
            cstmt.setDouble(40, deComis4);
            cstmt.setDouble(41, deComis5);
            cstmt.setDouble(42, deComis6);
            cstmt.setDouble(43, deAdicional);
            cstmt.setString(44, sSalestax);
            cstmt.setInt(45, bVen_Ter);
            cstmt.setString(46, sImpfis);
            cstmt.setString(47, sImpfisfac);
            cstmt.setString(48, sImp_nro_z);
            cstmt.setDouble(49, deOtros1);
            cstmt.setDouble(50, deOtros2);
            cstmt.setDouble(51, deOtros3);
            cstmt.setString(52, sCampo1);
            cstmt.setString(53, sCampo2);
            cstmt.setString(54, sCampo3);
            cstmt.setString(55, sCampo4);
            cstmt.setString(56, sCampo5);
            cstmt.setString(57, sCampo6);
            cstmt.setString(58, sCampo7);
            cstmt.setString(59, sCampo8);
            cstmt.setString(60, sRevisado);
            cstmt.setString(61, sTrasnfe);
            cstmt.setString(62, sCo_Sucu_In);
            cstmt.setString(63, sCo_Us_In);
            cstmt.setString(64, sMaquina);

            resultado = cstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoVentaModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int pStockActualizar(
            String sCo_Alma,
            String sCo_Art,
            String sCo_Uni,
            String deCantidad,
            String sTipoStock,
            String bSumarStock,
            String bPermiteStockNegativo
    ) {
        try {

            cstmt = con.prepareCall("{CAll pStockActualizar("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + ")}");

            cstmt.setString(1, sCo_Alma);
            cstmt.setString(2, sCo_Art);
            cstmt.setString(3, sCo_Uni);
            cstmt.setString(4, deCantidad);
            cstmt.setString(5, sTipoStock);
            cstmt.setString(6, bSumarStock);
            cstmt.setString(7, bPermiteStockNegativo);
            resultado = cstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public int pInsertarCotizacionProveedor(
            String sDoc_Num,
            String sNro_Fact,
            String sDescrip,
            String sCo_Prov,
            String sCo_Cta_Ingr_Egr,
            String sCo_Mone,
            String sCo_Cond,
            String sN_Control,
            String sPorc_Desc_Glob,
            String sdFec_Emis,
            String sdFec_Venc,
            String sdFec_Reg,
            int bAnulado,
            String sStatus,
            double deTasa,
            String sPorc_Reca,
            double deSaldo,
            double deTotal_Bruto,
            double deTotal_Neto,
            double deMonto_Desc_Glob,
            double deMonto_Reca,
            double deOtros1,
            double deOtros2,
            double deOtros3,
            double deMonto_Imp,
            double deMonto_Imp2,
            double deMonto_Imp3,
            String sDir_Ent,
            String sComentario,
            int bImpresa,
            // int iSeriales_e ,
            String sSalestax,
            String sDis_cen,
            String sCampo1,
            String sCampo2,
            String sCampo3,
            String sCampo4,
            String sCampo5,
            String sCampo6,
            String sCampo7,
            String sCampo8,
            String sRevisado,
            String sTrasnfe,
            String sCo_Us_In,
            String sCo_Sucu_In,
            String sMaquina,
            int bNac
    ) {
        try {
            cstmt = con.prepareCall("{CAll pInsertarCotizacionProveedor("
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
                    + "?"
                    + ")}");
            long consecutivo = Long.parseLong(Utilitario.pObtenerProximoNumero(con,"saCotizacionProveedor", "" ,"") ) +1;
            cstmt.setString(1,String.valueOf(consecutivo));
            cstmt.setString(2, sNro_Fact);
            cstmt.setString(3, sDescrip);
            cstmt.setString(4, Utilitario.getTablaId(con, "saProveedor", "prov_des", "co_prov", sCo_Prov));
            cstmt.setString(5, sCo_Cta_Ingr_Egr);
            cstmt.setString(6, sCo_Mone);
            cstmt.setString(7, Utilitario.getTablaId(con, "saCondicionPago", "cond_des", "co_cond", sCo_Cond));
            cstmt.setString(8, sN_Control);
            cstmt.setString(9, sPorc_Desc_Glob);
            cstmt.setString(10, sdFec_Emis);
            cstmt.setString(11, sdFec_Venc);
            cstmt.setString(12, sdFec_Reg);
            cstmt.setInt(13, bAnulado);
            cstmt.setString(14, sStatus);
            cstmt.setDouble(15, deTasa);
            cstmt.setString(16, sPorc_Reca);
            cstmt.setDouble(17, deSaldo); //deSaldo
            cstmt.setDouble(18, deTotal_Bruto);
            cstmt.setDouble(19, deTotal_Neto);
            cstmt.setDouble(20, deMonto_Desc_Glob);
            cstmt.setDouble(21, deMonto_Reca);
            cstmt.setDouble(22, deOtros1);
            cstmt.setDouble(23, deOtros2);
            cstmt.setDouble(24, deOtros3);
            cstmt.setDouble(25, deMonto_Imp);
            cstmt.setDouble(26, deMonto_Imp2);
            cstmt.setDouble(27, deMonto_Imp3);
            cstmt.setString(28, sDir_Ent);
            cstmt.setString(29, sComentario);
            cstmt.setInt(30, bImpresa);
            ///iSeriales_e
            cstmt.setString(31, sSalestax);
            cstmt.setString(32, sDis_cen);
            cstmt.setString(33, sCampo1);
            cstmt.setString(34, sCampo2);
            cstmt.setString(35, sCampo3);
            cstmt.setString(36, sCampo4);
            cstmt.setString(37, sCampo5);
            cstmt.setString(38, sCampo6);
            cstmt.setString(39, sCampo7);
            cstmt.setString(40, sCampo8);
            cstmt.setString(41, sRevisado);
            cstmt.setString(42, sTrasnfe);
            cstmt.setString(43, sCo_Us_In);
            cstmt.setString(44, sCo_Sucu_In);
            cstmt.setString(45, sMaquina);
            cstmt.setInt(46, bNac);

            resultado = cstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public int pInsertarRenglonesCotizacionProveedor(
            int iReng_Num,
            String sDoc_num,
            String sCo_art,
            String sDes_Art,
            String sCo_Uni,
            String sSCo_Uni,
            String sCo_Almacen,
            String sTipo_imp,
            String sTipo_Imp2,
            String sTipo_Imp3,
            String sTipo_Doc,
            String sPorc_Desc,
            String sNum_Doc,
            String gRowGuid_Doc,
            double deReng_Neto,
            double deCost_Unit,
            double deCost_Unit_OM,
            double deTotal_Art,
            double deSTotal_Art,
            double deOtros,
            double dePorc_Imp,
            double dePorc_Imp2,
            double dePorc_Imp3,
            double deMonto_Imp,
            double deMonto_Imp2,
            double deMonto_Imp3,
            double dePorc_Gas,
            double deTotal_Dev,
            double deMonto_Dev,
            double dePendiente2,
            String sComentario,
            int bLote_Asignado,
            double deMonto_Desc_Glob,
            double deMonto_reca_Glob,
            double deOtros1_glob,
            double deOtros2_glob,
            double deOtros3_glob,
            double deMonto_imp_afec_glob,
            double deMonto_imp2_afec_glob,
            double deMonto_imp3_afec_glob,
            double deMonto_Desc,
            double dePendiente,
            int iReng_Doc,
            String sDis_Cen,
            String sCo_Sucu_In,
            String sCo_Us_In,
            String sRevisado,
            String sTrasnfe,
            String sMaquina,
            double deCosto_Adi1,
            double deCosto_Adi2,
            double deCosto_Adi3
    ) {
        System.out.println("ARTICULO::::" + Utilitario.getTablaId(con, "saArticulo", "art_des", "co_art", sCo_art));
        try {
            cstmt = con.prepareCall("{CAll pInsertarRenglonesCotizacionProveedor("
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
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + ")}");

            System.out.println("ESTE ES LA UNIDAD ::::::::::: " + Utilitario.getTablaId(con, "saArtUnidad", "co_art", "co_uni", Utilitario.getTablaId(con, "saArticulo", "art_des", "co_art", sCo_art)));
            cstmt.setInt(1, iReng_Num);
            cstmt.setString(2, sDoc_num);
            cstmt.setString(3, Utilitario.getTablaId(con, "saArticulo", "art_des", "co_art", sCo_art));
            cstmt.setString(4, sDes_Art);
            cstmt.setString(5, Utilitario.getTablaId(con, "saArtUnidad", "co_art", "co_uni", Utilitario.getTablaId(con, "saArticulo", "art_des", "co_art", sCo_art)));
            cstmt.setString(6, sSCo_Uni);
            cstmt.setString(7, Utilitario.getTablaId(con, "saAlmacen", "des_alma", "co_alma", sCo_Almacen));
            cstmt.setString(8, sTipo_imp);
            cstmt.setString(9, sTipo_Imp2);
            cstmt.setString(10, sTipo_Imp3);
            cstmt.setString(11, sTipo_Doc);
            cstmt.setString(12, sPorc_Desc);
            cstmt.setString(13, sNum_Doc);
            cstmt.setString(14, gRowGuid_Doc);
            cstmt.setDouble(15, deReng_Neto);
            cstmt.setDouble(16, deCost_Unit);
            cstmt.setDouble(17, deCost_Unit_OM);
            cstmt.setDouble(18, deTotal_Art);
            cstmt.setDouble(19, deSTotal_Art);
            cstmt.setDouble(20, deOtros);
            cstmt.setDouble(21, dePorc_Imp);
            cstmt.setDouble(22, dePorc_Imp2);
            cstmt.setDouble(23, dePorc_Imp3);
            cstmt.setDouble(24, deMonto_Imp);
            cstmt.setDouble(25, deMonto_Imp2);
            cstmt.setDouble(26, deMonto_Imp3);
            cstmt.setDouble(27, dePorc_Gas);
            cstmt.setDouble(28, deTotal_Dev);
            cstmt.setDouble(29, deMonto_Dev);
            cstmt.setDouble(30, dePendiente2);
            cstmt.setString(31, sComentario);
            cstmt.setInt(32, bLote_Asignado);
            cstmt.setDouble(33, deMonto_Desc_Glob);
            cstmt.setDouble(34, deMonto_reca_Glob);
            cstmt.setDouble(35, deOtros1_glob);
            cstmt.setDouble(36, deOtros2_glob);
            cstmt.setDouble(37, deOtros3_glob);
            cstmt.setDouble(38, deMonto_imp_afec_glob);
            cstmt.setDouble(39, deMonto_imp2_afec_glob);
            cstmt.setDouble(40, deMonto_imp3_afec_glob);
            cstmt.setDouble(41, deMonto_Desc);
            cstmt.setDouble(42, dePendiente);
            cstmt.setInt(43, iReng_Doc);
            cstmt.setString(44, sDis_Cen);
            cstmt.setString(45, sCo_Sucu_In);
            cstmt.setString(46, sCo_Us_In);
            cstmt.setString(47, sRevisado);
            cstmt.setString(48, sTrasnfe);
            cstmt.setString(49, sMaquina);
            cstmt.setDouble(50, deCosto_Adi1);
            cstmt.setDouble(51, deCosto_Adi2);
            cstmt.setDouble(52, deCosto_Adi3);

            resultado = cstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<TasaBO> pObtenerFechaTasa(
            String co_mone,
            String fecha
    ) {
        ArrayList<TasaBO> lista = new ArrayList<>();
        try {
            cstmt = con.prepareCall("{CALL pObtenerFechaTasa("
                    + "?,"
                    + "?"
                    + ")}");
            cstmt.setString(1, co_mone);
            cstmt.setString(2, fecha);
            cstmt.execute();
            rs = cstmt.getResultSet();
            while (rs.next()) {
                TasaBO tasaBO = new TasaBO();
//                tasaBO.setCo_mone(rs.getString("co_mone"));
                tasaBO.setFecha(rs.getString("fecha"));
                tasaBO.setTasa_c(rs.getDouble("tasa_c"));
                tasaBO.setTasa_v(rs.getDouble("tasa_v"));
                lista.add(tasaBO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int existeArticuloUnidad(String co_art, String co_uni) {
        resultado = 0;
        System.out.println("COD ARTICULO ::::::: "+ co_art + "UNIDAD " + co_uni );
        try {
//            select  * from saArtUnidad where co_art='6921875010854' and co_uni='UNI'
            ps = con.prepareStatement("select  * from saArtUnidad where co_art= ? and co_uni = ?");
            // Pasar el valor del parámetro
            ps.setString(1, co_art);
            ps.setString(2,Utilitario.getTablaId(con, "saUnidad", "des_uni", "co_uni",co_uni) );

            // Ejecutar la consulta SQL
            rs = ps.executeQuery();
            // Recorrer el objeto ResultSet para obtener los resultados
            while (rs.next()) {
                resultado = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String arg[]) {
        FacturaCompraModelo m = new FacturaCompraModelo();
        int resulta = 0;
        resulta = m.existeArticuloUnidad("7593255000336", "unid");

        System.out.println("Existe ?   :: " + Utilitario.getTablaId(con, "saUnidad", "des_uni", "co_uni", "UNIDAD"));
//        ArrayList<TasaBO> lista  m.pObtenerFechaTasa("BSD", Utilitario.fechaActual());

//        System.out.println("Unidad   :: " + Utilitario.getTablaId(con, "saArticulo", "art_des", "co_art", "ALCOHOL ABSOLUTO 96% X 500 CC (ALNA)")); //Utilitario.getTablaId(con, "saArtUnidad", "co_art", "co_uni", "7305314372") );
//        exec pInsertarRenglonesFacturaVenta
//                 @sdis_cen=NULL,
//                  @sDoc_Num=
//         '434344',
//                 @sCo_Art  =
//        '0101005',
//         @sDes_Art
//          = NULL,
//                  @sCo_Uni='UNI'
//         ,
//         @sSco_Uni  = NULL,
//                  @sCo_Alma='VAL'
//         ,@sCo_Precio  =
//        '01',@sTipo_Imp
//          = '1',   
//                @sTipo_Imp2=NULL,
//                @sTipo_Imp3=NULL,
//                @deTotal_Art=2,
//                  @deStotal_Art=0,
//                @dePrec_Vta=61.34,
//                @sPorc_Desc=NULL,
//                @deMonto_Desc=0,
//                @dePorc_Imp=16.00000,
//                @dePorc_Imp2=0,
//                @dePorc_Imp3=0,
//                @deReng_Neto=122.68,
//                @dePendiente=2,   @dePendiente2=0,   @sTipo_Doc=NULL,   @gRowguid_Doc=NULL,   @sNum_Doc=NULL,   @deMonto_Imp=19.63,
//                  @deTotal_Dev=0,   @deMonto_Dev=0,   @deOtros=0,   @deMonto_Imp2=0,   @deMonto_Imp3=0,   @sComentario=NULL,   @deMonto_Desc_Glob=0,
//                  @deMonto_Reca_Glob=0,   @deOtros1_Glob=0,   @deOtros2_glob=0,   @deOtros3_glob=0,   @deMonto_imp_afec_glob=0,   @deMonto_imp2_afec_glob=0,
//                  @deMonto_imp3_afec_glob=0,   @iRENG_NUM=2,   @sREVISADO=NULL,   @sTRASNFE=NULL,   @sco_sucu_in=
//         '01',@sco_us_in  ='PROFIT'
//        ,
//                 @sMaquina
//          ='DESKTOP-9T6DKB3'
//        resulta = m.pInsertarFacturaVenta(
//                "1233", //sDoc_Num
//                "Descripcion",//@sDescrip
//                "COR-001", // CLIENTE 
//                "01",// TRANSPORTE
//                "BS",//MONEDA
//                null,// @sCo_Cta_Ingr_Egr,//Cuente IngresEgre
//                "01",// vendedor
//                "01",// CONDICION DE  PAgo
//                "20230303", // fecha
//                "20230306",// fecha Vencimiento
//                "20230303", // fech Registr
//                "1",//anulado
//                "0",//@sStatus
//                "01", // tasa
//                "02222",//@sN_Control
//                "00", // @sPorc_Desc_Glob
//                "00",/*@deMonto_Desc_Glob*/
//                "0"/*@sPorc_Reca*/,
//                "00" /*deMonto_Reca*/,
//                "00", // @deSaldo
//                "10222",//deTotal_Bruto, 
//                "12", //deMonto_Imp, 
//                "0",//deMonto_Imp2
//                "0",//deMonto_Imp3, 
//                "1",//deOtros1, 
//                "0", //deOtros2, 
//                "0", //deOtros3, 
//                "344",//@deTotal_Neto, 
//                null,//@sDis_Cen,
//                "comentario",//sComentario,
//                "Direccion Entrega", //sDir_Ent,
//                "0", //bContrib, 
//                "0",//bImpresa,
//                null, // sSalestax, 
//                "2", //sImpfis,
//                "3", //sImpfisfac,@sImp_nro_z
//                ""  ,//@sImp_nro_z
//                "0",//bVen_Ter, 
//                "camp1",
//                "camp2",
//                "camp3",
//                "camp4",
//                "camp5",
//                "camp6",
//                "cam7",
//                "Campo8",
//                "999",//@sCo_Us_In
//                "VAl",//@sCo_Sucu_In
//                "1",//@sRevisado
//                "1",//@@sTrasnfe
//                "Host"//@sMaquina
//        );
//
//        System.out.println("RESULTADO" + resulta);
//        resulta = m.pInsertarRenglonesFacturaVenta(
//                12, ///iReng_Num,
//                "1233", // sDoc_Num,
//                "0101002",
//                "Descripcoio del Articulo ",
//                "UNI", // unidad 
//                "UNI", //sSco_Uni,
//                "VAL", // sCo_Alma,
//                "", //sCo_Precio, 
//                "1",// sTipo_Imp,
//                "0.0", //sTipo_Imp2,
//                "0.0",// sTipo_Imp3,
//                23.1,// Double.MAX_VALUE,
//                0.0, // deSTotal_Art,
//                1.2, //dePrec_Vta, 
//                1.2,//sPorc_Desc, 
//                1.2,//deMonto_Desc, 
//                1.2, //deReng_Neto, 
//                1.2, //dePendiente,
//                1.2, //dePendiente2,
//                1.2, //deMonto_Desc_Glob, 
//                1.2, //deMonto_reca_Glob,
//                1.2, //deOtros1_glob, 
//                1.2, //deOtros2_glob,
//                1.2,//deOtros3_glob,
//                1.2, //deMonto_imp_afec_glob,
//                1.2, //deMonto_imp2_afec_glob,
//                "0.0", //deMonto_imp3_afec_glob,
//                null, //sTipo_Doc, 
//                null, //gRowguid_Doc
//                "0.0", //sNum_Doc,
//                "0", //dePorc_Imp, 
//                "0", //dePorc_Imp2,
//                "0", //dePorc_Imp3,
//                "0", //deMonto_Imp,
//                "0", //deMonto_Imp2,
//                "0", //deMonto_Imp3,
//                "0", //deOtros,
//                "0", //deTotal_Dev,
//                "0", //deMonto_Dev, 
//                "0", //sComentario,
//                null, //sDis_Cen, 
//                "0", ////sCo_Sucu_In, 
//                "0", //sCo_Us_In,
//                "0", //sREVISADO,
//                "0", //sTRASNFE, 
//                "0" //sMaquina
//        );
/*
exec pInsertarCotizacionProveedor @sdFec_Emis='2023-09-19 10:37:00',@sDoc_Num='34444',
@sNro_Fact=NULL,@sDescrip='DESCRIPCION DCOTIZACIOM',@sCo_Prov='01-002',@sCo_Cta_Ingr_Egr=NULL,
@sCo_Mone='BS',@sCo_Cond='02',@sN_Control=NULL,@sPorc_Desc_Glob='0',@sdFec_Venc='2023-10-04 10:37:00',
@sdFec_Reg='2023-09-19 10:37:00',@bAnulado=0,@sStatus='0',@deTasa=1,@sPorc_Reca=NULL,
@deSaldo=36.76,@deTotal_Bruto=36.76,@deTotal_Neto=36.76,@deMonto_Desc_Glob=0,@deMonto_Reca=0,
@deOtros1=0,@deOtros2=0,@deOtros3=0,@deMonto_Imp=0,@deMonto_Imp2=0,@deMonto_Imp3=0,@sDir_Ent=NULL,
@sComentario=NULL,@bImpresa=0,@sSalesTax=NULL,@sDis_Cen=NULL,@bnac=0,@sCampo1=NULL,@sCampo2=NULL,
@sCampo3=NULL,@sCampo4=NULL,@sCampo5=NULL,@sCampo6=NULL,@sCampo7=NULL,@sCampo8=NULL,@sRevisado=NULL,
@sTrasnfe=NULL,@sco_sucu_in='01',@sco_us_in='PROFIT',@sMaquina='DESKTOP-V3GPT3L'*/
/// insertar renglones de las ventas 

        /*
exec pInsertarRenglonesCotizacionProveedor @sDoc_Num='3444444',@sCo_Art='0101007',@sDes_Art=NULL,
@sCo_Alma='VAL',@sCo_Uni='UNI',@sSCo_Uni=NULL,@sTipo_Imp='6',@sTipo_Imp2=NULL,@sTipo_Imp3=NULL,
@deCost_Unit=11.650000,@deCost_Unit_OM=11.65000,@deTotal_Art=2,@deStotal_Art=0,@deOtros=0,
@dePorc_Imp=0,@dePorc_Imp2=0,@dePorc_Imp3=0,@deMonto_Imp=0,@deMonto_Imp2=0,@deMonto_Imp3=0,
@sPorc_Desc=NULL,@deReng_Neto=23.30,@sTipo_Doc=NULL,@gRowguid_Doc=NULL,@sNum_Doc=NULL,
@deTotal_Dev=0,@deMonto_Dev=0,@dePendiente2=0,@sComentario=NULL,@iReng_Doc=0,@sDis_Cen=NULL,
@bLote_Asignado=0,@deMonto_Desc=0,@dePendiente=2,@deCosto_Adi1=0,@deCosto_Adi2=0,@deCosto_Adi3=0
,@dePorc_Gas=0,@deMonto_Desc_Glob=0,@deMonto_Reca_Glob=0,@deOtros1_Glob=0,@deOtros2_glob=0,
@deOtros3_glob=0,@deMonto_imp_afec_glob=0,@deMonto_imp2_afec_glob=0,@deMonto_imp3_afec_glob=0,
@iRENG_NUM=2,@sREVISADO=NULL,@sTRASNFE=NULL,@sco_sucu_in='01',@sco_us_in='PROFIT',
@sMaquina='DESKTOP-V3GPT3L'
         */
 /* resulta = m.pInsertarRenglonesCotizacionProveedor(
                1, //iReng_Num
                "99999",// sDoc_num,
                "FINASTERIDE 5MG X  30 TABL", //sCo_art,
                "FINASTERIDE 5MG X  30 TABL",// sDes_Art,
                "UNI", // sCo_Uni,
                null, // sSCo_Uni, 
                "val", // sCo_Almacen, 
                "1",// sTipo_imp,
                "0", // sTipo_Imp2,
                "0", //sTipo_Imp3,
                null, // sTipo_Doc,
                "0", // sPorc_Desc,
                null,// sNum_Doc,
                null, //gRowGuid_Doc,
                2,// deReng_Neto
                2,//deCost_Unit
                0,//@deCost_Unit_OM
                2,//@deTotal_Art
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
                "0", //comentario
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
                "local", //sMaquina,
                0,//@deCosto_Adi1
                0, //@deCosto_Adi2,
                0 ///@deCosto_Adi3
        );*/
    }
}
