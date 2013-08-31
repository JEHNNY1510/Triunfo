/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldetallecompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface DetallecompraDAO {
        
    public Boolean insertarDetallecompra(Tbldetallecompra tbldetallecompra);
    public Boolean actualizarDetallecompra(Tbldetallecompra tbldetallecompra);
    public Boolean eliminarDetallecompra(Tbldetallecompra tbldetallecompra);
    public List<Tbldetallecompra> buscarDetallecompra();    

}
