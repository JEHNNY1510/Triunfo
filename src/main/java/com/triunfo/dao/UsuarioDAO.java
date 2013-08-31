/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblusuario;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaller
 */
@Local
public interface UsuarioDAO {
     public Boolean insertarUsuario(Tblusuario tblusuario);
    public Boolean actualizarUsuario(Tblusuario tblusuarioa);
    public Boolean eliminarUsuario(Tblusuario tblusuario);
    public List<Tblusuario> buscarUsuario();      
}
