/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Administrativo", catalog = "bdClienteServidor", schema = "clienteservidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrativo.findAll", query = "SELECT a FROM Administrativo a"),
    @NamedQuery(name = "Administrativo.findByIdAdministrativo", query = "SELECT a FROM Administrativo a WHERE a.idAdministrativo = :idAdministrativo"),
    @NamedQuery(name = "Administrativo.findByContrasena", query = "SELECT a FROM Administrativo a WHERE a.contrasena = :contrasena"),
    @NamedQuery(name = "Administrativo.findByNombres", query = "SELECT a FROM Administrativo a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Administrativo.findByApellidoPaterno", query = "SELECT a FROM Administrativo a WHERE a.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Administrativo.findByApellidoMaterno", query = "SELECT a FROM Administrativo a WHERE a.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Administrativo.findByDireccion", query = "SELECT a FROM Administrativo a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Administrativo.findByCelular", query = "SELECT a FROM Administrativo a WHERE a.celular = :celular"),
    @NamedQuery(name = "Administrativo.findByTelefono", query = "SELECT a FROM Administrativo a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Administrativo.findByEmail", query = "SELECT a FROM Administrativo a WHERE a.email = :email"),
    @NamedQuery(name = "Administrativo.findByDni", query = "SELECT a FROM Administrativo a WHERE a.dni = :dni"),
    @NamedQuery(name = "Administrativo.findByActivo", query = "SELECT a FROM Administrativo a WHERE a.activo = :activo")})
public class Administrativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdAdministrativo", nullable = false, length = 8)
    private String idAdministrativo;
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
    @Basic(optional = false)
    @Column(name = "DNI", nullable = false, length = 8)
    private String dni;
    @Basic(optional = false)
    @Column(name = "Activo", nullable = false)
    private boolean activo;

    public Administrativo() {
    }

    public Administrativo(String idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
    }

    public Administrativo(String idAdministrativo, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String celular, String telefono, String email, String dni, boolean activo) {
        this.idAdministrativo = idAdministrativo;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.activo = activo;
    }

    public String getIdAdministrativo() {
        return idAdministrativo;
    }

    public void setIdAdministrativo(String idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrativo != null ? idAdministrativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrativo)) {
            return false;
        }
        Administrativo other = (Administrativo) object;
        if ((this.idAdministrativo == null && other.idAdministrativo != null) || (this.idAdministrativo != null && !this.idAdministrativo.equals(other.idAdministrativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto.entidades.Administrativo[ idAdministrativo=" + idAdministrativo + " ]";
    }
    
}
