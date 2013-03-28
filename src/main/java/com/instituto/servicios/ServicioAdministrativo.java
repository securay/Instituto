/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.AdministrativoDAO;
import com.instituto.entidades.Administrativo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioAdministrativo {
    @Autowired
    private AdministrativoDAO dao;

    public List<Administrativo> listarAdministrativos() {
        return dao.listarAdministrativos();
    }

    public Administrativo buscarAdministrativo(String id) {
        return dao.buscarAdministrativo(id);
    }

    public Exception insertarAdministrativo(Administrativo a) {
        return dao.insertarAdministrativo(a);
    }

    public Exception eliminarAdministrativo(Administrativo a) {
        return dao.eliminarAdministrativo(a);
    }
}