/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.TipopersonaDAO;
import com.triunfo.entidades.Tbltipopersona;
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
public class TipopersonaDAOIMPL implements TipopersonaDAO {
      @Override
    public Boolean insertarTipopersona(Tbltipopersona tbltipopersona) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tbltipopersona);
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
    public Boolean actualizarTipopersona(Tbltipopersona tbltipopersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbltipopersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarBarrio Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarTipopersona(Tbltipopersona tbltipopersona) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbltipopersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarTipopersona tipop " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbltipopersona> buscarTipopersona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbltipopersona> tipop = new ArrayList<Tbltipopersona>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            tipop = q.list();
        } catch (Exception e) {
            tipop = null;
            System.err.println("Error al buscar buscarTipopersona: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return tipop;
    }

   
    
}
 

