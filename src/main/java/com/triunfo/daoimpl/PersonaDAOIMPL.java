/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.PersonaDAO;
import com.triunfo.entidades.Tblpersona;
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
public class PersonaDAOIMPL implements PersonaDAO {
  @Override
    public Boolean insertarPersona(Tblpersona tblpersona) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarPersona persona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarPersona(Tblpersona tblpersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarPersona perosona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarPersona(Tblpersona tblpersona) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarPersona persona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblpersona> buscarPersona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpersona> persona = new ArrayList<Tblpersona>();
        try {
            Query q = session.createQuery("from Tblpersona");
            persona = q.list();
        } catch (Exception e) {
            persona = null;
            System.err.println("Error al buscar buscarPersona: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return persona;
    }

   
    
}
    

