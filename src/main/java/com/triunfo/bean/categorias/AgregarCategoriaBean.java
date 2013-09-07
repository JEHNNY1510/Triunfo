/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.categorias;


import com.triunfo.dao.CategoriaDAO;
import com.triunfo.entidades.Tblcategoria;
import com.triunfo.utilidades.Utilidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Familia Jaller
 */
@Named(value = "agregarCategoriaBean")
@SessionScoped
public class AgregarCategoriaBean implements Serializable {

    
     private Boolean abrirNuevaCategoria;
     private Tblcategoria categoria;
     @Inject
     CategoriaDAO categoriaDAO;
    
     
     
     public void abrirNuevaCategoria(){
     abrirNuevaCategoria=true;
     Utilidad.actualizarElemento("dlgagregarCategoria");
    }
    
    public void cerrarNuevaCategoria(){
    abrirNuevaCategoria=false;
     Utilidad.actualizarElemento("dlgagregarCategoria");
    }
    
     public void guardarCategoria(){
     
     if(categoria.getNombrecategoria().equals("")){
     Utilidad.mensajeFatal("Guardar  Categoria","No pudo ser guardada la categoria requerida");
     } else{
         if(categoriaDAO.insertarCategoria(categoria)){
           Utilidad.mensajeInfo("Guarda categoria","categoria guardada correctamente");
         }else{Utilidad.mensajeFatal("Guardar  Categoria","No pudo ser guardada la categoria requerida");
         }
     }
    
    }
    public AgregarCategoriaBean() {
         abrirNuevaCategoria=false;
         categoria=new Tblcategoria();
    }

    public Boolean getAbrirNuevaCategoria() {
        return abrirNuevaCategoria;
    }

    public void setAbrirNuevaCategoria(Boolean abrirNuevaCategoria) {
        this.abrirNuevaCategoria = abrirNuevaCategoria;
    }

    public Tblcategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Tblcategoria categoria) {
        this.categoria = categoria;
    }
    
}
