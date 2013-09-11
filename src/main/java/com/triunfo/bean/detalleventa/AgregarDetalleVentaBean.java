/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.detalleventa;

import com.triunfo.dao.DetalleventaDAO;
import com.triunfo.entidades.Tbldetalleventa;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarDetalleVentaBean")
@SessionScoped
public class AgregarDetalleVentaBean implements Serializable {

    private Boolean abrirGuardado;
    private Tbldetalleventa detallev;
    
    @Inject
    DetalleventaDAO detalleventaDAO;
    
    public void cargarGuardado(){
        abrirGuardado=true;
        System.out.println("el valor de la variable quedo en "+abrirGuardado);
        Utilidad.actualizarElemento("dlgagregardetalleventa");
        Utilidad.actualizarElemento("tbldetalleventa");
        
    }
     public void guardarDetalleVenta(){
        
        if (detallev.getTblproducto().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion Detalle Venta Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallev.getTblproducto());
            if (detalleventaDAO.insertarDetalleventa(detallev)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "Detalle Venta: " + detallev.getTblproducto()+ ". Guardado Correctamente.");
                detallev = new Tbldetalleventa();
                Utilidad.actualizarElemento("txtproducto");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle Venta: " + detallev.getTblproducto()+ ". No pudo ser guardado.");
            }
        }
        
        if (detallev.getTblventa().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion DetalleCompra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallev.getTblventa());
            if (detalleventaDAO.insertarDetalleventa(detallev)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "DetalleCompra: " + detallev.getTblventa()+ ". Guardado Correctamente.");
                detallev = new Tbldetalleventa();
                Utilidad.actualizarElemento("txtcompra");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle Compra: " + detallev.getTblventa()+ ". No pudo ser guardado.");
            }
        }
         if (detallev.getSubtotal().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion DetalleCompra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + detallev.getSubtotal());
            if (detalleventaDAO.insertarDetalleventa(detallev)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "Detalle Venta: " + detallev.getSubtotal()+ ". Guardado Correctamente.");
                detallev = new Tbldetalleventa();
                Utilidad.actualizarElemento("txtsubtotal");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Detalle venta: " + detallev.getSubtotal()+ ". No pudo ser guardado.");
            }
               
        }
        
    } public void cerrarGuardado(){
        detallev = new Tbldetalleventa();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregardetalleventa");
    }
    
    public AgregarDetalleVentaBean() {
     abrirGuardado=false;
        detallev = new Tbldetalleventa();
    }

    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tbldetalleventa getDetallev() {
        return detallev;
    }

    public void setDetallev(Tbldetalleventa detallev) {
        this.detallev = detallev;
    }
    
    }

