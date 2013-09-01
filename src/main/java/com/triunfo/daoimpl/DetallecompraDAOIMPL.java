/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldetallecompra;
import com.triunfo.dao.DetallecompraDAO;
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
public class DetallecompraDAOIMPL implements DetallecompraDAO{
    @Override
    public Boolean insertarDetallecompra(Tbldetallecompra tbldetallecompra) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarDetallecompra detallec " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarDetallecompra(Tbldetallecompra tbldetallecompra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarDetallecompra detallec " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarDetallecompra(Tbldetallecompra tbldetallecompra) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarDetallecompra compra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbldetallecompra> buscarDetallecompra() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldetallecompra> detallecompra = new ArrayList<Tbldetallecompra>();
        try {
            Query q = session.createQuery("from Tbldetallecompra");
            detallecompra = q.list();
        } catch (Exception e) {
            detallecompra = null;
            System.err.println("Error al buscar buscarBarrios: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return detallecompra;
    }

   
    
}
 

