/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Profesor;
import com.instituto.servicios.ServicioProfesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorProfesor {
    @Autowired
    private ServicioProfesor srv;

    public List<Profesor> listarProfesores() {
        return srv.listarProfesores();
    }

    public Profesor buscarProfesor(String id) {
        return srv.buscarProfesor(id);
    }

    public Exception insertarProfesor(Profesor p) {
        return srv.insertarProfesor(p);
    }

    public Exception eliminarProfesor(Profesor p) {
        return srv.eliminarProfesor(p);
    }
}