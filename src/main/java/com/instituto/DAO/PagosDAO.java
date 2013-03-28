/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Alumno;
import com.instituto.entidades.Pagos;
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
public class PagosDAO extends HibernateDaoSupport {
    @Autowired

    public PagosDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public List<Pagos> listarPagos() {
        return getHibernateTemplate().findByNamedQuery("Pagos.findAll");
    }
    
    public List<Pagos> listarPagos(Alumno a) {
        return getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.idAlumno.idAlumno = ?", a.getIdAlumno() );
    }
    
    public Pagos buscarPago(String idAlumno, String idMes) {
        List<Pagos> pgs= getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.idMes = ? AND "
                + "p.idAlumno.idAlumno = ?", idMes, idAlumno);
        if(pgs.isEmpty()) return null;
        else return pgs.get(0);
    }
    
    public List<Pagos> listarDeudas() {
        return getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.deuda = 1");
    }
    
    public List<Pagos> listarDeudas(String idMes) {
        return getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.idMes = ? AND "
                + "p.deuda = 1", idMes);
    }
    
    public List<Pagos> listarDeudas(Alumno a) {
        return getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.idAlumno.idAlumno = '" + a.getIdAlumno() + "' AND "
                + "p.deuda = 1");
    }
    
    public List<Pagos> listarDeudas(Alumno a, String idMes) {
        return getHibernateTemplate().find("SELECT p FROM Pagos p "
                + "WHERE p.idAlumno.idAlumno = ? AND "
                + "p.idMes = ? AND "
                + "p.deuda = 1", a.getIdAlumno(),idMes);
    }
    
    public Pagos buscarPago(Long idPago) {
        return getHibernateTemplate().get(Pagos.class, idPago);
    }
    
    public Exception insertarPago(Pagos p) {
        if(p == null)
            return new NullPointerException("Pago nulo");
        try {
            getHibernateTemplate().saveOrUpdate(p);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarPago(Pagos p) {
        if(p == null)
            return new NullPointerException("Pago nulo");
        try {
            getHibernateTemplate().delete(p);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}