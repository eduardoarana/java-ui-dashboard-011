/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import static Modelo.FacturaCompraModelo.con;
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
public class DocumentoVentaModelo {
     public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public int resultado = 0;

    public DocumentoVentaModelo() {
        con = conexion.conexions();
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

    public static void main(String args[]) {
        DocumentoVentaModelo m = new DocumentoVentaModelo();

//        exec pInsertarDocumentoVenta @sNro_Doc='888888888',@sCo_Tipo_Doc='FACT'
//,@sDoc_Orig='FACT',@sCo_Cli='COR-001',@sCo_Mone='BS',@sdFec_Reg='2023-09-08 10:11:00',
//@sdFec_Emis='2023-09-08 10:11:00',@bAnulado=0,@deAdicional=0,
//@sMov_Ban=NULL,@bAut=1,@bContrib=0,@sObserva='FACT N°  de Cliente COR-001',@sNro_Orig='888888888'
//,@sNro_Che=NULL,@sCo_Ven='08',@sCo_Cta_Ingr_Egr=NULL,@deTasa=1,@sTipo_Imp=NULL,
//@deTotal_Bruto=1681.20,@deTotal_Neto=1950.19,@deMonto_Reca=0,@deMonto_Imp=268.99,@deMonto_Imp2=0,
//@deMonto_Imp3=0,@deSaldo=1950.19,@sN_Control='2222222',@sNum_Comprobante=NULL,@sDis_Cen=NULL,
//@deComis1=0,@deComis2=0,@deComis3=0,@deComis4=0,@deOtros1=0,@deOtros2=0,@deOtros3=0,
//@sPorc_Desc_Glob=NULL,@deMonto_Desc_Glob=0,@sPorc_Reca=NULL,@dePorc_Imp=0,@dePorc_Imp2=0,
//@dePorc_Imp3=0,@sSalestax=NULL,@bVen_Ter=0,@sdFec_Venc='2023-09-08 10:11:00',@deComis5=0,@deComis6=0,
//@sImpFis=NULL,@sImpFisFac=NULL,@sImp_Nro_Z=NULL,@iTipo_Origen=0,@sCampo1=NULL,@sCampo2=NULL,
//@sCampo3=NULL,@sCampo4=NULL,@sCampo5=NULL,@sCampo6=NULL,@sCampo7=NULL,@sCampo8=NULL,
//@sRevisado=NULL,@sTrasnfe=NULL,@sco_sucu_in='01',@sco_us_in='PROFIT',@sMaquina='DESKTOP-V3GPT3L'
        int resul = 0;
        resul = m.pInsertarDocumentoVenta(
                "FACT",//   sCo_Tipo_Doc,
                "2333333",// sNro_Doc,
                "COR-001",//sCo_cli, 
                "08", // sCo_ven, 
                "BS",//sCo_Mone, 
                null, //sMov_Ban,
                null,//sCo_Cta_Ingr_Egr,
                1222, //deTasa, 
                "FACT N°  de Cliente COR-001",//sObserva,
                "2023-09-08 10:11:00",//dFec_Reg, 
                "2023-09-08 10:11:00", //dFec_Emis, 
                "2023-09-08 10:11:00",//dFec_Venc, 
                0, //bAnulado
                0, //baut
                0, // bContrib
                "FACT",//sDoc_Orig, 
                "2333333",//sNro_Orig, 
                "2", //sNro_Che,
                2.2, //deMonto_Imp
                1.1, //deSaldo
                1.1, // deTotal_Bruto
                1.1, //deMonto_Desc_Glob
                "3",//sPorc_Desc_Glob,
                "2",//sPorc_Reca,
                1.1, //deMonto_Reca
                1.1,//deTotal_Neto
                1.0,//deMonto_imp2
                0, //deMonto_imp3
                "1",//sTipo_Imp, 
                "0",//iTipo_Origen
                0,//dePorc_Imp
                0,// dePorc_Imp2
                0,//dePorc_Imp3
                "0",// sNum_Comprobante,
                "2222222",//sN_Control,
                "1",// sDis_Cen,
                0, //deComis1
                0, //deComis2
                0, //deComis3
                0, //deComis4
                0, //deComis5
                0, //deComis6
                0, //deAdicional
                null, //sSalestax, 
                0,//bVen_Ter
                "0",//sImpfis, 
               "0",//sImpfisfac, 
                "1",//sImp_nro_z, 
                0,//deOtros1
                0,//deOtros2
                0,//deOtros3
                "",//sCampo1, 
                "",//sCampo2,
                "",//sCampo3,
                "",//sCampo4,
                "",//sCampo5, 
                "",//sCampo6, 
                "",//sCampo7, 
                "",//sCampo8, 
                "0",//sRevisado,
                "0", //sTrasnfe, 
                "01",//sCo_Sucu_In, 
                "999",//sCo_Us_In,
                "Host" //sMaquina
        );

        System.err.println("RESULTADO " + resul);

    }

}