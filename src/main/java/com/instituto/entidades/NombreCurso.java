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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "NombreCurso", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NombreCurso.findAll", query = "SELECT n FROM NombreCurso n"),
    @NamedQuery(name = "NombreCurso.findByIdNombreCursos", query = "SELECT n FROM NombreCurso n WHERE n.idNombreCursos = :idNombreCursos"),
    @NamedQuery(name = "NombreCurso.findByDescripcion", query = "SELECT n FROM NombreCurso n WHERE n.descripcion = :descripcion")})
public class NombreCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdNombreCursos", nullable = false)
    private Long idNombreCursos;
    @Basic(optional = false)
    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNombreCurso")
    private List<DetallePlanAcademico> detallePlanAcademicoList;
    @JoinColumn(name = "IdEspecialidad", referencedColumnName = "IdEspecialidad", nullable = false)
    @ManyToOne(optional = false)
    private Especialidad idEspecialidad;

    public NombreCurso() {
    }

    public NombreCurso(Long idNombreCursos) {
        this.idNombreCursos = idNombreCursos;
    }

    public NombreCurso(Long idNombreCursos, String descripcion) {
        this.idNombreCursos = idNombreCursos;
        this.descripcion = descripcion;
    }

    public Long getIdNombreCursos() {
        return idNombreCursos;
    }

    public void setIdNombreCursos(Long idNombreCursos) {
        this.idNombreCursos = idNombreCursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetallePlanAcademico> getDetallePlanAcademicoList() {
        return detallePlanAcademicoList;
    }

    public void setDetallePlanAcademicoList(List<DetallePlanAcademico> detallePlanAcademicoList) {
        this.detallePlanAcademicoList = detallePlanAcademicoList;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNombreCursos != null ? idNombreCursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NombreCurso)) {
            return false;
        }
        NombreCurso other = (NombreCurso) object;
        if ((this.idNombreCursos == null && other.idNombreCursos != null) || (this.idNombreCursos != null && !this.idNombreCursos.equals(other.idNombreCursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.NombreCurso[ idNombreCursos=" + idNombreCursos + " ]";
    }
    
}
