package com.triunfo.entidades;
// Generated 24/08/2013 06:40:00 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tblmarca generated by hbm2java
 */
@Entity
@Table(name="tblmarca"
    ,catalog="tienda"
)
public class Tblmarca  implements java.io.Serializable {


     private Integer secmarca;
     private String nombremarca;
     private Set tblproductos = new HashSet(0);

    public Tblmarca() {
    }

	
    public Tblmarca(String nombremarca) {
        this.nombremarca = nombremarca;
    }
    public Tblmarca(String nombremarca, Set tblproductos) {
       this.nombremarca = nombremarca;
       this.tblproductos = tblproductos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="SECMARCA", unique=true, nullable=false)
    public Integer getSecmarca() {
        return this.secmarca;
    }
    
    public void setSecmarca(Integer secmarca) {
        this.secmarca = secmarca;
    }
    
    @Column(name="NOMBREMARCA", nullable=false, length=45)
    public String getNombremarca() {
        return this.nombremarca;
    }
    
    public void setNombremarca(String nombremarca) {
        this.nombremarca = nombremarca;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tblmarca")
    public Set getTblproductos() {
        return this.tblproductos;
    }
    
    public void setTblproductos(Set tblproductos) {
        this.tblproductos = tblproductos;
    }




}


