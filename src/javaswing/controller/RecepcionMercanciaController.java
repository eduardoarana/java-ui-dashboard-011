/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.controller;

import Modelo.ModeloTablaRecepcionMercancia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javaswigdev.Beans.InventarioBO;
import javaswingdev.form.VistaFacturaCompras;

/**
 *
 * @author eArana
 */
public class RecepcionMercanciaController implements ActionListener, KeyListener {

    VistaFacturaCompras vista;
    ModeloTablaRecepcionMercancia modeloTablaRecepcionMercancia = new ModeloTablaRecepcionMercancia();

    public RecepcionMercanciaController(VistaFacturaCompras vista) {
        this.vista = vista;

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource().equals(this.vista.btnAgregar)) {
            // modeloTablaRecepcionMercancia.refrescarTable();
            System.out.println("javaswing.controller.RecepcionMercanciaController.actionPerformed()");
            //  modeloTablaRecepcionMercancia.refrescarTable();
//            InventarioBO invetaInventarioCaracasBO = new InventarioBO();
//            invetaInventarioCaracasBO.setItem(1);
//            invetaInventarioCaracasBO.setAlmacen("");
//            invetaInventarioCaracasBO.setCantRec(0);
//            invetaInventarioCaracasBO.setUnidad("");
//            invetaInventarioCaracasBO.setCantidad(0);
//            invetaInventarioCaracasBO.setPrecio1(0);
//            invetaInventarioCaracasBO.setPrecio2(0);
//            invetaInventarioCaracasBO.setArticuloDescripcion("");
//            invetaInventarioCaracasBO.setArticuloDescripcion("Descripcion");
//            invetaInventarioCaracasBO.setArticuloDescripcion("Descripcion");
//            invetaInventarioCaracasBO.setArticuloDescripcion("Descripcion");

//            ajustes.setArt_des("");
//            ajustes.setModelo("");
//            ajustes.setCo_alma("");
//            ajustes.setCo_uni("");
//            ajustes.setCost_unit("0.0");
//            ajustes.setCantidad("0.0");
            // ajustes.setCostoTotal(0.0);//tipo Double
            //   modeloTablaRecepcionMercancia.addRow(invetaInventarioCaracasBO);
            //  modeloTablaRecepcionMercancia.refrescarTable();
//            vista.jtablePrincipalMercancia.setModel(modeloTablaRecepcionMercancia);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //To change body of generated methods, choose Tools | Templates.
//         if (vista.txtCodCliente == ke.getSource()) {
//            
//            if (ke.getKeyCode() == KeyEvent.VK_F2) {
//                 vista.jDialogCliente.setVisible(true);
//                vista.jDialogCliente.setSize(472, 358);
//                vista.jDialogCliente.setLocationRelativeTo(null);
//            }
//         
//         }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //To change body of generated methods, choose Tools | Templates.

    }

}
