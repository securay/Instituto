/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Alumno", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumno.findByContrasena", query = "SELECT a FROM Alumno a WHERE a.contrasena = :contrasena"),
    @NamedQuery(name = "Alumno.findByNombres", query = "SELECT a FROM Alumno a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Alumno.findByApellidoPaterno", query = "SELECT a FROM Alumno a WHERE a.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Alumno.findByApellidoMaterno", query = "SELECT a FROM Alumno a WHERE a.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Alumno.findByCelular", query = "SELECT a FROM Alumno a WHERE a.celular = :celular"),
    @NamedQuery(name = "Alumno.findByTelefono", query = "SELECT a FROM Alumno a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Alumno.findByEmail", query = "SELECT a FROM Alumno a WHERE a.email = :email"),
    @NamedQuery(name = "Alumno.findByDni", query = "SELECT a FROM Alumno a WHERE a.dni = :dni"),
    @NamedQuery(name = "Alumno.findByFechaIngreso", query = "SELECT a FROM Alumno a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Alumno.findByActivo", query = "SELECT a FROM Alumno a WHERE a.activo = :activo")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdAlumno", nullable = false, length = 10)
    private String idAlumno;
    @Basic(optional = false)
    @Column(name = "Contrasena", nullable = false, length = 20)
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "Nombres", nullable = false, length = 50)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "Apellido_Paterno", nullable = false, length = 25)
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "Apellido_Materno", nullable = false, length = 25)
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "Direccion", nullable = false, length = 200)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "Celular", nullable = false, length = 12)
    private String celular;
    @Basic(optional = false)
    @Column(name = "Telefono", nullable = false, length = 12)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Email", nullable = false, length = 100)
    private String email;
    @Basic(optional = false)
    @Column(name = "DNI", nullable = false, length = 8)
    private String dni;
    @Basic(optional = false)
    @Column(name = "FechaIngreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "Activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlumno")
    private List<DetalleCurso> detalleCursoList;

    public Alumno() {
    }

    public Alumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(String idAlumno, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String celular, String telefono, String email, String dni, Date fechaIngreso, boolean activo) {
        this.idAlumno = idAlumno;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
