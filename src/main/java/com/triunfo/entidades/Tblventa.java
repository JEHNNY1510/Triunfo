package com.triunfo.entidades;
// Generated 24/08/2013 06:40:00 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tblventa generated by hbm2java
 */
@Entity
@Table(name="tblventa"
    ,catalog="tienda"
)
public class Tblventa  implements java.io.Serializable {


     private Integer secventa;
     private Tblpersona tblpersonaBySecvendedor;
     private Tblpersona tblpersonaBySeccliente;
     private Tblpuntodeventa tblpuntodeventa;
     private Date fecha;
     private String observacion;
     private Long total;
     private Integer totalCantidad;
     private Set tbldetalleventas = new HashSet(0);

    public Tblventa() {
    }

	
    public Tblventa(Tblpersona tblpersonaBySecvendedor, Tblpersona tblpersonaBySeccliente, Tblpuntodeventa tblpuntodeventa, Date fecha) {
        this.tblpersonaBySecvendedor = tblpersonaBySecvendedor;
        this.tblpersonaBySeccliente = tblpersonaBySeccliente;
        this.tblpuntodeventa = tblpuntodeventa;
        this.fecha = fecha;
    }
    public Tblventa(Tblpersona tblpersonaBySecvendedor, Tblpersona tblpersonaBySeccliente, Tblpuntodeventa tblpuntodeventa, Date fecha, String observacion, Long total, Integer totalCantidad, Set tbldetalleventas) {
       this.tblpersonaBySecvendedor = tblpersonaBySecvendedor;
       this.tblpersonaBySeccliente = tblpersonaBySeccliente;
       this.tblpuntodeventa = tblpuntodeventa;
       this.fecha = fecha;
       this.observacion = observacion;
       this.total = total;
       this.totalCantidad = totalCantidad;
       this.tbldetalleventas = tbldetalleventas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="SECVENTA", unique=true, nullable=false)
    public Integer getSecventa() {
        return this.secventa;
    }
    
    public void setSecventa(Integer secventa) {
        this.secventa = secventa;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SECVENDEDOR", nullable=false)
    public Tblpersona getTblpersonaBySecvendedor() {
        return this.tblpersonaBySecvendedor;
    }
    
    public void setTblpersonaBySecvendedor(Tblpersona tblpersonaBySecvendedor) {
        this.tblpersonaBySecvendedor = tblpersonaBySecvendedor;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SECCLIENTE", nullable=false)
    public Tblpersona getTblpersonaBySeccliente() {
        return this.tblpersonaBySeccliente;
    }
    
    public void setTblpersonaBySeccliente(Tblpersona tblpersonaBySeccliente) {
        this.tblpersonaBySeccliente = tblpersonaBySeccliente;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SECPUNTODEVENTA", nullable=false)
    public Tblpuntodeventa getTblpuntodeventa() {
        return this.tblpuntodeventa;
    }
    
    public void setTblpuntodeventa(Tblpuntodeventa tblpuntodeventa) {
        this.tblpuntodeventa = tblpuntodeventa;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Column(name="OBSERVACION", length=200)
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Column(name="TOTAL", precision=10, scale=0)
    public Long getTotal() {
        return this.total;
    }
    
    public void setTotal(Long total) {
        this.total = total;
    }
    
    @Column(name="TOTAL_CANTIDAD")
    public Integer getTotalCantidad() {
        return this.totalCantidad;
    }
    
    public void setTotalCantidad(Integer totalCantidad) {
        this.totalCantidad = totalCantidad;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tblventa")
    public Set getTbldetalleventas() {
        return this.tbldetalleventas;
    }
    
    public void setTbldetalleventas(Set tbldetalleventas) {
        this.tbldetalleventas = tbldetalleventas;
    }




}


