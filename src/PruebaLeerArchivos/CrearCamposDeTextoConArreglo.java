/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaLeerArchivos;

import javax.swing.*;
/**
 *
 * @author admin
 */
public class CrearCamposDeTextoConArreglo {

    private static JTextField[] txtNombres;
    
    
    
     public static void main(String[] args) {
        // Definimos el arreglo
        String[] nombres = {"Juan", "Pedro", "María"};

        // Creamos los campos de texto
        JFrame frame = new JFrame("Crear campos de texto con un arreglo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtNombre1 = new JTextField(20);
        JTextField txtNombre2 = new JTextField(20);
        JTextField txtNombre3 = new JTextField(20);

        // Agregamos los campos de texto al formulario
        frame.add(txtNombre1);
        frame.add(txtNombre2);
        frame.add(txtNombre3);

        // Asigna los valores del arreglo a los campos de texto
        for (int i = 0; i < nombres.length; i++) {
            // Asigna el valor del arreglo al campo de texto
            txtNombres[i].setText(nombres[i]);
        }

        // Mostramos el formulario
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
