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
public class PedidoVentasBO {

    private int CodigoCliente;
    private String DescripcionProducto;
    private int cantidad;
    private int codigoArt;
    private int numeroPedido;
    private String SucursalDEspacho;
    ////Profit 2k12 ////
        private String doc_num;
        private String descrip;
        private String co_cli;
        private String co_tran;
        private String co_mone;
        private String co_ven;
        private String co_cond;
        private String fec_emis;
        private String fec_venc;
        private String fec_reg;
        private String anulado;
        private String status;
        private String n_control;
        private int ven_ter;
        private double tasa;
        private String porc_desc_glob;
        private double monto_desc_glob;
        private String porc_reca;
        private double monto_reca;
        private double total_bruto;
        private double monto_imp;
        private double monto_imp2;
        private double monto_imp3;
        private double otros1;
        private double otros2;
        private double otros3;
        private double total_neto;
        private double saldo;
        private String dir_ent;
        private String comentario;
        private String dis_cen;
        private String feccom;
        private int numcom;
        private int contrib;
        private String impresa;
        private int seriales_s;
        private String salestax;
        private String impfis;
        private String impfisfac;
        
        private String campo1;
        private String campo2;
        private String campo3;
        private String campo4;
        private String campo5;
        private String campo6;
        private String campo7;
        private String campo8;
        

    public PedidoVentasBO() {
    }

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
