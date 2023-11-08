/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionFTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AsyncFTPListFiles {

//    ConexionServidorFTP c = new ConexionServidorFTP(); ;
    public AsyncFTPListFiles() {

    }

    public static void main(String[] args) {

        AsyncFTPListFiles m = new AsyncFTPListFiles();
        ArrayList<Archivos> lista = m.listarNameArchivos();
        System.out.println("Cantidad de Archivo " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            ConexionServidorFTP.conectarFTP(m.listarNameArchivos().get(i).getNombre());
            //System.out.println("lista "+ lista.get(i).getNombre()); 
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
}
