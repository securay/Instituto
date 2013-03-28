/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.ProfesorDAO;
import com.instituto.entidades.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioProfesor {
    @Autowired
    private ProfesorDAO dao;

    public List<Profesor> listarProfesores() {
        return dao.listarProfesores();
    }

    public Profesor buscarProfesor(String id) {
        return dao.buscarProfesor(id);
    }

    public Exception insertarProfesor(Profesor p) {
        return dao.insertarProfesor(p);
    }

    public Exception eliminarProfesor(Profesor p) {
        return dao.eliminarProfesor(p);
    }
}