/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblsexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface SexoDAO {
        
    public Boolean insertarSexo(Tblsexo tblsexo);
    public Boolean actualizarSexo(Tblsexo tblsexo);
    public Boolean eliminarSexo(Tblsexo tblsexo);
    public List<Tblsexo> buscarSexo();    

}
