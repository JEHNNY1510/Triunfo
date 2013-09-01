/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.bean.rol;

import com.triunfo.dao.RolDAO;
import com.triunfo.entidades.Tblrol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "gestionarRolBean")
@SessionScoped
public class GestionarRolBean implements Serializable {

   private List<Tblrol> roles;
   @Inject
   RolDAO rolDAO;
   
   public void cargarRoles(){
      roles=rolDAO.buscarRol();
   }
   
   public Integer totalRoles(){
       return roles.size();
   }
    
    public GestionarRolBean() {
        roles=new ArrayList<Tblrol>();
        
    }

    public List<Tblrol> getRoles() {
        roles=rolDAO.buscarRol();
        return roles;
    }

    public void setRoles(List<Tblrol> roles) {
        this.roles = roles;
    }
    
    
}
