/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.preciocompra;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarPrecioCompraBean")
@SessionScoped
public class GestionarPrecioCompraBean implements Serializable {

    /**
     * Creates a new instance of GestionarPrecioCompraBean
     */
    public GestionarPrecioCompraBean() {
    }
}
