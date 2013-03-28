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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DetalleNota", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleNota.findAll", query = "SELECT d FROM DetalleNota d"),
    @NamedQuery(name = "DetalleNota.findByIdDetalleNota", query = "SELECT d FROM DetalleNota d WHERE d.idDetalleNota = :idDetalleNota"),
    @NamedQuery(name = "DetalleNota.findByIdDetalleCurso", query = "SELECT d FROM DetalleNota d WHERE d.idDetalleCurso = :idDetalleCurso"),
    @NamedQuery(name = "DetalleNota.findByNota", query = "SELECT d FROM DetalleNota d WHERE d.nota = :nota"),
    @NamedQuery(name = "DetalleNota.findByPorcentaje", query = "SELECT d FROM DetalleNota d WHERE d.porcentaje = :porcentaje")})
public class DetalleNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDetalleNota", nullable = false)
    private Long idDetalleNota;
    @Basic(optional = false)
    @Column(name = "IdDetalleCurso", nullable = false)
    private long idDetalleCurso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Nota", nullable = false, precision = 4, scale = 2)
    private BigDecimal nota;
    @Basic(optional = false)
    @Column(name = "Porcentaje", nullable = false, precision = 4, scale = 2)
    private BigDecimal porcentaje;

    public DetalleNota() {
    }

    public DetalleNota(Long idDetalleNota) {
        this.idDetalleNota = idDetalleNota;
    }

    public DetalleNota(Long idDetalleNota, long idDetalleCurso, BigDecimal nota, BigDecimal porcentaje) {
        this.idDetalleNota = idDetalleNota;
        this.idDetalleCurso = idDetalleCurso;
        this.nota = nota;
        this.porcentaje = porcentaje;
    }

    public Long getIdDetalleNota() {
        return idDetalleNota;
    }

    public void setIdDetalleNota(Long idDetalleNota) {
        this.idDetalleNota = idDetalleNota;
    }

    public long getIdDetalleCurso() {
        return idDetalleCurso;
    }

    public void setIdDetalleCurso(long idDetalleCurso) {
        this.idDetalleCurso = idDetalleCurso;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleNota != null ? idDetalleNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleNota)) {
            return false;
        }
        DetalleNota other = (DetalleNota) object;
        if ((this.idDetalleNota == null && other.idDetalleNota != null) || (this.idDetalleNota != null && !this.idDetalleNota.equals(other.idDetalleNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.DetalleNota[ idDetalleNota=" + idDetalleNota + " ]";
    }
    
}
