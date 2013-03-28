/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Curso;
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
public class CursoDAO extends HibernateDaoSupport {
    @Autowired
    public CursoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Curso> listarCursos() {
        return getHibernateTemplate().findByNamedQuery("Curso.findAll");
    }
    
    public List<Curso> listarCursos(Long idNombreCurso) {
        return getHibernateTemplate().find("SELECT c FROM Curso c "
                + "WHERE c.idNombreCurso.idNombreCurso = ?", idNombreCurso);
    }
    
    public Curso buscarCurso(String id) {
        return getHibernateTemplate().get(Curso.class, id);
    }
    
    public Exception insertarCurso(Curso c) {
        if(c == null)
            return new NullPointerException("Curso nulo");
        try {
            getHibernateTemplate().saveOrUpdate(c);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarCurso(Curso c) {
        if(c == null)
            return new NullPointerException("Curso nulo");
        try {
            getHibernateTemplate().delete(c);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}