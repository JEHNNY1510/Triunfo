/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblproveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface ProveedorDAO {
       
    public Boolean insertarProveedor(Tblproveedor tblproducto);
    public Boolean actualizarProveedor(Tblproveedor tblproducto);
    public Boolean eliminarProveedor(Tblproveedor tblproducto);
    public List<Tblproveedor> buscarProveedor();    
 
}
