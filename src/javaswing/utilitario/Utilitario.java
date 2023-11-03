/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.utilitario;

import com.toedter.calendar.JDateChooser;
import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswing.conection.Conexion;

/**
 *
 * @author eArana
 */
public class Utilitario {

     public static CallableStatement cstmt;
    public static ResultSet rs;
    public static Connection con;
    public Conexion conexion;
    public Utilitario() {
    }
    
     //formato Fecha parametro Jcalendar  YYYY-MM-DD
    public static String obtenerFecha(JDateChooser calendario) {
        try {
            int dia, mes, ano;
            String fecha;

            dia = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
            mes = calendario.getCalendar().get(Calendar.MONTH) + 1;
            ano = calendario.getCalendar().get(Calendar.YEAR);
            fecha = String.valueOf(ano) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia);
            return fecha;
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    //Parametro string formatofecha  yyyy-MM-dd  y retorna fecha tipo Date..
    public static Date obtenerFecha(String Sfecha) {
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyymmdd");

        Date fecha = new Date();
        try {
            fecha = objSDF.parse(Sfecha);
        } catch (ParseException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }
    
    

    public static String nombreHost() {
        String nombreHost = "";
        try {
            nombreHost = InetAddress.getLocalHost().getHostName();//.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreHost;
    }
     public static String fechaActual(){
        LocalDateTime fechaActual = LocalDateTime.now();

    // Convertimos la fecha en formato String.
    String fechaActualString = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    // Imprimimos la fecha en formato String.
    System.out.println(fechaActualString);
    return fechaActualString;
    }
     
//Method que llama un StoreProcedure para obtener el id de una Tabla indicada ...
    //1 parametro Conexion ,
    //2 paramatro nombre de una Tabla la cual deseas buscar.
    //3 descripcion en este caso es el where 
    //4 Column es el nombre va despues del Where .
    //5 es  el Valor que vas a retornar.
    public static String getTablaId(Connection con, String tabla, String where, String column, String valorWhere) {
        String resultado = "";
        try {
            PreparedStatement pstmtConsultar = null;
            ResultSet rs;
             Conexion conexion = null;
            String sql = "Select " + column + " FROM " + tabla + " WHERE " + where + " = ?  ";
            pstmtConsultar = (PreparedStatement) con.prepareStatement(sql);
            pstmtConsultar.setString(1, valorWhere);
            rs = pstmtConsultar.executeQuery();
            if (rs.next()) {
                resultado = rs.getString(column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    
    public static String pObtenerProximoNumero(Connection con, String tabla, String campo, String prefijo) {
        String respuesta = "";
        try {
            cstmt = con.prepareCall("{CALL pObtenerProximoNumero("
                    + "?,"
                    + "?,"
                    + "?"
                    + ")}");

            cstmt.setString(1, tabla);
            cstmt.setString(2, campo);
            cstmt.setString(3, prefijo);
            cstmt.execute();
            rs = cstmt.getResultSet();
            while (rs.next()) {
                System.out.println(" VALORRR  " + rs.getString("Codigo"));
                respuesta = rs.getString("Codigo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
}
