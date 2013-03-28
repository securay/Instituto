/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Alumno;
import com.instituto.entidades.DetallePagos;
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
public class DetallePagosDAO extends HibernateDaoSupport {
    @Autowired

    public DetallePagosDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public List<DetallePagos> listarDetallePagos() {
        return getHibernateTemplate().findByNamedQuery("DetallePagos.findAll");
    }
    
    public List<DetallePagos> listarDetallePagos(Alumno a, String idMes) {
        return getHibernateTemplate().find("SELECT dp FROM DetallePagos dp "
                + "WHERE dp.idAlumno.idAlumno = '" + a.getIdAlumno()
                + "' AND dp.idMes = '" + idMes + "'");
    }
    
    public List<DetallePagos> listarDetallePagos(Alumno a) {
        return getHibernateTemplate().find("SELECT dp FROM DetallePagos dp "
                + "WHERE dp.idAlumno.idAlumno = '" + a.getIdAlumno() + "'");
    }
    
    public DetallePagos buscarDetallePagos(Long idDetalle) {
        return getHibernateTemplate().get(DetallePagos.class, idDetalle);
    }
    
    public Exception insertarDetallePagos(DetallePagos dp) {
        if(dp == null)
            return new NullPointerException("Detalle Pago nulo");
        try {
            getHibernateTemplate().saveOrUpdate(dp);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarDetallePagos(DetallePagos dp) {
        if(dp == null)
            return new NullPointerException("Detalle Pago nulo");
        try {
            getHibernateTemplate().delete(dp);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}