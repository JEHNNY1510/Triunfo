/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.MunicipioDAO;
import com.triunfo.entidades.Tblmunicipio;
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
public class MunicipioDAOIMPL implements MunicipioDAO {

      @Override
    public Boolean insertarMunicipio(Tblmunicipio tblmunicipio) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblmunicipio);
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
    public Boolean actualizarMunicipio(Tblmunicipio tblmunicipio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblmunicipio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarMunicipio municipio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarMunicipio(Tblmunicipio tblmunicipio) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblmunicipio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarMunicipio municipio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblmunicipio> buscarMunicipio() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblmunicipio> municipio = new ArrayList<Tblmunicipio>();
        try {
            Query q = session.createQuery("from Tblmunicipio");
            municipio = q.list();
        } catch (Exception e) {
            municipio = null;
            System.err.println("Error al buscar buscarMunicipio: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return municipio;
    }

   
    
}


