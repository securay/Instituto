/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
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
@Table(name = "DetalleCurso", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCurso.findAll", query = "SELECT d FROM DetalleCurso d"),
    @NamedQuery(name = "DetalleCurso.findByIdDetalleCurso", query = "SELECT d FROM DetalleCurso d WHERE d.idDetalleCurso = :idDetalleCurso")})
public class DetalleCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDetalleCurso", nullable = false)
    private Long idDetalleCurso;
    @JoinColumn(name = "IdCurso", referencedColumnName = "IdCurso", nullable = false)
    @ManyToOne(optional = false)
    private Curso idCurso;
    @JoinColumn(name = "IdAlumno", referencedColumnName = "IdAlumno", nullable = false)
    @ManyToOne(optional = false)
    private Alumno idAlumno;

    public DetalleCurso() {
    }

    public DetalleCurso(Long idDetalleCurso) {
        this.idDetalleCurso = idDetalleCurso;
    }

    public Long getIdDetalleCurso() {
        return idDetalleCurso;
    }

    public void setIdDetalleCurso(Long idDetalleCurso) {
        this.idDetalleCurso = idDetalleCurso;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
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
        hash += (idDetalleCurso != null ? idDetalleCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCurso)) {
            return false;
        }
        DetalleCurso other = (DetalleCurso) object;
        if ((this.idDetalleCurso == null && other.idDetalleCurso != null) || (this.idDetalleCurso != null && !this.idDetalleCurso.equals(other.idDetalleCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.DetalleCurso[ idDetalleCurso=" + idDetalleCurso + " ]";
    }
    
}
