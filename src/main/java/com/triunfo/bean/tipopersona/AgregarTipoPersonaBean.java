/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.tipopersona;

import com.triunfo.dao.TipopersonaDAO;
import com.triunfo.entidades.Tbltipopersona;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarTipoPersonaBean")
@SessionScoped
public class AgregarTipoPersonaBean implements Serializable {

     private Boolean abrirGuardado;
    private Tbltipopersona tipop;
    
    @Inject
    TipopersonaDAO tipopersonaDAO;
    
 public void cargarGuardado(){
        abrirGuardado=true;
        Utilidad.actualizarElemento("dlgagregarTipoPersona");
        Utilidad.actualizarElemento("tbltipopersona");
        }
 
  public void guardarTipoPersona(){
        
        if (tipop.getDescripcion().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion tipopersona Requerida.");
        } else {
             System.out.println("lo que vamos a guardar es lo siguiente-->>>" + tipop.getDescripcion());
               if (tipopersonaDAO.insertarTipopersona(tipop)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "tipo perosna : " + tipop.getDescripcion() + ". Guardado Correctamente.");
                tipop = new Tbltipopersona();
                Utilidad.actualizarElemento("txtdescripcionTipoPersona");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "tipo persona: " + tipop.getDescripcion() + ". No pudo ser guardado.");
            }
        }
        
        
    }
  
  
   public void cerrarGuardado(){
        tipop = new Tbltipopersona();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregarTipoPersona");
    }
    public AgregarTipoPersonaBean() {
        abrirGuardado=false;
        tipop = new Tbltipopersona();
    }


    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tbltipopersona getTipop() {
        return tipop;
    }

    public void setTipop(Tbltipopersona tipop) {
        this.tipop = tipop;
    }
    
}
