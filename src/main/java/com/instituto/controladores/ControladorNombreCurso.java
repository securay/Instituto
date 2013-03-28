/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.NombreCurso;
import com.instituto.servicios.ServicioNombreCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorNombreCurso {
    @Autowired
    private ServicioNombreCurso srv;

    public List<NombreCurso> listarNombreCursos() {
        return srv.listarNombreCursos();
    }

    public List<NombreCurso> listarNombreCursos(String idEspecialidad) {
        return srv.listarNombreCursos(idEspecialidad);
    }

    public NombreCurso buscarNombreCurso(Long id) {
        return srv.buscarNombreCurso(id);
    }

    public Exception insertarNombreCurso(NombreCurso nc) {
        return srv.insertarNombreCurso(nc);
    }

    public Exception eliminarNombreCurso(NombreCurso nc) {
        return srv.eliminarNombreCurso(nc);
    }
}