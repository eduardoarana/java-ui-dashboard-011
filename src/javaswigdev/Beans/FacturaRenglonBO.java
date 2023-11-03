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
public class FacturaRenglonBO {

    // Detalle de la Factura 
    private String detalleFactura;
    private int item;
    private String numFactura; // Número de factura
    private int Cantdespachada;// Cantidad despachada por la droguería
    private String codBarra; //Código de barra
    private String DescripcionArt; // descripcion del Producto 
    private double precioVentaS;// Precio de VEntas Sugerido 
    private double margenDescuentos; //Margen de descuento
    private String oferta; // oferta 
    private double descuentoComercial;// Descuento comercial
    private double descuentInternet; //Descuento de Internet
    private double precioUnitario; // precio Unitario del producto
    private double IVA;
    private double totalNetoReng; // TotalNeto Renglon 
    private String gaceta;// Indicador con una “X” si está en gaceta
    private int NumPedidoArti; // Número de  Pedididos de Drolanca
    private String codMateriDrolanc;// Codigo Material de Drolanca 
    private String oferta1;// 
    private String oferta2;// 

    /// SUBTOTAL 
    private double montoTotalDescueInternet; /// Total otorgado por descuento de internet
    private double montoTotalOtorgadoDesEspc; // Total otorgado por descuento especial
    private double montoNetoFact; // Neto de  factura ;
    private double baseImponible;// Base  Imponible 
    private double totalIVA; // total IVA
    private double totalFactura;//  Total de la factura
    private double desprontpag; //Descuento por pronto pago
    private double totProntPag; //Total pronto pago
    private String fechaFactura; // Fecha de la Factura 
    private int NmerBulto; //Nro de Bultos
    private int totUnidades;// Total unidades
    private int totRenglones; // Total Renglones 
    private double producPrecioMarcado;// BsF Productos con Precio Marcado
    private double BaseExentoIVA; // Base Exento IVA
    private double artSinMontoMarcado;  //BsF Productos sin Precio Marcado

    public FacturaRenglonBO() {

    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public int getCantdespachada() {
        return Cantdespachada;
    }

    public void setCantdespachada(int Cantdespachada) {
        this.Cantdespachada = Cantdespachada;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescripcionArt() {
        return DescripcionArt;
    }

    public void setDescripcionArt(String DescripcionArt) {
        this.DescripcionArt = DescripcionArt;
    }

    public double getPrecioVentaS() {
        return precioVentaS;
    }

    public void setPrecioVentaS(double precioVentaS) {
        this.precioVentaS = precioVentaS;
    }

    public double getMargenDescuentos() {
        return margenDescuentos;
    }

    public void setMargenDescuentos(double margenDescuentos) {
        this.margenDescuentos = margenDescuentos;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public double getDescuentoComercial() {
        return descuentoComercial;
    }

    public void setDescuentoComercial(double descuentoComercial) {
        this.descuentoComercial = descuentoComercial;
    }

    public double getDescuentInternet() {
        return descuentInternet;
    }

    public void setDescuentInternet(double descuentInternet) {
        this.descuentInternet = descuentInternet;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotalNetoReng() {
        return totalNetoReng;
    }

    public void setTotalNetoReng(double totalNetoReng) {
        this.totalNetoReng = totalNetoReng;
    }

    public String getGaceta() {
        return gaceta;
    }

    public void setGaceta(String gaceta) {
        this.gaceta = gaceta;
    }

    public int getNumPedidoArti() {
        return NumPedidoArti;
    }

    public void setNumPedidoArti(int NumPedidoArti) {
        this.NumPedidoArti = NumPedidoArti;
    }

    public String getCodMateriDrolanc() {
        return codMateriDrolanc;
    }

    public void setCodMateriDrolanc(String codMateriDrolanc) {
        this.codMateriDrolanc = codMateriDrolanc;
    }

    public String getOferta1() {
        return oferta1;
    }

    public void setOferta1(String oferta1) {
        this.oferta1 = oferta1;
    }

    public String getOferta2() {
        return oferta2;
    }

    public void setOferta2(String oferta2) {
        this.oferta2 = oferta2;
    }

    public double getMontoTotalDescueInternet() {
        return montoTotalDescueInternet;
    }

    public void setMontoTotalDescueInternet(double montoTotalDescueInternet) {
        this.montoTotalDescueInternet = montoTotalDescueInternet;
    }

    public double getMontoTotalOtorgadoDesEspc() {
        return montoTotalOtorgadoDesEspc;
    }

    public void setMontoTotalOtorgadoDesEspc(double montoTotalOtorgadoDesEspc) {
        this.montoTotalOtorgadoDesEspc = montoTotalOtorgadoDesEspc;
    }

    public double getMontoNetoFact() {
        return montoNetoFact;
    }

    public void setMontoNetoFact(double montoNetoFact) {
        this.montoNetoFact = montoNetoFact;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public double getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getDesprontpag() {
        return desprontpag;
    }

    public void setDesprontpag(double desprontpag) {
        this.desprontpag = desprontpag;
    }

    public double getTotProntPag() {
        return totProntPag;
    }

    public void setTotProntPag(double totProntPag) {
        this.totProntPag = totProntPag;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getNmerBulto() {
        return NmerBulto;
    }

    public void setNmerBulto(int NmerBulto) {
        this.NmerBulto = NmerBulto;
    }

    public int getTotUnidades() {
        return totUnidades;
    }

    public void setTotUnidades(int totUnidades) {
        this.totUnidades = totUnidades;
    }

    public int getTotRenglones() {
        return totRenglones;
    }

    public void setTotRenglones(int totRenglones) {
        this.totRenglones = totRenglones;
    }

    public double getProducPrecioMarcado() {
        return producPrecioMarcado;
    }

    public void setProducPrecioMarcado(double producPrecioMarcado) {
        this.producPrecioMarcado = producPrecioMarcado;
    }

    public double getBaseExentoIVA() {
        return BaseExentoIVA;
    }

    public void setBaseExentoIVA(double BaseExentoIVA) {
        this.BaseExentoIVA = BaseExentoIVA;
    }

    public double getArtSinMontoMarcado() {
        return artSinMontoMarcado;
    }

    public void setArtSinMontoMarcado(double artSinMontoMarcado) {
        this.artSinMontoMarcado = artSinMontoMarcado;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(String detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

}
