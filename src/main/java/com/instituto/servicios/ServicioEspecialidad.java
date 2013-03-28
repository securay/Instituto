/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.EspecialidadDAO;
import com.instituto.entidades.Especialidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioEspecialidad {
    @Autowired
    private EspecialidadDAO dao;

    public List<Especialidad> listarEspecialidades() {
        return dao.listarEspecialidades();
    }

    public Especialidad buscarEspecialidad(String id) {
        return dao.buscarEspecialidad(id);
    }

    public Exception insertarEspecialidad(Especialidad e) {
        return dao.insertarEspecialidad(e);
    }

    public Exception eliminarEspecialidad(Especialidad e) {
        return dao.eliminarEspecialidad(e);
    }
}