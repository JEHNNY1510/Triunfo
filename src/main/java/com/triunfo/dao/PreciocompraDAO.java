/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpreciocompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface PreciocompraDAO {
       
    public Boolean insertarPreciocompra(Tblpreciocompra tblpreciocompra);
    public Boolean actualizarPreciocompra(Tblpreciocompra tblpreciocompra);
    public Boolean eliminarPreciocompra(Tblpreciocompra tblpreciocompra);
    public List<Tblpreciocompra> buscarPreciocompra();    
 
}
