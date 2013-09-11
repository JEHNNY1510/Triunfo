/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author david
 */
@Named(value = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {

      public String ir_a_Gestion_Roles() {
        System.out.println("********************Llegue a ir_a_Gestion_Roles");
        return "GestionRoles";
    }

    public String ir_a_Gestion_Categorias() {
        return "GestionCategorias";
    }

    public String ir_a_Gestion_Unidad() {
        return "GestionUnidad";
    }
    
      public String ir_a_Gestion_TipoPersona() {
        return "GestionarTipoPersona";
    }
       public String ir_a_Gestion_DetalleCompra() {
        return "GestionarDetalleCompra";
    }
        public String ir_a_Gestion_DetalleVenta(){
        return "GestionarDetalleVenta";
    }
    public NavegacionBean() {
    }
}
