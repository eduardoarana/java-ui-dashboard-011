/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaLeerArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LeerMultiplesArchivos {

    public LeerMultiplesArchivos() {
    }

    public static void main(String args[]) throws FileNotFoundException, IOException {

     
       
      
        
        ArrayList<File> listaArchivos = new ArrayList<>();
 
       listaArchivos.add(new File("C:\\DescargasArchivoFTP\\Factura\\1304191788730529981918919 - copia (2).txt"));
        listaArchivos.add(new File("C:\\DescargasArchivoFTP\\Factura\\1304191788730529981918919 - copia (3).txt"));
        listaArchivos.add(new File("C:\\DescargasArchivoFTP\\Factura\\1304191788730529981918919 - copia (4).txt"));
        for (int i = 0; i < listaArchivos.size(); i++) {
            // Abrir el archivo
            FileReader fr = new FileReader(listaArchivos.get(i).getAbsoluteFile());

            // Crear un lector de datos
            BufferedReader br = new BufferedReader(fr);

            // Leer el contenido del archivo
            String line;
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // Cerrar el archivo
            br.close();
        }
        // Iterar sobre cada archivo
//        for (File file : files) {
//
//            // Abrir el archivo
//            FileReader fr = new FileReader(file);
//
//            // Crear un lector de datos
//            BufferedReader br = new BufferedReader(fr);
//
//            // Leer el contenido del archivo
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Cerrar el archivo
//            br.close();
//        }
    }
}
