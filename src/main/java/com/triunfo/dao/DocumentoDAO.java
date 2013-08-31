/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface DocumentoDAO {
     
    public Boolean insertarDocumento(Tbldocumento tbldocumento);
    public Boolean actualizarDocumento(Tbldocumento tbldocumento);
    public Boolean eliminarDocumento(Tbldocumento tbldocumento);
    public List<Tbldocumento> buscarDocumento();    
   
}
