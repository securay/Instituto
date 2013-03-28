/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Pagos", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPagos", query = "SELECT p FROM Pagos p WHERE p.idPagos = :idPagos"),
    @NamedQuery(name = "Pagos.findByIdMes", query = "SELECT p FROM Pagos p WHERE p.idMes = :idMes"),
    @NamedQuery(name = "Pagos.findByMonto", query = "SELECT p FROM Pagos p WHERE p.monto = :monto"),
    @NamedQuery(name = "Pagos.findByAbonado", query = "SELECT p FROM Pagos p WHERE p.abonado = :abonado"),
    @NamedQuery(name = "Pagos.findByDeuda", query = "SELECT p FROM Pagos p WHERE p.deuda = :deuda")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPagos", nullable = false)
    private Long idPagos;
    @Basic(optional = false)
    @Column(name = "IdMes", nullable = false, length = 6)
    private String idMes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Monto", nullable = false, precision = 6, scale = 2)
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "Abonado", nullable = false, precision = 6, scale = 2)
    private BigDecimal abonado;
    @Basic(optional = false)
    @Column(name = "Deuda", nullable = false)
    private boolean deuda;
    @JoinColumn(name = "IdAlumno", referencedColumnName = "IdAlumno", nullable = false)
    @ManyToOne(optional = false)
    private Alumno idAlumno;

    public Pagos() {
    }

    public Pagos(Long idPagos) {
        this.idPagos = idPagos;
    }

    public Pagos(Long idPagos, String idMes, BigDecimal monto, BigDecimal abonado, boolean deuda) {
        this.idPagos = idPagos;
        this.idMes = idMes;
        this.monto = monto;
        this.abonado = abonado;
        this.deuda = deuda;
    }

    public Long getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Long idPagos) {
        this.idPagos = idPagos;
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

    public BigDecimal getAbonado() {
        return abonado;
    }

    public void setAbonado(BigDecimal abonado) {
        this.abonado = abonado;
    }

    public boolean getDeuda() {
        return deuda;
    }

    public void setDeuda(boolean deuda) {
        this.deuda = deuda;
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
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.Pagos[ idPagos=" + idPagos + " ]";
    }
    
}
