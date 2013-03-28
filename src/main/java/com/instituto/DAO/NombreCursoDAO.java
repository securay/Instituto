/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.NombreCurso;
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
public class NombreCursoDAO extends HibernateDaoSupport {
    @Autowired
    public NombreCursoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<NombreCurso> listarNombreCursos() {
        return getHibernateTemplate().findByNamedQuery("NombreCurso.findAll");
    }
    
    public List<NombreCurso> listarNombreCursos(String idEspecialidad) {
        return getHibernateTemplate().find("SELECT n FROM NombreCurso n "
                + "WHERE n.idEspecialidad.idEspecialidad = ?", idEspecialidad);
    }
    
    public NombreCurso buscarNombreCurso(Long id) {
        return getHibernateTemplate().get(NombreCurso.class, id);
    }
    
    public Exception insertarNombreCurso(NombreCurso nc) {
        if(nc == null)
            return new NullPointerException("Nombre Curso nulo");
        try {
            getHibernateTemplate().saveOrUpdate(nc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarNombreCurso(NombreCurso nc) {
        if(nc == null)
            return new NullPointerException("Nombre Curso nulo");
        try {
            getHibernateTemplate().delete(nc);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}