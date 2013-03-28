/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Curso;
import com.instituto.servicios.ServicioCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorCurso {
    @Autowired
    private ServicioCurso srv;

    public List<Curso> listarCursos() {
        return srv.listarCursos();
    }

    public List<Curso> listarCursos(Long idNombreCurso) {
        return srv.listarCursos(idNombreCurso);
    }

    public Curso buscarCurso(String id) {
        return srv.buscarCurso(id);
    }

    public Exception insertarCurso(Curso c) {
        return srv.insertarCurso(c);
    }

    public Exception eliminarCurso(Curso c) {
        return srv.eliminarCurso(c);
    }
}