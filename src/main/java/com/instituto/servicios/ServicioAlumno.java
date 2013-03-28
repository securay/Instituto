/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.AlumnoDAO;
import com.instituto.entidades.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioAlumno {
    @Autowired
    private AlumnoDAO dao;

    public List<Alumno> listarAlumnos() {
        return dao.listarAlumnos();
    }

    public Alumno buscarAlumno(String id) {
        return dao.buscarAlumno(id);
    }

    public Exception insertarAlumno(Alumno a) {
        return dao.insertarAlumno(a);
    }

    public Exception eliminarAlumno(Alumno a) {
        return dao.eliminarAlumno(a);
    }
}