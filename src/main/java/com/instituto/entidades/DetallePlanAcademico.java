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
@Table(name = "DetallePlanAcademico", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePlanAcademico.findAll", query = "SELECT d FROM DetallePlanAcademico d"),
    @NamedQuery(name = "DetallePlanAcademico.findByIdDetalle", query = "SELECT d FROM DetallePlanAcademico d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetallePlanAcademico.findByIdCiclo", query = "SELECT d FROM DetallePlanAcademico d WHERE d.idCiclo = :idCiclo")})
public class DetallePlanAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDetalle", nullable = false)
    private Long idDetalle;
    @Basic(optional = false)
    @Column(name = "IdCiclo", nullable = false, length = 2)
    private String idCiclo;
    @JoinColumn(name = "IdPlanAcademico", referencedColumnName = "IdPlanAcademico", nullable = false)
    @ManyToOne(optional = false)
    private PlanAcademico idPlanAcademico;
    @JoinColumn(name = "IdNombreCurso", referencedColumnName = "IdNombreCursos", nullable = false)
    @ManyToOne(optional = false)
    private NombreCurso idNombreCurso;

    public DetallePlanAcademico() {
    }

    public DetallePlanAcademico(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallePlanAcademico(Long idDetalle, String idCiclo) {
        this.idDetalle = idDetalle;
        this.idCiclo = idCiclo;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public PlanAcademico getIdPlanAcademico() {
        return idPlanAcademico;
    }

    public void setIdPlanAcademico(PlanAcademico idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
    }

    public NombreCurso getIdNombreCurso() {
        return idNombreCurso;
    }

    public void setIdNombreCurso(NombreCurso idNombreCurso) {
        this.idNombreCurso = idNombreCurso;
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
        if (!(object instanceof DetallePlanAcademico)) {
            return false;
        }
        DetallePlanAcademico other = (DetallePlanAcademico) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.DetallePlanAcademico[ idDetalle=" + idDetalle + " ]";
    }
    
}
