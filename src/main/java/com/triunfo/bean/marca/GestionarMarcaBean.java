/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.marca;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarMarcaBean")
@SessionScoped
public class GestionarMarcaBean implements Serializable {

    /**
     * Creates a new instance of GestionarMarcaBean
     */
    public GestionarMarcaBean() {
    }
}
