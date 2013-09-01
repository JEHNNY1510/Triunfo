/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.VentaDAO;
import com.triunfo.entidades.Tblventa;
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
public class VentaDAOIMPL implements VentaDAO{
  @Override
    public Boolean insertarVenta(Tblventa tblventa) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarVenta venta " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarVenta(Tblventa tblventa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarVenta venta " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarVenta(Tblventa tblventa) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarVenta venta " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblventa> buscarVenta() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblventa> venta = new ArrayList<Tblventa>();
        try {
            Query q = session.createQuery("from Tblventa");
            venta = q.list();
        } catch (Exception e) {
            venta = null;
            System.err.println("Error al buscar buscarVenta: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return venta;
    }

}
