/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblmunicipio;
import java.util.List;

/**
 *
 * @author Jaller
 */
public interface MunicipioDAO {
      
    public Boolean insertarMunicipio(Tblmunicipio tblmunicipio);
    public Boolean actualizarMunicipio(Tblmunicipio tblmunicipio);
    public Boolean eliminarMunicipio(Tblmunicipio tblmunicipio);
    public List<Tblmunicipio> buscarMunicipio();    
  
}
