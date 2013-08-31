/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblmarca;
import com.triunfo.dao.MarcaDAO;
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
public class MarcaDAOIMPL implements MarcaDAO {
    
 @Override
    public Boolean insertarMarca(Tblmarca tblmarca) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarMarca marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarMarca(Tblmarca tblmarca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarMarca marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarMarca(Tblmarca tblmarca) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarMarca marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblmarca> buscarMarca() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblmarca> marca = new ArrayList<Tblmarca>();
        try {
            Query q = session.createQuery("from Tblmarca");
            marca = q.list();
        } catch (Exception e) {
            marca = null;
            System.err.println("Error al buscar buscarMarca: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return marca;
    }

   
    
}
