/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Alumno;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
@Repository
public class AlumnoDAO extends HibernateDaoSupport {
    @Autowired
    public AlumnoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Alumno> listarAlumnos() {
        return getHibernateTemplate().findByNamedQuery("Alumno.findAll");
    }
    
    public Alumno buscarAlumno(String id) {
        return getHibernateTemplate().get(Alumno.class, id);
    }
    
    public Exception insertarAlumno(Alumno a) {
        if(a == null)
            return new NullPointerException("Alumno nulo");
        try {
            getHibernateTemplate().saveOrUpdate(a);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarAlumno(Alumno a) {
        if(a == null)
            return new NullPointerException("Alumno nulo");
        try {
            getHibernateTemplate().delete(a);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}