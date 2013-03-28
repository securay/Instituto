/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.DetallePlanAcademico;
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
public class DetallePlanAcademicoDAO extends HibernateDaoSupport {
    @Autowired

    public DetallePlanAcademicoDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public List<DetallePlanAcademico> listarDetallePlanAcademico() {
        return getHibernateTemplate().findByNamedQuery("DetallePlanAcademico.findAll");
    }
    
    public List<DetallePlanAcademico> listarDetallePlanAcademico(Long idPlanAcademico) {
        return getHibernateTemplate().find("SELECT d FROM DetallePlanAcademico d "
                + "WHERE d.idPlanAcademico.idPlanAcademico = " + idPlanAcademico);
    }
    
    public DetallePlanAcademico buscarDetallePlanAcademico(Long idDetalle) {
        return getHibernateTemplate().get(DetallePlanAcademico.class, idDetalle);
    }
    
    public Exception insertarDetallePlanAcademico(DetallePlanAcademico pa) {
        if(pa == null)
            return new NullPointerException("Detalle Plan Academico nulo");
        try {
            getHibernateTemplate().saveOrUpdate(pa);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarDetallePlanAcademico(DetallePlanAcademico pa) {
        if(pa == null)
            return new NullPointerException("Detalle Plan Academico nulo");
        try {
            getHibernateTemplate().delete(pa);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}