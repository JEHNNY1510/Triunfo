/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldetalleventa;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author Jaller
 */
@Local
public interface DetalleventaDAO {
        
    public Boolean insertarDetalleventa(Tbldetalleventa tbldetalleventa);
    public Boolean actualizarDetalleventa(Tbldetalleventa tbldetalleventa);
    public Boolean eliminarDetalleventa(Tbldetalleventa tbldetalleventa);
    public List<Tbldetalleventa> buscarDetalleventa();    

}
