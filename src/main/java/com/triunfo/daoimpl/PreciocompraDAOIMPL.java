/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.PreciocompraDAO;

import com.triunfo.entidades.Tblpreciocompra;
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
public class PreciocompraDAOIMPL implements PreciocompraDAO {
      @Override
    public Boolean insertarPreciocompra(Tblpreciocompra tblpreciocompra) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarBarrio PRECIOC " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarPreciocompra(Tblpreciocompra tblpreciocompra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarPreciocompra PRECIOC " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarPreciocompra(Tblpreciocompra tblpreciocompra) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarPreciocompra PRECIO " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblpreciocompra> buscarPreciocompra() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpreciocompra> preciocompra = new ArrayList<Tblpreciocompra>();
        try {
            Query q = session.createQuery("from Tblpreciocompra");
            preciocompra = q.list();
        } catch (Exception e) {
            preciocompra = null;
            System.err.println("Error al buscar buscarPreciocompra: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return preciocompra;
    }

   
    
}


