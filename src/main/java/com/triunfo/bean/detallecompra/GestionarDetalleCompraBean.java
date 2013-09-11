/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.detallecompra;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarDetalleCompraBean")
@SessionScoped
public class GestionarDetalleCompraBean implements Serializable {

    /**
     * Creates a new instance of GestionarDetalleCompraBean
     */
    public GestionarDetalleCompraBean() {
    }
}
