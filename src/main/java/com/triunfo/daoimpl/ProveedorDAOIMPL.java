/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfo.hibernate.HibernateUtil;
import com.triunfo.dao.ProveedorDAO;
import com.triunfo.entidades.Tblproveedor;
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
public class ProveedorDAOIMPL implements ProveedorDAO{
 @Override
    public Boolean insertarProveedor(Tblproveedor tblproducto) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarProveedor Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarProveedor(Tblproveedor tblproducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarProveedor Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarProveedor(Tblproveedor tblproducto) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarProveedor Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblproveedor> buscarProveedor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblproveedor> proveedor = new ArrayList<Tblproveedor>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            proveedor = q.list();
        } catch (Exception e) {
            proveedor = null;
            System.err.println("Error al buscar buscarProveedor: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return proveedor;
    }

   
    
}
