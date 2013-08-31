/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface PaisDAO {
      
    public Boolean insertarPais(Tblpais tblpais);
    public Boolean actualizarPais(Tblpais tblpais);
    public Boolean eliminarPais(Tblpais tblpais);
    public List<Tblpais> buscarPais();    
  
}
