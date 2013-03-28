/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Periodo;
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
public class PeriodoDAO extends HibernateDaoSupport {
    @Autowired
    public PeriodoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Periodo> listarPeriodo() {
        return getHibernateTemplate().findByNamedQuery("Periodo.findAll");
    }
    
    public Periodo buscarNombreCurso(String id) {
        return getHibernateTemplate().get(Periodo.class, id);
    }
    
    public Exception insertarPeriodo(Periodo nc) {
        if(nc == null)
            return new NullPointerException("Periodo nulo");
        try {
            getHibernateTemplate().saveOrUpdate(nc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarNombreCurso(Periodo nc) {
        if(nc == null)
            return new NullPointerException("Periodo nulo");
        try {
            getHibernateTemplate().delete(nc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}