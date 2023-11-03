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
public class FacturaVentaBO {

    private double totalOtorgadoDescuentoInternet;//Total otorgado por descuento de internet
    private double totalDescuentoespecial;//Total otorgado por descuento especia
    private double netoFactura; //Neto de la factura
    private double baseImponible; //Base imponible
    private double ivaPorc; //%  IVA 
    private double totalIVA; //% Total IVA 
    private double totalFactura; //Total de la factura
    private double descuentoProntoPago; //%  Descuento  Pronto Pago
    private double totalProntoPago; //%  total  Pronto Pago
    
    private String fechaFactura; //% Fecha Factura  
    private int nroBultos; //Numero de Bultos  
    private double TotalUnidades; //% TotalUnidades 
    private double totalRenglones; //% totan Renglones 
    private double productoPrecioMarcadosBsF; //% IVA IVA 
    private double baseExentoIva; //%Base Exento IVA
    private double productoSinPrecioMarcadosBsF;//BsF Productos sin Precio Marcado;

    //////////////////////////////////////////////////
    /////Profit
    //////////////////////////////////////////////////
    private String doc_num;
    private String descrip;
    private String co_cli;
    private String descripcionCliente;
    private String co_tran;
    private String descripciontransporte;
    private String co_mone;
    private String descripcionMoneda;
    private String tasaMoneda;
    private String co_ven;
    private String descripcionVendedor;
    private String co_cond;
    private String descripcionCodPago;
    private String fec_emis;
    private String fec_venc;
    private String fec_reg;
    private int anulado;
    private String status;
    private double deTasa;
    private String n_control;
    private String porc_desc_glob;
    private double monto_desc_glob;
    private String porc_reca;
    private double monto_reca;
    private double saldo;
    private double total_bruto;
    private double monto_imp;
    private double monto_imp2;
    private double monto_imp3;
    private double otros1;
    private double otros2;
    private double otros3;
    private double total_neto;
    private String dis_cen;
    private String comentario;
    private String dir_ent;
    private int contrib;
    private int bImpresa;
    private String salestax;
    private String impfis;
    private String impfisfac;
    private String imp_nro_z;
    private int ven_ter;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
    private String campo5;
    private String campo6;
    private String campo7;
    private String campo8;
    private String feccom;
    private String numcom;
    private String seriales_s;
    private String co_us_in;
    private String co_sucu_in;
    private String fe_us_in;
    private String co_us_mo;
    private String co_sucu_mo;
    private String fe_us_mo;
    private String revisado;
    private String trasnfe;
    private String validador;
    private String rowguid;
    private String co_cta_ingr_egr;
    private String co_Almacen;

    public FacturaVentaBO() {

    }

    public double getTotalOtorgadoDescuentoInternet() {
        return totalOtorgadoDescuentoInternet;
    }

    public void setTotalOtorgadoDescuentoInternet(double totalOtorgadoDescuentoInternet) {
        this.totalOtorgadoDescuentoInternet = totalOtorgadoDescuentoInternet;
    }

    public double getTotalDescuentoespecial() {
        return totalDescuentoespecial;
    }

    public void setTotalDescuentoespecial(double totalDescuentoespecial) {
        this.totalDescuentoespecial = totalDescuentoespecial;
    }

    public double getNetoFactura() {
        return netoFactura;
    }

    public void setNetoFactura(double netoFactura) {
        this.netoFactura = netoFactura;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public double getIvaPorc() {
        return ivaPorc;
    }

    public void setIvaPorc(double ivaPorc) {
        this.ivaPorc = ivaPorc;
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

    public double getDescuentoProntoPago() {
        return descuentoProntoPago;
    }

    public void setDescuentoProntoPago(double descuentoProntoPago) {
        this.descuentoProntoPago = descuentoProntoPago;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getNroBultos() {
        return nroBultos;
    }

    public void setNroBultos(int nroBultos) {
        this.nroBultos = nroBultos;
    }

    public double getTotalUnidades() {
        return TotalUnidades;
    }

    public void setTotalUnidades(double TotalUnidades) {
        this.TotalUnidades = TotalUnidades;
    }

    public double getTotalRenglones() {
        return totalRenglones;
    }

    public void setTotalRenglones(double totalRenglones) {
        this.totalRenglones = totalRenglones;
    }

    public double getProductoPrecioMarcadosBsF() {
        return productoPrecioMarcadosBsF;
    }

    public void setProductoPrecioMarcadosBsF(double productoPrecioMarcadosBsF) {
        this.productoPrecioMarcadosBsF = productoPrecioMarcadosBsF;
    }

    public double getBaseExentoIva() {
        return baseExentoIva;
    }

    public void setBaseExentoIva(double baseExentoIva) {
        this.baseExentoIva = baseExentoIva;
    }

    public double getProductoSinPrecioMarcadosBsF() {
        return productoSinPrecioMarcadosBsF;
    }

    public void setProductoSinPrecioMarcadosBsF(double productoSinPrecioMarcadosBsF) {
        this.productoSinPrecioMarcadosBsF = productoSinPrecioMarcadosBsF;
    }

    public String getDoc_num() {
        return doc_num;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCo_cli() {
        return co_cli;
    }

    public void setCo_cli(String co_cli) {
        this.co_cli = co_cli;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    public String getCo_tran() {
        return co_tran;
    }

    public void setCo_tran(String co_tran) {
        this.co_tran = co_tran;
    }

    public String getDescripciontransporte() {
        return descripciontransporte;
    }

    public void setDescripciontransporte(String descripciontransporte) {
        this.descripciontransporte = descripciontransporte;
    }

    public String getCo_mone() {
        return co_mone;
    }

    public void setCo_mone(String co_mone) {
        this.co_mone = co_mone;
    }

    public String getDescripcionMoneda() {
        return descripcionMoneda;
    }

    public void setDescripcionMoneda(String descripcionMoneda) {
        this.descripcionMoneda = descripcionMoneda;
    }

    public String getTasaMoneda() {
        return tasaMoneda;
    }

    public void setTasaMoneda(String tasaMoneda) {
        this.tasaMoneda = tasaMoneda;
    }

    public String getCo_ven() {
        return co_ven;
    }

    public void setCo_ven(String co_ven) {
        this.co_ven = co_ven;
    }

    public String getDescripcionVendedor() {
        return descripcionVendedor;
    }

    public void setDescripcionVendedor(String descripcionVendedor) {
        this.descripcionVendedor = descripcionVendedor;
    }

    public String getCo_cond() {
        return co_cond;
    }

    public void setCo_cond(String co_cond) {
        this.co_cond = co_cond;
    }

    public String getDescripcionCodPago() {
        return descripcionCodPago;
    }

    public void setDescripcionCodPago(String descripcionCodPago) {
        this.descripcionCodPago = descripcionCodPago;
    }

    public String getFec_emis() {
        return fec_emis;
    }

    public void setFec_emis(String fec_emis) {
        this.fec_emis = fec_emis;
    }

    public String getFec_venc() {
        return fec_venc;
    }

    public void setFec_venc(String fec_venc) {
        this.fec_venc = fec_venc;
    }

    public String getFec_reg() {
        return fec_reg;
    }

    public void setFec_reg(String fec_reg) {
        this.fec_reg = fec_reg;
    }

    public int getAnulado() {
        return anulado;
    }

    public void setAnulado(int anulado) {
        this.anulado = anulado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDeTasa() {
        return deTasa;
    }

    public void setDeTasa(double deTasa) {
        this.deTasa = deTasa;
    }

    public String getN_control() {
        return n_control;
    }

    public void setN_control(String n_control) {
        this.n_control = n_control;
    }

    public String getPorc_desc_glob() {
        return porc_desc_glob;
    }

    public void setPorc_desc_glob(String porc_desc_glob) {
        this.porc_desc_glob = porc_desc_glob;
    }

    public double getMonto_desc_glob() {
        return monto_desc_glob;
    }

    public void setMonto_desc_glob(double monto_desc_glob) {
        this.monto_desc_glob = monto_desc_glob;
    }

    public String getPorc_reca() {
        return porc_reca;
    }

    public void setPorc_reca(String porc_reca) {
        this.porc_reca = porc_reca;
    }

    public double getMonto_reca() {
        return monto_reca;
    }

    public void setMonto_reca(double monto_reca) {
        this.monto_reca = monto_reca;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTotal_bruto() {
        return total_bruto;
    }

    public void setTotal_bruto(double total_bruto) {
        this.total_bruto = total_bruto;
    }

    public double getMonto_imp() {
        return monto_imp;
    }

    public void setMonto_imp(double monto_imp) {
        this.monto_imp = monto_imp;
    }

    public double getMonto_imp2() {
        return monto_imp2;
    }

    public void setMonto_imp2(double monto_imp2) {
        this.monto_imp2 = monto_imp2;
    }

    public double getMonto_imp3() {
        return monto_imp3;
    }

    public void setMonto_imp3(double monto_imp3) {
        this.monto_imp3 = monto_imp3;
    }

    public double getOtros1() {
        return otros1;
    }

    public void setOtros1(double otros1) {
        this.otros1 = otros1;
    }

    public double getOtros2() {
        return otros2;
    }

    public void setOtros2(double otros2) {
        this.otros2 = otros2;
    }

    public double getOtros3() {
        return otros3;
    }

    public void setOtros3(double otros3) {
        this.otros3 = otros3;
    }

    public double getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(double total_neto) {
        this.total_neto = total_neto;
    }

    public String getDis_cen() {
        return dis_cen;
    }

    public void setDis_cen(String dis_cen) {
        this.dis_cen = dis_cen;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDir_ent() {
        return dir_ent;
    }

    public void setDir_ent(String dir_ent) {
        this.dir_ent = dir_ent;
    }

    public int getContrib() {
        return contrib;
    }

    public void setContrib(int contrib) {
        this.contrib = contrib;
    }

    public int getbImpresa() {
        return bImpresa;
    }

    public void setbImpresa(int bImpresa) {
        this.bImpresa = bImpresa;
    }

    public String getSalestax() {
        return salestax;
    }

    public void setSalestax(String salestax) {
        this.salestax = salestax;
    }

    public String getImpfis() {
        return impfis;
    }

    public void setImpfis(String impfis) {
        this.impfis = impfis;
    }

    public String getImpfisfac() {
        return impfisfac;
    }

    public void setImpfisfac(String impfisfac) {
        this.impfisfac = impfisfac;
    }

    public String getImp_nro_z() {
        return imp_nro_z;
    }

    public void setImp_nro_z(String imp_nro_z) {
        this.imp_nro_z = imp_nro_z;
    }

    public int getVen_ter() {
        return ven_ter;
    }

    public void setVen_ter(int ven_ter) {
        this.ven_ter = ven_ter;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getFeccom() {
        return feccom;
    }

    public void setFeccom(String feccom) {
        this.feccom = feccom;
    }

    public String getNumcom() {
        return numcom;
    }

    public void setNumcom(String numcom) {
        this.numcom = numcom;
    }

    public String getSeriales_s() {
        return seriales_s;
    }

    public void setSeriales_s(String seriales_s) {
        this.seriales_s = seriales_s;
    }

    public String getCo_us_in() {
        return co_us_in;
    }

    public void setCo_us_in(String co_us_in) {
        this.co_us_in = co_us_in;
    }

    public String getCo_sucu_in() {
        return co_sucu_in;
    }

    public void setCo_sucu_in(String co_sucu_in) {
        this.co_sucu_in = co_sucu_in;
    }

    public String getFe_us_in() {
        return fe_us_in;
    }

    public void setFe_us_in(String fe_us_in) {
        this.fe_us_in = fe_us_in;
    }

    public String getCo_us_mo() {
        return co_us_mo;
    }

    public void setCo_us_mo(String co_us_mo) {
        this.co_us_mo = co_us_mo;
    }

    public String getCo_sucu_mo() {
        return co_sucu_mo;
    }

    public void setCo_sucu_mo(String co_sucu_mo) {
        this.co_sucu_mo = co_sucu_mo;
    }

    public String getFe_us_mo() {
        return fe_us_mo;
    }

    public void setFe_us_mo(String fe_us_mo) {
        this.fe_us_mo = fe_us_mo;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public String getTrasnfe() {
        return trasnfe;
    }

    public void setTrasnfe(String trasnfe) {
        this.trasnfe = trasnfe;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getCo_cta_ingr_egr() {
        return co_cta_ingr_egr;
    }

    public void setCo_cta_ingr_egr(String co_cta_ingr_egr) {
        this.co_cta_ingr_egr = co_cta_ingr_egr;
    }

    public String getCo_Almacen() {
        return co_Almacen;
    }

    public void setCo_Almacen(String co_Almacen) {
        this.co_Almacen = co_Almacen;
    }

    public double getTotalProntoPago() {
        return totalProntoPago;
    }

    public void setTotalProntoPago(double totalProntoPago) {
        this.totalProntoPago = totalProntoPago;
    }
}
