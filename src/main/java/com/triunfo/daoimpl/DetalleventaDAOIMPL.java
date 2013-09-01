/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.DetalleventaDAO;
import com.triunfo.entidades.Tbldetalleventa;
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
public class DetalleventaDAOIMPL implements DetalleventaDAO{
    
 @Override
    public Boolean insertarDetalleventa(Tbldetalleventa tbldetalleventa) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarDetalleventa detallev " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarDetalleventa(Tbldetalleventa tbldetalleventa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarDetalleventa detallev " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarDetalleventa(Tbldetalleventa tbldetalleventa) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarDetalleventa detallev " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbldetalleventa> buscarDetalleventa() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldetalleventa> detallev = new ArrayList<Tbldetalleventa>();
        try {
            Query q = session.createQuery("from Tbldetalleventa");
            detallev = q.list();
        } catch (Exception e) {
            detallev = null;
            System.err.println("Error al buscar buscarDetalleventa: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return detallev;
    }

   
    
}

