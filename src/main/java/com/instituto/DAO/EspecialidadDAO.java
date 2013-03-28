/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Especialidad;
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
public class EspecialidadDAO extends HibernateDaoSupport {
    @Autowired

    public EspecialidadDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Especialidad> listarEspecialidades() {
        return getHibernateTemplate().findByNamedQuery("Especialidad.findAll");
    }
    
    public Especialidad buscarEspecialidad(String id) {
        return getHibernateTemplate().get(Especialidad.class, id);
    }
    
    public Exception insertarEspecialidad(Especialidad e) {
        if(e == null)
            return new NullPointerException("Especialidad nula");
        try {
            getHibernateTemplate().saveOrUpdate(e);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarEspecialidad(Especialidad e) {
        if(e == null)
            return new NullPointerException("Especialidad nulo");
        try {
            getHibernateTemplate().delete(e);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}