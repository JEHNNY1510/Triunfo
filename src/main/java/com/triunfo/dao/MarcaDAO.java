/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblmarca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface MarcaDAO {
      
    public Boolean insertarMarca(Tblmarca tblmarca);
    public Boolean actualizarMarca(Tblmarca tblmarca);
    public Boolean eliminarMarca(Tblmarca tblmarca);
    public List<Tblmarca> buscarMarca();    
  
}
