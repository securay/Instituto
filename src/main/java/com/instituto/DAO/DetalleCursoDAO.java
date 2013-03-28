/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.DetalleCurso;
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
public class DetalleCursoDAO extends HibernateDaoSupport {
    @Autowired
    public DetalleCursoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<DetalleCurso> listarDetCursos() {
        return getHibernateTemplate().findByNamedQuery("DetalleCurso.findAll");
    }
    
    public DetalleCurso buscarDetalleCurso(Long id) {
        return getHibernateTemplate().get(DetalleCurso.class, id);
    }
    
    public Exception insertarDetalleCurso(DetalleCurso dc) {
        if(dc == null)
            return new NullPointerException("Detalle De Curso nulo");
        try {
            getHibernateTemplate().saveOrUpdate(dc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarDetalleCurso(DetalleCurso dc) {
        if(dc == null)
            return new NullPointerException("Detalle De Curso nulo");
        try {
            getHibernateTemplate().delete(dc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}
