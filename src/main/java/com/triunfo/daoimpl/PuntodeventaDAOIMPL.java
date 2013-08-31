/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.PuntodeventaDAO;

import com.triunfo.entidades.Tblpuntodeventa;
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
public class PuntodeventaDAOIMPL implements PuntodeventaDAO{
   @Override
    public Boolean insertarPuntoventa(Tblpuntodeventa tblpuntodeventao) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblpuntodeventao);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarPuntoventa Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarPuntoventa(Tblpuntodeventa tblpuntodeventa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblpuntodeventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarPuntoventa Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarPuntoventa(Tblpuntodeventa tblpuntodeventa) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblpuntodeventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarPuntoventa Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblpuntodeventa> buscarPuntoventa() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpuntodeventa> puntoventa = new ArrayList<Tblpuntodeventa>();
        try {
            Query q = session.createQuery("from Tblpuntodeventa");
            puntoventa = q.list();
        } catch (Exception e) {
            puntoventa = null;
            System.err.println("Error al buscar buscarPuntoventa: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return puntoventa;
    }

   
    
}
  

