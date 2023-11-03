/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javaswing.conection.Conexion;
import java.beans.Statement;
import java.sql.*;

/**
 *
 * @author earana
 */
public class LoginModel {

    public static Connection con;
    public static PreparedStatement pstmtInsertar, pstmtConsultar,
            pstmtAcctualizar, pstmtEliminar;
    public CallableStatement cstmt;
    Statement stmt = null;
    public ResultSet rs;
    public static ResultSetMetaData rsmtd;
    public Conexion conexion;

    public LoginModel() {
        con = conexion.conexionControlCenter("MasterProfitPro", "profit", "profit");
    }

    public int pAutenticarUsuario(String usuario, String password) throws SQLException {
        int bandera = 0;
        cstmt = con.prepareCall("{CALL pAutenticarUsuario(?,?)}");

        cstmt.setString(1, usuario);
        cstmt.setString(2, password);
        rs = cstmt.executeQuery();

        while (rs.next()) {
            //return bandera = rs.getRow();
            System.err.println("return "+ rs.getRow());
            return rs.getRow();
        }
        return bandera;
    }

//    public static void main(String arg[]) throws SQLException {
//        LoginModel l = new LoginModel();
//        int resul = l.pAutenticarUsuario("2222" , "233332354");
//        System.out.println("Resultado  " + resul);
//         
//    }
}
/*
 * exec pInsertarUsuario @sCod_Usuario ='EDUA', @sDesc_Usuario ='DEWSCRIP',
 * @sPassword ='1234', @dePrioridad =0, @sUsuario_Nodo ='33', @sId_Grupo ='3',
 * @bCamb_Sucu =0 , @bPide_Sucu =0, @sSucursal ='cAR', @sId_Idioma ='ESP',
 * @bPcontrol_1 =0, @bPcontrol_2 =0, @iSerie =1, @dFec_Ult ='2020-06-24
 * 00:00:00', @dFec_Prox ='2020-06-24 00:00:00', @iVeces =2, @dFec_Ult_FA
 * ='2020-06-24 00:00:00', @sEstado ='1', @sAd_Login ='LOGI', @sCod_Empresa
 * ='EDED', @bSel_Emp =0, @sco_mapa = '2', @bAcceso_Todas_Empresa =0, @sCo_Us_In
 * ='edU', @sCampo1 ='CAMPO1', @sCampo2 ='CAMPO2', @sCampo3 =null , @sCampo4 =
 * null , @sCampo5 = null , @sCampo6 = null , @sCampo7 = null , @sCampo8 = null
 * , @sRevisado ='23', @sTrasnfe ='33', @Sel_Emp =0, @Sel_Emp_Admi =0,
 * @sProducto = 'admin'
 *///

