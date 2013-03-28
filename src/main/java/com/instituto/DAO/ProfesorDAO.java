/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Profesor;
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
public class ProfesorDAO extends HibernateDaoSupport {
    @Autowired
    public ProfesorDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Profesor> listarProfesores() {
        return getHibernateTemplate().findByNamedQuery("Profesor.findAll");
    }
    
    public Profesor buscarProfesor(String id) {
        return getHibernateTemplate().get(Profesor.class, id);
    }
    
    public Exception insertarProfesor(Profesor p) {
        if(p == null)
            return new NullPointerException("Profesor nulo");
        try {
            getHibernateTemplate().saveOrUpdate(p);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarProfesor(Profesor p) {
        if(p == null)
            return new NullPointerException("Profesor nulo");
        try {
            getHibernateTemplate().saveOrUpdate(p);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}