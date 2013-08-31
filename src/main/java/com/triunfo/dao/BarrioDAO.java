/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblbarrio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jennifer
 */

@Local
public interface BarrioDAO {
    
    public Boolean insertarBarrio(Tblbarrio tblbarrio);
    public Boolean actualizarBarrio(Tblbarrio tblbarrio);
    public Boolean eliminarBarrio(Tblbarrio tblbarrio);
    public List<Tblbarrio> buscarBarrios();    


    
    
    
}
