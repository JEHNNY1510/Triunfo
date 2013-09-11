/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.unidad;

import com.triunfo.dao.UnidadDAO;
import com.triunfo.entidades.Tblunidad;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarUnidadBean")
@SessionScoped
public class AgregarUnidadBean implements Serializable {

  
    private Boolean abrirGuardado;
    private  Tblunidad unidad;
     @Inject
     UnidadDAO unidadDAO;
    
     public void cargarGuardado(){
        abrirGuardado=true;
        Utilidad.actualizarElemento("dlgagregarUnidad");
        Utilidad.actualizarElemento("tblunidad");
    }
      public void guardarUnidad(){
        
        if (unidad.getUnidades().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion Unidad Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + unidad.getUnidades());
            if (unidadDAO.insertarUnidad(unidad)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "Unidad: " + unidad.getUnidades()+ ". Guardado Correctamente.");
                unidad = new Tblunidad();
                Utilidad.actualizarElemento("txtdescripcionunidad");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Unidad: " + unidad.getUnidades()+ ". No pudo ser guardado.");
            }
        }
        
        
    }
       public void cerrarGuardado(){
        unidad = new Tblunidad();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregarUnidad");
    }
   
    public AgregarUnidadBean() {
          abrirGuardado=false;
        unidad = new Tblunidad();
    }

    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tblunidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Tblunidad unidad) {
        this.unidad = unidad;
    }
    
}
