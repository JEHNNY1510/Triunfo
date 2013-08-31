/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface ProductoDAO {
     
    public Boolean insertarProducto(Tblproducto tblproducto);
    public Boolean actualizarProducto(Tblproducto tblproducto);
    public Boolean eliminarProducto(Tblproducto tblproducto);
    public List<Tblproducto> buscarProducto();    
   
}
