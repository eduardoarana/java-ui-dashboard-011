/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionFTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class DownloadFTPFiles {

    public static void main(String[] args) throws IOException {
        // Establecer los datos de conexión FTP
        String host = "ftp.drolanca.com";
        int port = 21;
        String username = "18919";
        String password = "18919";
        String remotePath = "/RFacturas";
        String localPath = "C:\\Users\\admin\\Documents\\ProyectFTP\\DESCARGAS\\wewe";

        // Crear un cliente FTP
        FTPClient ftpClient = new FTPClient();

        // Conectarse al servidor FTP
        ftpClient.connect(host, port);

        // Iniciar sesión en el servidor FTP
        ftpClient.login(username, password);

        // Cambiar al directorio remoto
        ftpClient.changeWorkingDirectory(remotePath);

        // Listar los archivos y carpetas en el directorio remoto
        FTPFile[] files = ftpClient.listFiles();

        // Descargar cada archivo
        for (FTPFile file : files) {
            if (file.isFile()) {
                // Descargar archivo
                String fileName = file.getName();
                File localFile = new File(localPath + "/" + fileName);
                InputStream inputStream = ftpClient.retrieveFileStream(fileName);
                FileOutputStream outputStream = new FileOutputStream(localFile);
                byte[] bytes = new byte[1024];
                int count;
                while ((count = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, count);
                }
                inputStream.close();
                outputStream.close();
            }
        }
        // Cerrar la conexión FTP
        ftpClient.disconnect();
    }
}