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
import java.sql.Statement;
import javaswing.conection.Conexion;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author eArana
 */
public class ClienteModelo {
    
    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public Statement st;
    public int resultado = 0;

    public ClienteModelo() {

         con = conexion.conexionControlCenter("DEMOA", "profit", "profit");
    }
    
    public DefaultComboBoxModel getListaComboBox(String cadenaEscrita, String tabla, String columna, int TipoQuery) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String query = "";
        if (TipoQuery == 1) {
            query = "SELECT " + columna + " FROM " + tabla + " WHERE " + columna + " LIKE '" + cadenaEscrita + "%';";

        } else if (TipoQuery == 2) {

            query = "select nombre_completo FROM  " + tabla + " as emple\n"
                    + "  inner join sncont as contr on emple.co_cont=contr.co_cont\n"
                    + "  where contr.des_cont LIKE '" + cadenaEscrita + "%';";
        }

        try {
            st = con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            if (TipoQuery == 1) {
                while (rs.next()) {
                    modelo.addElement(rs.getString(columna));
                }
            } else {
                while (rs.next()) {
                    modelo.addElement(rs.getString("nombre_completo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }

}
