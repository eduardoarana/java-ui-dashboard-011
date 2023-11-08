/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eArana
 */
public class Conexion {
     private static Connection com;

    public static Connection getCom() {
        return com;
    }

    public static void setCom(Connection com) {
        Conexion.com = com;
    }

    public Conexion() {
        // TODO Auto-generated constructor stub
    }

    public static Connection conexions() {
        try {
            //Conexion con Sql Postgres 
            //Class.forName("org.postgresql.Driver");
            //com = (Connection) DriverManager.getConnection("jdbc:postgresql:SystemNom", "postgres", "1234");
            // Conexion con Sql Server 
            //DESKTOP-9T6DKB3\GALACSQL17
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            com = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9T6DKB3\\SQLEXPRESS:1433;"
                    + "databaseName=demoa", "profit",
                    "profit");
            System.out.println("Exito");
            return com;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    //Crear Conexion a la Bases de Datos Control Center

    public static Connection conexionControlCenter(String BD, String usuario, String clave) {
        try {
            //Conexion con Sql Postgres 
            //Class.forName("org.postgresql.Driver");
            //com = (Connection) DriverManager.getConnection("jdbc:postgresql:SystemNom", "postgres", "1234");
            // Conexion con Sql Server 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            com = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9T6DKB3\\SQLEXPRESS:1433;"
                    + "databaseName=" + BD, "profit",
                    "profit");
            System.out.println("Exito ControlCenter");
            return com;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public static void cerrarConexion() {
        try {
            getCom().close();
            System.out.println("cerrarConexion()");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        Conexion s = new Conexion();
        Conexion.conexions();
//        Conexion.cerrarConexion();
        Conexion.conexionControlCenter("ControlCenter", "profit", "profit");
//      Conexion.cerrarConexion();
    }
}
