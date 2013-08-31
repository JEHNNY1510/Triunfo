/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldocumento;
import com.triunfo.dao.DocumentoDAO;
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
public class DocumentoDAOIMPL implements DocumentoDAO {
    
 @Override
    public Boolean insertarDocumento(Tbldocumento tbldocumento) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarDocumento docuemnto " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarDocumento(Tbldocumento tbldocumento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarDocumento DOcuemnto " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarDocumento(Tbldocumento tbldocumento) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarDocumento DOCUMENTO " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbldocumento> buscarDocumento() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldocumento> documento = new ArrayList<Tbldocumento>();
        try {
            Query q = session.createQuery("from Tbldocumento");
            documento = q.list();
        } catch (Exception e) {
            documento = null;
            System.err.println("Error al buscar buscarBarrios: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return documento;
    }

   
    
}

