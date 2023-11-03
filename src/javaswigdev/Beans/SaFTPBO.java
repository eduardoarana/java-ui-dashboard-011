/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswigdev.Beans;

/**
 *
 * @author eArana
 */
public class SaFTPBO {
    
    
    private int  id ;
    private String nameServidor;
    private String usuario ;
    private String puerto;
    private String passwor;
    private String rutaDirectorioFactura;
    private String rutaDirectorioPedidos;
    private String rutaDirectorioCatalogo;
    private String conexion;

    public SaFTPBO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameServidor() {
        return nameServidor;
    }

    public void setNameServidor(String nameServidor) {
        this.nameServidor = nameServidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    public String getRutaDirectorioFactura() {
        return rutaDirectorioFactura;
    }

    public void setRutaDirectorioFactura(String rutaDirectorioFactura) {
        this.rutaDirectorioFactura = rutaDirectorioFactura;
    }

    public String getRutaDirectorioPedidos() {
        return rutaDirectorioPedidos;
    }

    public void setRutaDirectorioPedidos(String rutaDirectorioPedidos) {
        this.rutaDirectorioPedidos = rutaDirectorioPedidos;
    }

    public String getRutaDirectorioCatalogo() {
        return rutaDirectorioCatalogo;
    }

    public void setRutaDirectorioCatalogo(String rutaDirectorioCatalogo) {
        this.rutaDirectorioCatalogo = rutaDirectorioCatalogo;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    

       
    
}
