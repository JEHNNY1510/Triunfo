/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.ProductoDAO;
import com.triunfo.entidades.Tblproducto;
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
public class ProductoDAOIMPL implements ProductoDAO{
      @Override
    public Boolean insertarProducto(Tblproducto tblproducto) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarProducto PRODCUTO " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarProducto(Tblproducto tblproducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarProducto Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarProducto(Tblproducto tblproducto) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarProducto Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblproducto> buscarProducto() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblproducto> productos = new ArrayList<Tblproducto>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            productos = q.list();
        } catch (Exception e) {
            productos = null;
            System.err.println("Error al buscar buscarProducto: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return productos;
    }

   
    
}


