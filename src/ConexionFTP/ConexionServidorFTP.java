package ConexionFTP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
//import org.xbib.io.ftp.client.FTPClient;
//import org.xbib.io.ftp.client.FTPFile;
//import org.xbib.io.ftp.client.FTPReply;
import sun.misc.IOUtils;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;

/**
 * Ejercicio 250: Establecer conexión a un servidor FTP usando Apache Commons
 * Net.
 *
 * @author John Ortiz Ordoñez
 */
public class ConexionServidorFTP {

    public static void conectarFTP(String cadena) {
        // estas son las credenciales 
        String server = "ftp.drolanca.com";
        int port = 21;
        String user = "18919";
        String pass = "18919";
        String remoteFilePath = "/RFacturas/" + cadena;
        String localFilePath = "C:\\DescargasArchivoFTP\\" + cadena;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            OutputStream outputStream = new FileOutputStream(localFilePath);
            boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);
          

            if (success) {
                System.out.println("El archivo se ha Descargado Exitosamente....");

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void leerArchivoFTP() {
//C:\DescargasArchivoFTP\Factura
        String rutaDelArchivo = "C:\\DescargasArchivoFTP\\Factura\\1304191788730529981918919.TXT";
        String linea = null, contenido;
        File doc_li = new File(rutaDelArchivo);

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo));

            while ((linea = br.readLine()) != null) {

                contenido = linea;
//                System.out.println(contenido);
                String[] vectoCadena = linea.split(";");
                System.out.println(" " + vectoCadena[0] + " " + vectoCadena[1]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Archivos> listarNameArchivos(){
        ArrayList<Archivos> listaArchivos = new ArrayList<Archivos>();
        String server = "ftp.drolanca.com";
        int port = 21;
        String username = "18919";
        String password = "18919";
        String remotePath = "/RFacturas";
        String localPath = "C:\\Users\\admin\\Documents\\ProyectFTP\\DESCARGAS\\";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();

            FTPFile[] files = ftpClient.listFiles(remotePath);

            for (FTPFile file : files) {
                Archivos archivoBO = new Archivos();
//                if (file.isFile()) {
//                    executorService.submit(() -> {

                String localFilePath = "C:\\DescargasArchivoFTP\\" + file.getName();
                archivoBO.setNombre(file.getName());

//                    });
//                }
                listaArchivos.add(archivoBO);
            }
            System.out.println("Listado de archivos completado.");

        } catch (IOException e) {
            e.printStackTrace();
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
    

    public static void main(String[] args) throws IOException {
        ConexionServidorFTP c = new ConexionServidorFTP();
         ArrayList<Archivos> lista = new ArrayList<Archivos>();
        Archivos bo = new Archivos();
        bo.setNombre("1304205741730531098418919.TXT");
        bo.setNombre("1304205277730530972518919.TXT");
       
        lista.add(bo);
        System.out.println("TAMAÑO" +lista.size());
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.println("" + lista.get(i).getNombre());
            c.conectarFTP(lista.get(i).getNombre());
        }

//        c.leerArchivoFTP();
//// Define the FTP server information
//        String host = "ftp.drolanca.com";
//        int port = 21;
//        String user = "18919";
//        String password = "18919";
//
//        // Create a new FTPClient
//        FTPClient ftpClient = new FTPClient();
//
//        // Connect to the FTP server
//        ftpClient.connect(host, port);
//
//        // Login to the FTP server
//        ftpClient.login(user, password);
//
//        // Change to the target directory
//        ftpClient.changeWorkingDirectory("/Factura/");
//
//        // Get the list of files in the folder
//        FTPFile[] files = ftpClient.listFiles();
//
//        // Create a directory to store the downloaded files
//        File localFolder = new File("C:\\DescargasArchivoFTP\\Folder");
//        localFolder.mkdir();
//
//        // Download each file
//        for (FTPFile file : files) {
//            // Get the file name
//            String fileName = file.getName();
//
//            // Download the file
////            File localFile = new File(localFolder, fileName);
////            ftpClient.retrieveFile(fileName,localFile);
//            
//            OutputStream outputStream = new FileOutputStream(localFolder);
//             ftpClient.retrieveFile("Archivosee.txt", outputStream);
//            
//        }
//
//        // Disconnect from the FTP server
//        ftpClient.disconnect();
    }
}

// Tenia el internet desconectado  
