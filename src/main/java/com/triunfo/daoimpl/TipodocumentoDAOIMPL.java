/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.TipodocumentoDAO;
import com.triunfo.entidades.Tbltipodocumento;

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
public class TipodocumentoDAOIMPL implements TipodocumentoDAO {
   @Override
    public Boolean insertarTipodocumento(Tbltipodocumento Tbltipodocumento) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarTipodocumento Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarTipodocumento(Tbltipodocumento tbltipodocumento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarTipodocumento tipod " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarTipodocumento(Tbltipodocumento tbltipodocumento) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarTipodocumento tipod " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbltipodocumento> buscarTipodocumento() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbltipodocumento> tipod = new ArrayList<Tbltipodocumento>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            tipod = q.list();
        } catch (Exception e) {
            tipod = null;
            System.err.println("Error al buscar buscarTipodocumento: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return tipod;
    }

   
    
}
    
