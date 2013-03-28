/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.PlanAcademico;
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
public class PlanAcademicoDAO extends HibernateDaoSupport {
    @Autowired
    public PlanAcademicoDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public List<PlanAcademico> listarPlanesAcademicos() {
        return getHibernateTemplate().findByNamedQuery("PlanAcademico.findAll");
    }
    
    public List<PlanAcademico> listarPlanesAcademicos(String idEspecialidad) {
        return getHibernateTemplate().find("SELECT p FROM PlanAcademico p "
                + "WHERE p.idEspecialidad.idEspecialidad = ?", idEspecialidad);
    }
    
    public PlanAcademico buscarPlanAcademico(Long idPlanAcademico) {
        return getHibernateTemplate().get(PlanAcademico.class, idPlanAcademico);
    }
    
    public Exception insertarPlanAcademico(PlanAcademico pa) {
        if(pa == null)
            return new NullPointerException("Plan Academico nulo");
        try {
            getHibernateTemplate().saveOrUpdate(pa);
            
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarPlanAcademico(PlanAcademico pa) {
        if(pa == null)
            return new NullPointerException("Plan Academico nulo");
        try {
            getHibernateTemplate().delete(pa);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}