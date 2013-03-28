/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DetallePagos", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePagos.findAll", query = "SELECT d FROM DetallePagos d"),
    @NamedQuery(name = "DetallePagos.findByIdDetalle", query = "SELECT d FROM DetallePagos d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetallePagos.findByIdMes", query = "SELECT d FROM DetallePagos d WHERE d.idMes = :idMes"),
    @NamedQuery(name = "DetallePagos.findByMonto", query = "SELECT d FROM DetallePagos d WHERE d.monto = :monto"),
    @NamedQuery(name = "DetallePagos.findByFecha", query = "SELECT d FROM DetallePagos d WHERE d.fecha = :fecha")})
public class DetallePagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDetalle", nullable = false)
    private Long idDetalle;
    @Basic(optional = false)
    @Column(name = "IdMes", nullable = false, length = 6)
    private String idMes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Monto", nullable = false, precision = 6, scale = 2)
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "Fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "IdPagos", referencedColumnName = "IdPagos", nullable = false)
    @ManyToOne(optional = false)
    private Pagos idPagos;
    @JoinColumn(name = "IdAlumno", referencedColumnName = "IdAlumno", nullable = false)
    @ManyToOne(optional = false)
    private Alumno idAlumno;

    public DetallePagos() {
    }

    public DetallePagos(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallePagos(Long idDetalle, String idMes, BigDecimal monto, Date fecha) {
        this.idDetalle = idDetalle;
        this.idMes = idMes;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdMes() {
        return idMes;
    }

    public void setIdMes(String idMes) {
        this.idMes = idMes;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pagos getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Pagos idPagos) {
        this.idPagos = idPagos;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePagos)) {
            return false;
        }
        DetallePagos other = (DetallePagos) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.DetallePagos[ idDetalle=" + idDetalle + " ]";
    }
    
}
