/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.UnidadDAO;

import com.triunfo.entidades.Tblunidad;
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
public class UnidadDAOIMPL  implements UnidadDAO{
    
    @Override
    public Boolean insertarUnidad(Tblunidad tblunidad) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarUnidad UNIDAD " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarUnidad(Tblunidad tblunidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarUnidad UNIDAD " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarUnidad(Tblunidad tblunidad) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarUnidad UNIDAD " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblunidad> buscarUnidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblunidad> unidad = new ArrayList<Tblunidad>();
        try {
            Query q = session.createQuery("from Tblunidad");
            unidad = q.list();
        } catch (Exception e) {
            unidad = null;
            System.err.println("Error al buscar buscarUnidad: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return unidad;
    }

   
    
}

