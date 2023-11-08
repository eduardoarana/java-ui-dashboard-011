/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javaswing.conection.Conexion;

/**
 *
 * @author admin
 */
public class InventarioModelo {

    public static Connection con;
    public CallableStatement cstmt;
    public ResultSet rs;
    public Conexion conexion;
    public Statement st;
    public int resultado = 0;

    public InventarioModelo() {
         con = conexion.conexionControlCenter("DEMOA", "profit", "profit");
    }
    

    
}
