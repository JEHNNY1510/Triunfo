/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.detallecompra;

import com.triunfo.dao.DetallecompraDAO;
import com.triunfo.entidades.Tbldetallecompra;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarDetalleCompra")
@SessionScoped
public class AgregarDetalleCompra implements Serializable {

    private Boolean abrirGuardado;
    private Tbldetallecompra detallec;
    
    @Inject
     DetallecompraDAO detallacompraDAO;
    
     public void cargarGuardado(){
     
        abrirGuardado=true;
        System.out.println("el valor de la variable quedo en "+abrirGuardado);
        Utilidad.actualizarElemento("dlgagregarDetalleCompra");
        Utilidad.actualizarElemento("tbldetallecompra");
    }
      public void guardarRol(){
        
        if (detallec.getTblproducto().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion DetalleCompra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallec.getTblproducto());
            if (detallacompraDAO.insertarDetallecompra(detallec)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "DetalleCompra: " + detallec.getTblproducto()+ ". Guardado Correctamente.");
                detallec = new Tbldetallecompra();
                Utilidad.actualizarElemento("txtproducto");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle Compra: " + detallec.getTblproducto()+ ". No pudo ser guardado.");
            }
        }
        
        if (detallec.getTblcompra().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion DetalleCompra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallec.getTblcompra());
            if (detallacompraDAO.insertarDetallecompra(detallec)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "DetalleCompra: " + detallec.getTblcompra()+ ". Guardado Correctamente.");
                detallec = new Tbldetallecompra();
                Utilidad.actualizarElemento("txtcompra");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle Compra: " + detallec.getTblcompra()+ ". No pudo ser guardado.");
            }
        }
         if (detallec.getSubtotal().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion DetalleCompra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallec.getSubtotal());
            if (detallacompraDAO.insertarDetallecompra(detallec)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "DetalleCompra: " + detallec.getSubtotal()+ ". Guardado Correctamente.");
                detallec = new Tbldetallecompra();
                Utilidad.actualizarElemento("txtsubtotal");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle Compra: " + detallec.getSubtotal()+ ". No pudo ser guardado.");
            }
               
        }
        
    }
     
    public AgregarDetalleCompra() {
    }
}
