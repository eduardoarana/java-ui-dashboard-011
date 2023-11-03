/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.controller;

import Modelo.LoginModel;
//import Vista.Login;
//import Vista.VistaEmpresa;
//import Vista.Vistaprincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javaswingdev.main.Main;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import loginform.VistaEmpresa;

/**
 *
 * @author earana
 */
public class LoginController implements ActionListener {

    LoginModel modelo;
    loginform.Login vista;
//    Vista.Vistaprincipal  vistaprincipal;

    public LoginController(loginform.Login vista) {
        this.vista = vista;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int resultado = 0;

        System.out.println("Controller.LoginController.actionPerformed()");
        if (event.getSource() == this.vista.btnAceptar) {
            try {
                modelo = new LoginModel();
                String contrasena = new String(vista.txtpassword.getPassword());

                resultado = modelo.pAutenticarUsuario(vista.txtusername.getText(), contrasena);
                System.out.println("RESULTADO" + resultado);
                System.out.println("Usuario " + vista.txtusername.getText() + " Contraseña " + contrasena);

                if (vista.txtusername.getText().equals("profit") && contrasena.equals("profit")) {
//                    vistaprincipal = new Vistaprincipal();
//                    vistaprincipal.setVisible(true);
//                    VistaEmpresa empresa = new VistaEmpresa();
//                Vistaprincipal.tempUsuario=vista.txtusername.getText();
                    Main principal = new Main();
                    principal.setVisible(true);
//                empresa.setVisible(true);
//                empresa.setLocationRelativeTo(null);

                    this.vista.dispose();
                } else {
//                  vista.lblmenValidacion.setVisible(true);
                    JOptionPane.showMessageDialog(new JFrame(), "Warning", "el usuario no existe", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Warning", e.toString(), JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
