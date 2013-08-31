/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblcompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */

 @Local    
public interface CompraDAO {
  
    
    public Boolean insertarCompra(Tblcompra tblCompra);
    public Boolean actualizarCompra(Tblcompra tblCompra);
    public Boolean eliminarCompra(Tblcompra tblCompra);
    public List<Tblcompra> buscarCompra();    

}
