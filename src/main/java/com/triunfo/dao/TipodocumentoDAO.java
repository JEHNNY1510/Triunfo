/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbltipodocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface TipodocumentoDAO {
        
    public Boolean insertarTipodocumento(Tbltipodocumento tbltipodocumento);
    public Boolean actualizarTipodocumento(Tbltipodocumento tbltipodocumento);
    public Boolean eliminarTipodocumento(Tbltipodocumento tbltipodocumento);
    public List<Tbltipodocumento> buscarTipodocumento();    

}
