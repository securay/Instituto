/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.DAO;

import com.instituto.entidades.Administrativo;
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
public class AdministrativoDAO extends HibernateDaoSupport {
    @Autowired
    public AdministrativoDAO(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    
    public List<Administrativo> listarAdministrativos() {
        return getHibernateTemplate().findByNamedQuery("Administrativo.findAll");
    }
    
    public Administrativo buscarAdministrativo(String id) {
        return getHibernateTemplate().get(Administrativo.class, id);
    }
    
    public Exception insertarAdministrativo(Administrativo a) {
        if(a == null)
            return new NullPointerException("Administrativo nulo");
        try {
            getHibernateTemplate().saveOrUpdate(a);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
    
    public Exception eliminarAdministrativo(Administrativo a) {
        if(a == null)
            return new NullPointerException("Administrativo nulo");
        try {
            getHibernateTemplate().delete(a);
            return null;
        } catch (DataAccessException ex) {
            return ex;
        }
    }
}