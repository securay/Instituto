/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Especialidad;
import com.instituto.servicios.ServicioEspecialidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorEspecialidad {
    @Autowired
    private ServicioEspecialidad srv;

    public List<Especialidad> listarEspecialidades() {
        return srv.listarEspecialidades();
    }

    public Especialidad buscarEspecialidad(String id) {
        return srv.buscarEspecialidad(id);
    }

    public Exception insertarEspecialidad(Especialidad e) {
        return srv.insertarEspecialidad(e);
    }

    public Exception eliminarEspecialidad(Especialidad e) {
        return srv.eliminarEspecialidad(e);
    }
}