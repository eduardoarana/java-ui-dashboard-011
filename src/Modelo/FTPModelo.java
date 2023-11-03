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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswigdev.Beans.SaFTPBO;
import javaswing.conection.Conexion;

/**
 *
 * @author eArana
 */
public class FTPModelo {

    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public int resultado = 0;

    public FTPModelo() {
        con = conexion.conexionControlCenter("demoa", "profit", "profit");
    }

    public int pInsertarFTP(
            String nameServidor,
            String puerto,
            String usuario,
            String passwor,
            String rutaDirectorioFactura,
            String rutaDirectorioPedidos,
            String rutaDirectorioCatalogo,
            String conectar
    ) {

        try {
            cstmt = con.prepareCall("{CALL pInsertarFTP("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + " )}");
            cstmt.setString(1, nameServidor);
            cstmt.setString(2, puerto);
            cstmt.setString(3, usuario);
            cstmt.setString(4, passwor);
            cstmt.setString(5, rutaDirectorioFactura);
            cstmt.setString(6, rutaDirectorioPedidos);
            cstmt.setString(7, rutaDirectorioCatalogo);
            cstmt.setString(8, conectar);

            resultado = cstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FTPModelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

//exec pObtenerListadoDatos 'demoa' ,'saFTP' , 'nameServidor','','2'
    public ArrayList<SaFTPBO> pObtenerListadoDatos(
            String sDatabase_Name,
            String sTable_Name,
            String sField_Name,
            String sValor,
            String iOpcion
    ) {
        ArrayList<SaFTPBO> lista = new ArrayList<SaFTPBO>();
        try {
            cstmt = con.prepareCall("{CAll pObtenerListadoDatos("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + ")}");

            cstmt.setString(1, sDatabase_Name);
            cstmt.setString(2, sTable_Name);
            cstmt.setString(3, sField_Name);
            cstmt.setString(4, sValor);
            cstmt.setString(5, iOpcion);
            cstmt.execute();
            rs = cstmt.getResultSet();
            while (rs.next()) {
                SaFTPBO ftpBO = new SaFTPBO();
                ftpBO.setId(rs.getInt("id"));
                ftpBO.setNameServidor(rs.getString("nameServidor"));
                ftpBO.setUsuario(rs.getString("usuario"));
                ftpBO.setPuerto(rs.getString("nroPuerto"));
                ftpBO.setPasswor(rs.getString("passwor"));
                ftpBO.setRutaDirectorioFactura(rs.getString("rutaDirectorioFactura"));
                ftpBO.setRutaDirectorioPedidos(rs.getString("rutaDirectorioPedidos"));
                ftpBO.setRutaDirectorioCatalogo(rs.getString("rutaDirectorioCatalogo"));
                ftpBO.setConexion(rs.getString("conexion"));
                
                lista.add(ftpBO);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public int pEliminarFTP(String idEliminar) {
        try {
            cstmt = con.prepareCall("{CALL pEliminarFTP("
                    + "?"
                    + " )}");
            cstmt.setString(1, idEliminar);
            resultado = cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String args[]) {

        int resul = 0;
        FTPModelo m = new FTPModelo();
        ArrayList<SaFTPBO> lista= m.pObtenerListadoDatos("demoa", "saFTP", "nameServidor", "", "2");
        System.out.println("LISTA " + lista.get(0).getNameServidor());
//        resul = m.pInsertarFTP("nombre", "12", "Eduardo", "2222222" ,"RUTA/FACTURA" , "RUTA/PEDIDOS","RUTA/CATOA","Activado");
//        System.out.println("RESULTADO" + resul);
    }
}
