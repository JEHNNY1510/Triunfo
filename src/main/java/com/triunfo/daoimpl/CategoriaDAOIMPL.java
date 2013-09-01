/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.CategoriaDAO;
import com.triunfo.entidades.Tblcategoria;
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
public class CategoriaDAOIMPL implements CategoriaDAO{
  
   
    @Override
    public Boolean insertarCategoria(Tblcategoria tblcategoria) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarCategoria categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

 @Override
    public Boolean actualizarCategoria(Tblcategoria tblcategoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarCategoria categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarCategoria(Tblcategoria tblcategoria) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarCategoria categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblcategoria> buscarCategoria() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblcategoria> categoria = new ArrayList<Tblcategoria>();
        try {
            Query q = session.createQuery("from Tblcategoria");
            categoria = q.list();
        } catch (Exception e) {
            categoria = null;
            System.err.println("Error al buscar buscarCategoria: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return categoria;
    }

   
    
}
    

