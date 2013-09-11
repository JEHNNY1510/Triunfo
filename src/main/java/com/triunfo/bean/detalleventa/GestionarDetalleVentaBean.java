/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.detalleventa;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarDetalleVentaBean")
@SessionScoped
public class GestionarDetalleVentaBean implements Serializable {

    /**
     * Creates a new instance of GestionarDetalleVentaBean
     */
    public GestionarDetalleVentaBean() {
    }
}
