/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface PersonaDAO {
        
    public Boolean insertarPersona(Tblpersona tblpersona);
    public Boolean actualizarPersona(Tblpersona tblpersona);
    public Boolean eliminarPersona(Tblpersona tblpersona);
    public List<Tblpersona> buscarPersona();    

}
