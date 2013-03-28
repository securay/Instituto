/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Curso", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Curso.findByEstado", query = "SELECT c FROM Curso c WHERE c.estado = :estado")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdCurso", nullable = false, length = 8)
    private String idCurso;
    @Basic(optional = false)
    @Column(name = "Estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "IdProfesor", referencedColumnName = "IdProfesor", nullable = false)
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @JoinColumn(name = "IdPeriodo", referencedColumnName = "IdPeriodo", nullable = false)
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @JoinColumn(name = "IdNombreCurso", referencedColumnName = "IdNombreCursos", nullable = false)
    @ManyToOne(optional = false)
    private NombreCurso idNombreCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<DetalleCurso> detalleCursoList;

    public Curso() {
    }

    public Curso(String idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(String idCurso, boolean estado) {
        this.idCurso = idCurso;
        this.estado = estado;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public NombreCurso getIdNombreCurso() {
        return idNombreCurso;
    }

    public void setIdNombreCurso(NombreCurso idNombreCurso) {
        this.idNombreCurso = idNombreCurso;
    }

    @XmlTransient
    public List<DetalleCurso> getDetalleCursoList() {
        return detalleCursoList;
    }

    public void setDetalleCursoList(List<DetalleCurso> detalleCursoList) {
        this.detalleCursoList = detalleCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
