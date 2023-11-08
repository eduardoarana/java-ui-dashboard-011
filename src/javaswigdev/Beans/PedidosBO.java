/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswigdev.Beans;

/**
 *
 * @author admin
 */
public class PedidosBO {
   private int CodigoCliente ;
    private String DescripcionProducto;
    private int cantidad;
    private int codigoArt;
    private int numeroPedido;
    private String SucursalDEspacho; 

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        this.codigoArt = codigoArt;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getSucursalDEspacho() {
        return SucursalDEspacho;
    }

    public void setSucursalDEspacho(String SucursalDEspacho) {
        this.SucursalDEspacho = SucursalDEspacho;
    }
    
    
    
}
