/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpuntodeventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface PuntodeventaDAO {
      
    public Boolean insertarPuntoventa(Tblpuntodeventa tblpuntodeventa);
    public Boolean actualizarPuntoventa(Tblpuntodeventa tblpuntodeventa);
    public Boolean eliminarPuntoventa(Tblpuntodeventa tblpuntodeventa);
    public List<Tblpuntodeventa> buscarPuntoventa();    
  
}
