/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.utilitario;

/**
 *
 * @author admin
 */
public class ConfiguracionDeArchivosFTP {

    public ConfiguracionDeArchivosFTP() {

    }

    public void lerrConfiguracionDeArchivos() {

        String cadena = "Hola, mundo";

        char[] letras = cadena.toCharArray();

        for (char letra : letras) {
            System.out.println(letra);
        }
    }
    
    public static void main(String args[]){
        ConfiguracionDeArchivosFTP f = new ConfiguracionDeArchivosFTP();
        f.lerrConfiguracionDeArchivos();
    }
}
