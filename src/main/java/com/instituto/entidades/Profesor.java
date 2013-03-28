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
@Table(name = "Profesor", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByContrasena", query = "SELECT p FROM Profesor p WHERE p.contrasena = :contrasena"),
    @NamedQuery(name = "Profesor.findByNombres", query = "SELECT p FROM Profesor p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Profesor.findByApellidoPaterno", query = "SELECT p FROM Profesor p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Profesor.findByApellidoMaterno", query = "SELECT p FROM Profesor p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Profesor.findByDireccion", query = "SELECT p FROM Profesor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Profesor.findByCelular", query = "SELECT p FROM Profesor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Profesor.findByTelefono", query = "SELECT p FROM Profesor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Profesor.findByEmail", query = "SELECT p FROM Profesor p WHERE p.email = :email"),
    @NamedQuery(name = "Profesor.findByDni", query = "SELECT p FROM Profesor p WHERE p.dni = :dni")})
public class Profesor implements Serializable {
    @Basic(optional = false)
    @Column(name = "Activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesor")
    private List<Curso> cursoList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdProfesor", nullable = false, length = 8)
    private String idProfesor;
    @Basic(optional = false)
    @Column(name = "Contrasena", nullable = false, length = 25)
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
    @Column(name = "DNI", length = 10)
    private String dni;

    public Profesor() {
    }

    public Profesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(String idProfesor, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String celular, String telefono, String email) {
        this.idProfesor = idProfesor;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.Profesor[ idProfesor=" + idProfesor + " ]";
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }
    
}
