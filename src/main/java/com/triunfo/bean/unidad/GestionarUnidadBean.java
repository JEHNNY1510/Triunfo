/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.unidad;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarUnidadBean")
@SessionScoped
public class GestionarUnidadBean implements Serializable {

    /**
     * Creates a new instance of GestionarUnidadBean
     */
    public GestionarUnidadBean() {
    }
}
