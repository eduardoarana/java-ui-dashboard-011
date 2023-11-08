/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionFTP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author admin
 */
public class SubirArchivo {
 public static void main(String[] args) {
		FTPClient cliente=new FTPClient();
		String servidor="ftp.drolanca.com";
		String user="18919";
		String pasw="18919";
		
		try {
			System.out.println("Conectandose a "+servidor);
			cliente.connect(servidor);
			cliente.enterLocalPassiveMode();
			boolean login=cliente.login(user, pasw);
			
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			String direc="/NUEVODIREC";
			
			if(login) {
				System.out.println("Login correcto");
				
				if(!cliente.changeWorkingDirectory(direc)) {
					String directorio="subidas";
					if(cliente.makeDirectory(directorio)) {
						System.out.println("Directorio creado");
						cliente.changeWorkingDirectory(directorio);
					}else {
						System.out.println("No se ha podido crear el directorio");
						System.exit(0);
					}
				}
				
				System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
				JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				String ruta="";
				String archivo="";
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					//cogemos su ruta y su nombre
					ruta=selectedFile.getAbsolutePath();
					archivo=selectedFile.getName();
				}
				
				BufferedInputStream in=new BufferedInputStream(new FileInputStream(ruta));
				cliente.storeFile(archivo,in);
				in.close();
				cliente.logout();
				cliente.disconnect();
				
			}else
				System.out.println("Login incorrecto");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
                
	}
}
