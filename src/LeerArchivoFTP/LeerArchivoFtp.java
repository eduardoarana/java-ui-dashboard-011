/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeerArchivoFTP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswigdev.Beans.FacturaRenglonBO;
import javaswigdev.Beans.FacturaVentaBO;
import javaswigdev.Beans.InventarioBO;
import javaswigdev.Beans.ListaArchivosBO;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.IOException;
import javaswigdev.Beans.Archivos;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eArana
 */
public class LeerArchivoFtp {

    public static InventarioBO inventarioCaracasBO;
    public FacturaRenglonBO facturaBO;

    public ArrayList<FacturaRenglonBO> ListaleerArchivoFacturaRenglon(String NumeroFactura, String opcion) {

        String rutaDelArchivo = "C:\\DescargasArchivoFTP\\Factura\\1244343.TXT";
        String linea = null, contenido;
        File doc_li = new File(rutaDelArchivo);
        double IVA = 0, rentNeto = 0;

        ArrayList<FacturaRenglonBO> lista = new ArrayList<FacturaRenglonBO>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo));

            int i = 1;
            while ((linea = br.readLine()) != null) {

                contenido = linea;
//                System.out.println(contenido);
                String[] vectoCadena = linea.split(";");

//                System.out.println(" " +  vectoCadena[0] + " "+vectoCadena[1]);
                if (NumeroFactura.equalsIgnoreCase(vectoCadena[1]) && opcion.equalsIgnoreCase("uno")) {
                    facturaBO = new FacturaRenglonBO();
                    System.out.println("Encontrado ");
                    facturaBO.setItem(i);
                    facturaBO.setCantdespachada(Integer.parseInt(vectoCadena[0]));
                    facturaBO.setCodBarra(vectoCadena[1]);
                    facturaBO.setDescripcionArt(vectoCadena[2]);
                    facturaBO.setPrecioVentaS(Double.parseDouble(vectoCadena[3]));
                    facturaBO.setMargenDescuentos(Double.parseDouble(vectoCadena[4]));
                    facturaBO.setOferta1(vectoCadena[5]);
                    facturaBO.setDescuentoComercial(Double.parseDouble(vectoCadena[6]));
                    facturaBO.setDescuentInternet(Double.parseDouble(vectoCadena[7]));
                    facturaBO.setPrecioUnitario(Double.parseDouble(vectoCadena[8]));
                    facturaBO.setIVA(Double.parseDouble(vectoCadena[9]));
                    facturaBO.setTotalNetoReng(Double.parseDouble(vectoCadena[10]));
                    facturaBO.setGaceta(vectoCadena[11]);
                    facturaBO.setNumPedidoArti(Integer.parseInt(vectoCadena[12]));
                    facturaBO.setCodMateriDrolanc(vectoCadena[12]);

                    lista.add(facturaBO);
                } else if (NumeroFactura.isEmpty() && opcion.equalsIgnoreCase("todos")) {
                    facturaBO = new FacturaRenglonBO();
                    if (vectoCadena[0].equalsIgnoreCase("D")) {
                        if (vectoCadena[11].isEmpty()) {
                            IVA = 0.0;
                        } else {
                            IVA = Double.parseDouble(vectoCadena[11]);
                        }

                        System.err.println("VALOR ::::::" + vectoCadena[12]);

//                        rentNeto = Double.parseDouble(vectoCadena[12].replaceAll(".", "") ) ;
                        facturaBO.setItem(i);
                        facturaBO.setNumFactura(vectoCadena[1]);
                        facturaBO.setCantdespachada(Integer.parseInt(vectoCadena[2]));
                        facturaBO.setCodBarra(vectoCadena[3]);
                        facturaBO.setDescripcionArt(vectoCadena[4]);
                        facturaBO.setPrecioVentaS(Double.parseDouble(vectoCadena[5].replaceAll(",", ".")));
                        facturaBO.setMargenDescuentos(Double.parseDouble(vectoCadena[6].replaceAll(",", ".")));
                        facturaBO.setOferta1(vectoCadena[7]);
                        facturaBO.setDescuentoComercial(Double.parseDouble(vectoCadena[8].replaceAll(",", ".")));
                        facturaBO.setDescuentInternet(Double.parseDouble(vectoCadena[9].replaceAll(",", ".")));
                        facturaBO.setPrecioUnitario(Double.parseDouble(vectoCadena[10].replaceAll(",", ".")));
                        facturaBO.setIVA(IVA);
                        facturaBO.setTotalNetoReng(rentNeto);
                        facturaBO.setGaceta(vectoCadena[13]);
                        facturaBO.setNumPedidoArti(Integer.parseInt(vectoCadena[14]));
                        facturaBO.setCodMateriDrolanc(vectoCadena[15]);
//                        facturaBO.setOferta1(vectoCadena[16]);
                        lista.add(facturaBO);
                    }
//                    inventarioCaracasBO.setPrecio1(Double.parseDouble(vectoCadena[4]));
//                    inventarioCaracasBO.setDecimal(Double.parseDouble(vectoCadena[5]));
//                    inventarioCaracasBO.setPrecio2(Double.parseDouble(vectoCadena[6]) / 33);
//                    inventarioCaracasBO.setCantidad(Integer.parseInt(vectoCadena[7]));
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<FacturaVentaBO> ListaleerArchivoFActuraEncabezado() {
        ArrayList<FacturaVentaBO> lista = new ArrayList<FacturaVentaBO>();

        String rutaDelArchivo = "C:\\DescargasArchivoFTP\\Factura\\1303994179730513337418919.txt";
        String linea = null, contenido;
        File doc_li = new File(rutaDelArchivo);
        double IVA = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo));

            int i = 0;
            while ((linea = br.readLine()) != null) {

                contenido = linea;

                String[] vectoCadena = linea.split(";");
                System.out.println("Contenido " + vectoCadena[0]);
                if (vectoCadena[0].equals("S")) {
                    System.out.println("Entrando a lacondicion ");
                    FacturaVentaBO facturaVentaBO = new FacturaVentaBO();
                    facturaVentaBO.setTotalOtorgadoDescuentoInternet(Double.parseDouble(vectoCadena[1].replaceAll(",", ".")));
                    facturaVentaBO.setTotalDescuentoespecial(Double.parseDouble(vectoCadena[2].replaceAll(",", ".")));
                    facturaVentaBO.setNetoFactura(Double.parseDouble(vectoCadena[2].replaceAll(",", ".")));
//                    facturaVentaBO.setBaseImponible(Double.parseDouble(vectoCadena[3].replaceAll(",", ".")));
                    facturaVentaBO.setIvaPorc(Double.parseDouble(vectoCadena[4].replaceAll(",", ".")));
                    facturaVentaBO.setTotalIVA(Double.parseDouble(vectoCadena[5].replaceAll(",", ".")));
                    facturaVentaBO.setTotalFactura(Double.parseDouble(vectoCadena[6].replaceAll(",", ".")));
//                    facturaVentaBO.setDescuentoProntoPago(Double.parseDouble(vectoCadena[7].replaceAll(",", ".")));
                    facturaVentaBO.setTotalProntoPago(Double.parseDouble(vectoCadena[8].replaceAll(",", ".")));
                    facturaVentaBO.setFechaFactura(vectoCadena[9].replaceAll(",", "."));
                    facturaVentaBO.setNroBultos(Integer.parseInt(vectoCadena[10].replaceAll(",", ".")));
                    facturaVentaBO.setTotalUnidades(Double.parseDouble(vectoCadena[11].replaceAll(",", ".")));
                    facturaVentaBO.setTotalRenglones(Double.parseDouble(vectoCadena[12].replaceAll(",", ".")));
                    facturaVentaBO.setProductoPrecioMarcadosBsF(Double.parseDouble(vectoCadena[13].replaceAll(",", ".")));
                    facturaVentaBO.setBaseExentoIva(Double.parseDouble(vectoCadena[14].replaceAll(",", ".")));
//                    facturaVentaBO.setProductoSinPrecioMarcadosBsF(Double.parseDouble(vectoCadena[15].replaceAll(",", ".")));
                    lista.add(facturaVentaBO);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo para leer los archivos que se encuentra en la Carpeta de factura 
    public ArrayList<ListaArchivosBO> leerNombreArchivos(String rutaCarpeta) {
        ArrayList<ListaArchivosBO> listaArchivos = new ArrayList<>();

        File carpeta = new File(rutaCarpeta);
        File[] archivos = carpeta.listFiles();

        for (File archivo : archivos) {

            File file = new File(rutaCarpeta + "\\" + archivo.getName());
            long lastModified = file.lastModified();

//            Instant instant = new Date(lastModified).toInstant();
            Date fech = new Date(lastModified);
            System.out.println(":::: " + fech);

            ListaArchivosBO archivosBO = new ListaArchivosBO();
            archivosBO.setNombreArchivo(archivo.getName());
            archivosBO.setFechaModificado("1222232");

            listaArchivos.add(archivosBO);

        }
        return listaArchivos;
    }

    // lista los nombres de los archivos del FTP  Factura
    public ArrayList<ListaArchivosBO> listarNameArchivos() {
        ArrayList<ListaArchivosBO> listaArchivos = new ArrayList<ListaArchivosBO>();
        String server = "ftp.drolanca.com";
        int port = 21;
        String username = "18919";
        String password = "18919";
        String remotePath = "/Facturas";
        String localPath = "C:\\Users\\admin\\Documents\\ProyectFTP\\DESCARGAS\\";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();

            FTPFile[] files = ftpClient.listFiles(remotePath);

            for (FTPFile file : files) {
                ListaArchivosBO archivoBO = new ListaArchivosBO();
//                if (file.isFile()) {
//                    executorService.submit(() -> {

//                String localFilePath = "C:\\DescargasArchivoFTP\\" + file.getName();
                archivoBO.setNombreArchivo(file.getName());
                archivoBO.setFechaModificado(file.getTimestampInstant().toString());

//                    });
//                }
                listaArchivos.add(archivoBO);
            }
            System.out.println("Listado de archivos completado.");

        } catch (IOException e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(new JFrame(), "Connection timed out: connect", "Software", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listaArchivos;
    }

    public int validarConexionFTP(String servidor ,int puerto , String usuario , String password ) {
        int resultado = 0;
        FTPClient ftpClient = new FTPClient();

        try {
            // Set the connection parameters
            ftpClient.connect(servidor, puerto);

            ftpClient.login(usuario, password);

            // Check if the connection was successful
            if (ftpClient.isConnected()) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }

            // Close the connection
            ftpClient.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(LeerArchivoFtp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static void main(String args[]) {

//            String str = "1.605,80";
//            DecimalFormat df = new DecimalFormat("###,###.##");
//            Double d = df.parse(str).doubleValue();
//
//            System.out.println("Leer Datos" + d);
//        String str = "1.605,80";
//        str.replaceAll(".", ",");
//        System.out.println("PRIMER PASO" + str );
//Double d = Double.parseDouble(str);
//  System.out.println("VALORRR" + d );


        LeerArchivoFtp lee = new LeerArchivoFtp();
       
        
//        lee.validarConexionFTP("ftp.drolanca.com2", 21, "wewe", "18919") ;
        ArrayList<ListaArchivosBO> lista = lee.leerNombreArchivos("C:\\DescargasArchivoFTP\\");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("nombres  " + lista.get(i).getNombreArchivo());
        }
        
        
//        System.out.println("tamaño "+ lista.size() );
//        ArrayList<FacturaRenglonBO> lista = lee.ListaleerArchivoFacturaRenglon("", "todos");
//            for (int i = 0; i <= lista.size(); i++) {
//                System.out.println("Base imponible :: " + lista.get(0).getTotalFactura());
//            }
//
//        Double numero = 2.3;
    }
}
