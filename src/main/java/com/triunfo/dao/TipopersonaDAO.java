/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbltipopersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface TipopersonaDAO {
        
    public Boolean insertarTipopersona(Tbltipopersona tbltipopersona);
    public Boolean actualizarTipopersona(Tbltipopersona tbltipopersona);
    public Boolean eliminarTipopersona(Tbltipopersona tbltipopersona);
    public List<Tbltipopersona> buscarTipopersona();    

}
