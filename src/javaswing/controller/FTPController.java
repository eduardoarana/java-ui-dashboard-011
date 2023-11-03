/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.controller;

import Modelo.FTPModelo;
import Modelo.ModeloTablaFTP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javaswigdev.Beans.SaFTPBO;
import javaswingdev.form.VistaFTP;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eArana
 */
public class FTPController implements ActionListener, MouseListener {

    VistaFTP vista;
    ModeloTablaFTP modeloTablaFTP = new ModeloTablaFTP();
    FTPModelo modelo;
    String idEliminar = "";
    ArrayList<SaFTPBO> lista = new ArrayList<SaFTPBO>();

    public FTPController(VistaFTP vista) {
        this.vista = vista;
        modelo = new FTPModelo();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int resultado = 0;
        if (event.getSource() == this.vista.btnGuardar) {

            if(vista.txtServidor.getText().isEmpty() || vista.txtUsuario.getText().isEmpty()||
                    vista.txtPasswor.getPassword().length==0 || vista.txtDirectorioFactura.getText().isEmpty() || vista.txtDirectorioCatalogo.getText().isEmpty()
                    || vista.txtDirectorioPedidos.getText().isEmpty()
                    ){
                 JOptionPane.showMessageDialog(new JFrame(), "Los Campos no pueden estar vacios", "Software", JOptionPane.INFORMATION_MESSAGE);
            return ;
            }
            resultado = modelo.pInsertarFTP(
                    vista.txtServidor.getText(),
                    vista.txtPuerto.getText(),
                    vista.txtUsuario.getText(),
                    vista.txtPasswor.getText(),
                    vista.txtDirectorioFactura.getText(),
                    vista.txtDirectorioPedidos.getText(),
                    vista.txtDirectorioCatalogo.getText(),
                    "Activado"
            );
            if (resultado != 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Se ha Guardado Satisfactoriamente", "Software", JOptionPane.INFORMATION_MESSAGE);
                vista.settearCampo();
                cargarDatosFTP();
            }
        } else if (event.getSource() == this.vista.btnConectar) {
            if (vista.txtServidor.getText().isEmpty() || vista.txtUsuario.getText().isEmpty()
                    || vista.txtPuerto.getText().isEmpty()
                    || vista.txtPasswor.getPassword().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "No  puede estar vacio ", "Software", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } else if (event.getSource() == this.vista.btnNuevo) {
            vista.settearCampo();
        } else if (event.getSource() == this.vista.btnEliminar) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                resultado = modelo.pEliminarFTP(idEliminar
                );
                if (resultado != 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Se ha Eliminado Satisfactoriamente", "Software", JOptionPane.ERROR_MESSAGE);
                    vista.settearCampo();
                    cargarDatosFTP();
                }
            }
        }
    }

    public void cargarDatosFTP() {
//        exec pObtenerListadoDatos 'demoa' ,'saFTP' , 'nameServidor','','2'
        lista = modelo.pObtenerListadoDatos("demoa", "saFTP", "nameServidor", "", "2");
        modeloTablaFTP.setlista(lista);
        vista.jtablaFTP.setModel(modeloTablaFTP);
        modeloTablaFTP.refrescarTable();
        // setCantidadListRengl(lista.size());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int selection = vista.jtablaFTP.getSelectedRow();
        System.out.println("click" + selection);
        idEliminar = vista.jtablaFTP.getValueAt(selection, 0).toString();
        lista = modelo.pObtenerListadoDatos(
                "demoa",
                "saFTP",
                "id",
                idEliminar,
                "3");
        vista.txtUsuario.setText(lista.get(0).getUsuario());
        vista.txtPuerto.setText(lista.get(0).getPuerto());
        vista.txtServidor.setText(lista.get(0).getNameServidor());
        vista.txtPasswor.setText(lista.get(0).getPasswor());
        vista.txtDirectorioFactura.setText(lista.get(0).getRutaDirectorioFactura());
        vista.txtDirectorioPedidos.setText(lista.get(0).getRutaDirectorioPedidos());
        vista.txtDirectorioCatalogo.setText(lista.get(0).getRutaDirectorioCatalogo());
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
