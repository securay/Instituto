/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Alumno;
import com.instituto.servicios.ServicioAlumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorAlumno {
    @Autowired
    private ServicioAlumno srv;

    public List<Alumno> listarAlumnos() {
        return srv.listarAlumnos();
    }

    public Alumno buscarAlumno(String id) {
        return srv.buscarAlumno(id);
    }

    public Exception insertarAlumno(Alumno a) {
        return srv.insertarAlumno(a);
    }

    public Exception eliminarAlumno(Alumno a) {
        return srv.eliminarAlumno(a);
    }
}