/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.DetalleCurso;
import com.instituto.servicios.ServicioDetalleCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorDetalleCurso {
    @Autowired
    private ServicioDetalleCurso srv;

    public List<DetalleCurso> listarDetCursos() {
        return srv.listarDetCursos();
    }

    public DetalleCurso buscarDetalleCurso(Long id) {
        return srv.buscarDetalleCurso(id);
    }

    public Exception insertarDetalleCurso(DetalleCurso dc) {
        return srv.insertarDetalleCurso(dc);
    }

    public Exception eliminarDetalleCurso(DetalleCurso dc) {
        return srv.eliminarDetalleCurso(dc);
    }
}