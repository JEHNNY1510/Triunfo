/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblrol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface RolDAO {
     
    public Boolean insertarRol(Tblrol tblrol);
    public Boolean actualizarRol(Tblrol tblrol);
    public Boolean eliminarRol(Tblrol tblrol);
    public List<Tblrol> buscarRol();    
   
}
