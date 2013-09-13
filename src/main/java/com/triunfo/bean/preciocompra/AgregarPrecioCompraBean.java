/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.preciocompra;

import com.triunfo.dao.PreciocompraDAO;
import com.triunfo.entidades.Tblpreciocompra;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarPrecioCompraBean")
@SessionScoped
public class AgregarPrecioCompraBean implements Serializable {

    private Boolean abrirGuardado;
    private Tblpreciocompra precioc;
    
    @Inject
    PreciocompraDAO preciocompraDAO;
    
    public void cargarGuardado(){
        abrirGuardado=true;
        System.out.println("el valor de la variable quedo en "+abrirGuardado);
        Utilidad.actualizarElemento("dlgagregarPrecioCompra");
        Utilidad.actualizarElemento("tblpreciocompra");
    }
    
    public void guardarPrecioCompra(){
        
        if (precioc.getFecha().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion precio compra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + precioc.getFecha());
            if (preciocompraDAO.insertarPreciocompra(precioc)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "precio: " + precioc.getFecha()+ ". Guardado Correctamente.");
                precioc = new Tblpreciocompra();
                Utilidad.actualizarElemento("txtdescripcionfecha");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "precio: " + precioc.getFecha()+ ". No pudo ser guardado.");
            }
        }
        
         if (precioc.getPrecio().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion precio compra Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + precioc.getPrecio());
            if (preciocompraDAO.insertarPreciocompra(precioc)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "precio: " + precioc.getPrecio()+ ". Guardado Correctamente.");
                precioc = new Tblpreciocompra();
                Utilidad.actualizarElemento("txtdescripcionprecio");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "precio: " + precioc.getPrecio()+ ". No pudo ser guardado.");
            }
        }
        
        
    }
    public void cerrarGuardado(){
        precioc = new Tblpreciocompra();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregarPrecioCompra");
    }
   
    public AgregarPrecioCompraBean() {
         abrirGuardado=false;
        precioc = new Tblpreciocompra();
    }

    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tblpreciocompra getPrecioc() {
        return precioc;
    }

    public void setPrecioc(Tblpreciocompra precioc) {
        this.precioc = precioc;
    }

    
}
