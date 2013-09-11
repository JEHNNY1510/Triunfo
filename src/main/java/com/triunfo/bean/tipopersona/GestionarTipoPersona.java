/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.tipopersona;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "gestionarTipoPersona")
@SessionScoped
public class GestionarTipoPersona implements Serializable {

    /**
     * Creates a new instance of GestionarTipoPersona
     */
    public GestionarTipoPersona() {
    }
}
