/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldepartamento;
import com.triunfo.dao.DepartamentoDAO;
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
public class DepartamentoDAOIMPL implements DepartamentoDAO{
     @Override
    public Boolean insertarDepartamento(Tbldepartamento tbldepartamento) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tbldepartamento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarDepartamento deparetamento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarDepartamento(Tbldepartamento tbldepartamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tbldepartamento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarDepartamento departamento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarDepartamento(Tbldepartamento tbldepartamento) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tbldepartamento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarDepartamento departamento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tbldepartamento> buscarDepartamento() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldepartamento> departamento = new ArrayList<Tbldepartamento>();
        try {
            Query q = session.createQuery("from Tbldepartamento");
            departamento = q.list();
        } catch (Exception e) {
            departamento = null;
            System.err.println("Error al buscar buscarDepartamento: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return departamento;
    }

  

}