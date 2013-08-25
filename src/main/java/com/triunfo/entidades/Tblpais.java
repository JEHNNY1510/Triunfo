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
 * Tblpais generated by hbm2java
 */
@Entity
@Table(name="tblpais"
    ,catalog="tienda"
)
public class Tblpais  implements java.io.Serializable {


     private Integer secpais;
     private String nombre;
     private Set tbldepartamentos = new HashSet(0);

    public Tblpais() {
    }

	
    public Tblpais(String nombre) {
        this.nombre = nombre;
    }
    public Tblpais(String nombre, Set tbldepartamentos) {
       this.nombre = nombre;
       this.tbldepartamentos = tbldepartamentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="SECPAIS", unique=true, nullable=false)
    public Integer getSecpais() {
        return this.secpais;
    }
    
    public void setSecpais(Integer secpais) {
        this.secpais = secpais;
    }
    
    @Column(name="NOMBRE", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tblpais")
    public Set getTbldepartamentos() {
        return this.tbldepartamentos;
    }
    
    public void setTbldepartamentos(Set tbldepartamentos) {
        this.tbldepartamentos = tbldepartamentos;
    }




}

