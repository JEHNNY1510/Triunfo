/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.UsuarioDAO;

import com.triunfo.entidades.Tblusuario;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jaller
 */
@Stateless
    public class UsuarioDAOIMPL implements UsuarioDAO {
   
    @Override
    public Boolean insertarUsuario(Tblusuario tblusuario) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarBarrio Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarUsuario(Tblusuario tblusuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarUsuario ususuario " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarUsuario(Tblusuario tblusuario) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarUsuario usuario " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblusuario> buscarUsuario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblusuario> Usuario = new ArrayList<Tblusuario>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            Usuario = q.list();
        } catch (Exception e) {
            Usuario = null;
            System.err.println("Error al buscar buscarUsuario: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return Usuario;
    }

   
    
}
 
