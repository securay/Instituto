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
@Table(name = "PlanAcademico", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanAcademico.findAll", query = "SELECT p FROM PlanAcademico p"),
    @NamedQuery(name = "PlanAcademico.findByIdPlanAcademico", query = "SELECT p FROM PlanAcademico p WHERE p.idPlanAcademico = :idPlanAcademico"),
    @NamedQuery(name = "PlanAcademico.findByDescripcion", query = "SELECT p FROM PlanAcademico p WHERE p.descripcion = :descripcion")})
public class PlanAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPlanAcademico", nullable = false)
    private Long idPlanAcademico;
    @Basic(optional = false)
    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanAcademico")
    private List<DetallePlanAcademico> detallePlanAcademicoList;
    @JoinColumn(name = "IdEspecialidad", referencedColumnName = "IdEspecialidad", nullable = false)
    @ManyToOne(optional = false)
    private Especialidad idEspecialidad;

    public PlanAcademico() {
    }

    public PlanAcademico(Long idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
    }

    public PlanAcademico(Long idPlanAcademico, String descripcion) {
        this.idPlanAcademico = idPlanAcademico;
        this.descripcion = descripcion;
    }

    public Long getIdPlanAcademico() {
        return idPlanAcademico;
    }

    public void setIdPlanAcademico(Long idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
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
        hash += (idPlanAcademico != null ? idPlanAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanAcademico)) {
            return false;
        }
        PlanAcademico other = (PlanAcademico) object;
        if ((this.idPlanAcademico == null && other.idPlanAcademico != null) || (this.idPlanAcademico != null && !this.idPlanAcademico.equals(other.idPlanAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.PlanAcademico[ idPlanAcademico=" + idPlanAcademico + " ]";
    }
    
}
