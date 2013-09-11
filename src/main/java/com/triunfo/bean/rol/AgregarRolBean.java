/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.rol;

import com.triunfo.dao.RolDAO;
import com.triunfo.entidades.Tblrol;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "agregarRolBean")
@SessionScoped
public class AgregarRolBean implements Serializable {
    
    private Boolean abrirGuardado;
    private Tblrol rol;
    
    @Inject
    RolDAO rolDAO;
    

    public void cargarGuardado(){
        System.out.println("Llegando a cargar el guardado");
        abrirGuardado=true;
        System.out.println("el valor de la variable quedo en "+abrirGuardado);
        Utilidad.actualizarElemento("dlgagregarRol");
        Utilidad.actualizarElemento("tblroles");
    }
    
    public void guardarRol(){
        
        if (rol.getDescripcion().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion Rol Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + rol.getDescripcion());
            if (rolDAO.insertarRol(rol)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "Rol: " + rol.getDescripcion() + ". Guardado Correctamente.");
                rol = new Tblrol();
                Utilidad.actualizarElemento("txtdescripcionrol");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "Rol: " + rol.getDescripcion() + ". No pudo ser guardado.");
            }
        }
        
        
        
    }
    
    public void cerrarGuardado(){
        rol = new Tblrol();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregarRol");
    }
   
    public AgregarRolBean() {
        abrirGuardado=false;
        rol = new Tblrol();
    }

    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tblrol getRol() {
        return rol;
    }

    public void setRol(Tblrol rol) {
        this.rol = rol;
    }
    
    
    
    
}
