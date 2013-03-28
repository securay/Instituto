/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Periodo;
import com.instituto.servicios.ServicioPeriodo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorPeriodo {
    @Autowired
    private ServicioPeriodo srv;

    public List<Periodo> listarPeriodo() {
        return srv.listarPeriodo();
    }

    public Periodo buscarNombreCurso(String id) {
        return srv.buscarNombreCurso(id);
    }

    public Exception insertarPeriodo(Periodo nc) {
        return srv.insertarPeriodo(nc);
    }

    public Exception eliminarNombreCurso(Periodo nc) {
        return srv.eliminarNombreCurso(nc);
    }
}