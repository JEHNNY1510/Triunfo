/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.categorias;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "catergoriaBean")
@SessionScoped
public class CategoriaBean implements Serializable {

    /**
     * Creates a new instance of CatergoriaBean
     */
    public CategoriaBean() {
    }
}
