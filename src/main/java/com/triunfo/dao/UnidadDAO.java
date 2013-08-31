/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblunidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface UnidadDAO {
       
    public Boolean insertarUnidad(Tblunidad tblunidad);
    public Boolean actualizarUnidad(Tblunidad tblunidad);
    public Boolean eliminarUnidad(Tblunidad tblunidad);
    public List<Tblunidad> buscarUnidad();    
 
}
