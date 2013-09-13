/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.marca;

import com.triunfo.dao.MarcaDAO;
import com.triunfo.entidades.Tblmarca;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarMarcaBean")
@SessionScoped
public class AgregarMarcaBean implements Serializable {

    private Boolean abrirGuardado;
    private Tblmarca marca;
    
    @Inject
    MarcaDAO marcaDAO;
    
     public void cargarGuardado(){
        abrirGuardado=true;
        System.out.println("el valor de la variable quedo en "+abrirGuardado);
        Utilidad.actualizarElemento("dlgagregarMarca");
        Utilidad.actualizarElemento("tblmarca");
    }
       public void guardarMarca(){
        
        if (marca.getNombremarca().equals("")) {
            Utilidad.mensajeFatal("Tienda El Triunfo: ", "Descripcion marca Requerida.");
        } else {
            System.out.println("lo que vamos a guardar es lo siguiente-->>>" + marca.getNombremarca());
            if (marcaDAO.insertarMarca(marca)) {
                Utilidad.mensajeInfo("Tienda El Triunfo: ", "marca: " + marca.getNombremarca()+ ". Guardado Correctamente.");
                marca = new Tblmarca();
                Utilidad.actualizarElemento("txtdescripcionmarca");
            } else {
                Utilidad.mensajeFatal("Tienda El Triunfo: ", "marca: " + marca.getNombremarca()+ ". No pudo ser guardado.");
            }
        }
        
               
    }
        public void cerrarGuardado(){
        marca = new Tblmarca();
        abrirGuardado=false;
        Utilidad.actualizarElemento("dlgagregarMarca");
    }
    public AgregarMarcaBean() {
        abrirGuardado=false;
        marca = new Tblmarca();
    }

    public Boolean getAbrirGuardado() {
        return abrirGuardado;
    }

    public void setAbrirGuardado(Boolean abrirGuardado) {
        this.abrirGuardado = abrirGuardado;
    }

    public Tblmarca getMarca() {
        return marca;
    }

    public void setMarca(Tblmarca marca) {
        this.marca = marca;
    }
    
   
}
