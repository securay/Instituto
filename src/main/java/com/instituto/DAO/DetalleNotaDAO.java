/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.DetalleNota;
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
public class DetalleNotaDAO extends HibernateDaoSupport {
    @Autowired

    public DetalleNotaDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<DetalleNota> listarDetalleNotas() {
        return getHibernateTemplate().findByNamedQuery("DetalleNota.findAll");
    }
    
    public DetalleNota buscarDetalleNota(Long id) {
        return getHibernateTemplate().get(DetalleNota.class, id);
    }
    
    public Exception insertarDetalleNota(DetalleNota dn) {
        if(dn == null)
            return new NullPointerException("Detalle Nota nulo");
        try {
            getHibernateTemplate().saveOrUpdate(dn);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarDetalleNota(DetalleNota dn) {
        if(dn == null)
            return new NullPointerException("Detalle Nota nulo");
        try {
            getHibernateTemplate().delete(dn);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}