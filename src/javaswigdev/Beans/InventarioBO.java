/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswigdev.Beans;

import java.io.Serializable;

/**
 *
 * @author eArana
 */
public class InventarioBO implements Serializable {

    private String codigoMaterial; //Código del material
    private String codigoBarra;// Codigo de barra 
    private String DescripcionMaterial; // Descripcion del Material
    private String codigoLinea; // Codigo de la Linea .
    private String descripcionLinea; //Descripcion de la Linea ;
    private int cantBultoOriginal; // Cantidad Bulto Original ;
    private double IVA; // IVA
    private double gaceta;// Gaceta
    private double precioPreferencial;// Precio Preferencial
    private int existencia;// Existencia 
    private double entradaDelDia; // Entrada del Dia 
    private double descuentoL1; // Descuento 
    private double descuentoL2;
    private double descuentoL3;
    private String tipoOferta; // Tipo de Oferta .
    private int cantidadOferta; // Cantidades de ofertas .
    private int porcentajeOferta;
    private String condicionDePagoxArt; //  Condición de pago por material
    private String condPagMaterial;  // Descripción de condición de pago por material
    private int item;
    private String codigoFactura;
    private String fechaEmision;
    private double precio1;
    private double decimal;
    private double precio2;
    private int cantidad;
    private int cantiFactura;
    private int CantRec;
    private double costoProv;
    private double costoProv$;
    private double Dcto;
    private double costoNeto;
    private double costoNeto$;
    private double precioSugerido;
    private double precioSugerido$;
    private double subTotal;
    private double subTotal$;
    private String unidad;
    private String almacen;
    private int cantidadOferta11;
    private double porcentajeOfeta11;
    private int cantidadOferta12;
    private double porcentajeOferta12;
    private int cantidadOferta13 ;
    private double porsentajeOferta13;
    private String tipoOferta2;
    private int CantidadOferta21;
    private double porcentajeOferta21;
    private int cantidadOferta22;
    private double porcentajeOferta22;
    private int cantidadOferta23;
    private double porcentajeOferta23;
    private String tipoOferta3;
    private int cantidadOferta31;
    private double porcentajeOferta31 ;
    private int cantidadOferta32;
    private double porcentajeOferta32;
    private int cantidadOferta33;
    private double porcentajeOferta33;
    private String condicionPagoMaterial;
    private String descripcionCondicionPagoMaterial;
   private double setPorcentajeOferta13;

    public InventarioBO() {

    }

//    public int getCodigoFactura() {
//        return codigoFactura;
//    }
//
//    public void setCodigoFactura(int codigoFactura) {
//        this.codigoFactura = codigoFactura;
//    }
    public String getCodigoArticulo() {
        return codigoMaterial;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoMaterial = codigoArticulo;
    }

    public String getArticuloDescripcion() {
        return DescripcionMaterial;
    }

    public void setArticuloDescripcion(String articuloDescripcion) {
        this.DescripcionMaterial = articuloDescripcion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getPrecio1() {
        return precio1;
    }

    public void setPrecio1(double precio1) {
        this.precio1 = precio1;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getCantiFactura() {
        return cantiFactura;
    }

    public void setCantiFactura(int cantiFactura) {
        this.cantiFactura = cantiFactura;
    }

    public int getCantRec() {
        return CantRec;
    }

    public void setCantRec(int CantRec) {
        this.CantRec = CantRec;
    }

    public double getCostoProv() {
        return costoProv;
    }

    public void setCostoProv(double costoProv) {
        this.costoProv = costoProv;
    }

    public double getCostoProv$() {
        return costoProv$;
    }

    public void setCostoProv$(double costoProv$) {
        this.costoProv$ = costoProv$;
    }

    public double getDcto() {
        return Dcto;
    }

    public void setDcto(double Dcto) {
        this.Dcto = Dcto;
    }

    public double getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(double costoNeto) {
        this.costoNeto = costoNeto;
    }

    public double getPrecioSugerido() {
        return precioSugerido;
    }

    public void setPrecioSugerido(double precioSugerido) {
        this.precioSugerido = precioSugerido;
    }

    public double getPrecioSugerido$() {
        return precioSugerido$;
    }

    public void setPrecioSugerido$(double precioSugerido$) {
        this.precioSugerido$ = precioSugerido$;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal$() {
        return subTotal$;
    }

    public void setSubTotal$(double subTotal$) {
        this.subTotal$ = subTotal$;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getCostoNeto$() {
        return costoNeto$;
    }

    public void setCostoNeto$(double costoNeto$) {
        this.costoNeto$ = costoNeto$;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(String codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public String getDescripcionLinea() {
        return descripcionLinea;
    }

    public void setDescripcionLinea(String descripcionLinea) {
        this.descripcionLinea = descripcionLinea;
    }

    public int getCantBulto() {
        return cantBultoOriginal;
    }

    public void setCantBulto(int cantBulto) {
        this.cantBultoOriginal = cantBulto;
    }

    public double getGaceta() {
        return gaceta;
    }

    public void setGaceta(double gaceta) {
        this.gaceta = gaceta;
    }

    public double getPrecioPreferencial() {
        return precioPreferencial;
    }

    public void setPrecioPreferencial(double precioPreferencial) {
        this.precioPreferencial = precioPreferencial;
    }

    public double getEntradaDelDia() {
        return entradaDelDia;
    }

    public void setEntradaDelDia(double entradaDelDia) {
        this.entradaDelDia = entradaDelDia;
    }

    public double getDescuentoL1() {
        return descuentoL1;
    }

    public void setDescuentoL1(double descuentoL1) {
        this.descuentoL1 = descuentoL1;
    }

    public double getDescuentoL2() {
        return descuentoL2;
    }

    public void setDescuentoL2(double descuentoL2) {
        this.descuentoL2 = descuentoL2;
    }

    public double getDescuentoL3() {
        return descuentoL3;
    }

    public void setDescuentoL3(double descuentoL3) {
        this.descuentoL3 = descuentoL3;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public int getCantidadOferta() {
        return cantidadOferta;
    }

    public void setCantidadOferta(int cantidadOferta) {
        this.cantidadOferta = cantidadOferta;
    }

    public int getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(int porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    public String getCondicionDePagoxArt() {
        return condicionDePagoxArt;
    }

    public void setCondicionDePagoxArt(String condicionDePagoxArt) {
        this.condicionDePagoxArt = condicionDePagoxArt;
    }

    public String getCondPagMaterial() {
        return condPagMaterial;
    }

    public void setCondPagMaterial(String condPagMaterial) {
        this.condPagMaterial = condPagMaterial;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getDescripcionMaterial() {
        return DescripcionMaterial;
    }

    public void setDescripcionMaterial(String DescripcionMaterial) {
        this.DescripcionMaterial = DescripcionMaterial;
    }

    public int getCantBultoOriginal() {
        return cantBultoOriginal;
    }

    public void setCantBultoOriginal(int cantBultoOriginal) {
        this.cantBultoOriginal = cantBultoOriginal;
    }

    public int getCantidadOferta11() {
        return cantidadOferta11;
    }

    public void setCantidadOferta11(int cantidadOferta11) {
        this.cantidadOferta11 = cantidadOferta11;
    }

    public double getPorcentajeOfeta11() {
        return porcentajeOfeta11;
    }

    public void setPorcentajeOfeta11(double porcentajeOfeta11) {
        this.porcentajeOfeta11 = porcentajeOfeta11;
    }

    public int getCantidadOferta12() {
        return cantidadOferta12;
    }

    public void setCantidadOferta12(int cantidadOferta12) {
        this.cantidadOferta12 = cantidadOferta12;
    }

    public double getPorcentajeOferta12() {
        return porcentajeOferta12;
    }

    public void setPorcentajeOferta12(double porcentajeOferta12) {
        this.porcentajeOferta12 = porcentajeOferta12;
    }

    public int getCantidadOferta13() {
        return cantidadOferta13;
    }

    public void setCantidadOferta13(int cantidadOferta13) {
        this.cantidadOferta13 = cantidadOferta13;
    }

    public double getPorsentajeOferta13() {
        return porsentajeOferta13;
    }

    public void setPorsentajeOferta13(double porsentajeOferta13) {
        this.porsentajeOferta13 = porsentajeOferta13;
    }

    public String getTipoOferta2() {
        return tipoOferta2;
    }

    public void setTipoOferta2(String tipoOferta2) {
        this.tipoOferta2 = tipoOferta2;
    }

    public int getCantidadOferta21() {
        return CantidadOferta21;
    }

    public void setCantidadOferta21(int CantidadOferta21) {
        this.CantidadOferta21 = CantidadOferta21;
    }

    public double getPorcentajeOferta21() {
        return porcentajeOferta21;
    }

    public void setPorcentajeOferta21(double porcentajeOferta21) {
        this.porcentajeOferta21 = porcentajeOferta21;
    }

    public int getCantidadOferta22() {
        return cantidadOferta22;
    }

    public void setCantidadOferta22(int cantidadOferta22) {
        this.cantidadOferta22 = cantidadOferta22;
    }

    public double getPorcentajeOferta22() {
        return porcentajeOferta22;
    }

    public void setPorcentajeOferta22(double porcentajeOferta22) {
        this.porcentajeOferta22 = porcentajeOferta22;
    }

    public int getCantidadOferta23() {
        return cantidadOferta23;
    }

    public void setCantidadOferta23(int cantidadOferta23) {
        this.cantidadOferta23 = cantidadOferta23;
    }

    public double getPorcentajeOferta23() {
        return porcentajeOferta23;
    }

    public void setPorcentajeOferta23(double porcentajeOferta23) {
        this.porcentajeOferta23 = porcentajeOferta23;
    }

    public String getTipoOferta3() {
        return tipoOferta3;
    }

    public void setTipoOferta3(String tipoOferta3) {
        this.tipoOferta3 = tipoOferta3;
    }

    public int getCantidadOferta31() {
        return cantidadOferta31;
    }

    public void setCantidadOferta31(int cantidadOferta31) {
        this.cantidadOferta31 = cantidadOferta31;
    }

    public double getPorcentajeOferta31() {
        return porcentajeOferta31;
    }

    public void setPorcentajeOferta31(double porcentajeOferta31) {
        this.porcentajeOferta31 = porcentajeOferta31;
    }

    public int getCantidadOferta32() {
        return cantidadOferta32;
    }

    public void setCantidadOferta32(int cantidadOferta32) {
        this.cantidadOferta32 = cantidadOferta32;
    }

    public double getPorcentajeOferta32() {
        return porcentajeOferta32;
    }

    public void setPorcentajeOferta32(double porcentajeOferta32) {
        this.porcentajeOferta32 = porcentajeOferta32;
    }

    public int getCantidadOferta33() {
        return cantidadOferta33;
    }

    public void setCantidadOferta33(int cantidadOferta33) {
        this.cantidadOferta33 = cantidadOferta33;
    }

    public double getPorcentajeOferta33() {
        return porcentajeOferta33;
    }

    public void setPorcentajeOferta33(double porcentajeOferta33) {
        this.porcentajeOferta33 = porcentajeOferta33;
    }

    public String getCondicionPagoMaterial() {
        return condicionPagoMaterial;
    }

    public void setCondicionPagoMaterial(String condicionPagoMaterial) {
        this.condicionPagoMaterial = condicionPagoMaterial;
    }

    public String getDescripcionCondicionPagoMaterial() {
        return descripcionCondicionPagoMaterial;
    }

    public void setDescripcionCondicionPagoMaterial(String descripcionCondicionPagoMaterial) {
        this.descripcionCondicionPagoMaterial = descripcionCondicionPagoMaterial;
    }

    public double getSetPorcentajeOferta13() {
        return setPorcentajeOferta13;
    }

    public void setSetPorcentajeOferta13(double setPorcentajeOferta13) {
        this.setPorcentajeOferta13 = setPorcentajeOferta13;
    }

}
