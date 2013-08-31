/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.SexoDAO;

import com.triunfo.entidades.Tblsexo;
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
public class SexoDAOIMPL implements SexoDAO{
    
    @Override
    public Boolean insertarSexo(Tblsexo tblsexo) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarBarrio sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarSexo(Tblsexo tblsexo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarSexo sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarSexo(Tblsexo tblsexo) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarSexo sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblsexo> buscarSexo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblsexo> sexo = new ArrayList<Tblsexo>();
        try {
            Query q = session.createQuery("from Tblsexo");
            sexo = q.list();
        } catch (Exception e) {
            sexo = null;
            System.err.println("Error al buscar buscarSexo: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return sexo;
    }

   
    
}

