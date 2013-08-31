/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;


import com.triunfo.entidades.Tblventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface VentaDAO {
       
    public Boolean insertarVenta(Tblventa tblventa);
    public Boolean actualizarVenta(Tblventa tblventa);
    public Boolean eliminarVenta(Tblventa tblventa);
    public List<Tblventa> buscarVenta();    

   
 
}
