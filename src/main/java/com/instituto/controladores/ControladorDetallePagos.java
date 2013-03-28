/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Alumno;
import com.instituto.entidades.DetallePagos;
import com.instituto.servicios.ServicioDetallePagos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorDetallePagos {
    @Autowired
    private ServicioDetallePagos srv;

    public List<DetallePagos> listarDetallePagos() {
        return srv.listarDetallePagos();
    }

    public List<DetallePagos> listarDetallePagos(Alumno a, String idMes) {
        return srv.listarDetallePagos(a, idMes);
    }

    public List<DetallePagos> listarDetallePagos(Alumno a) {
        return srv.listarDetallePagos(a);
    }

    public DetallePagos buscarDetallePagos(Long idDetalle) {
        return srv.buscarDetallePagos(idDetalle);
    }

    public Exception insertarDetallePagos(DetallePagos dp) {
        return srv.insertarDetallePagos(dp);
    }

    public Exception eliminarDetallePagos(DetallePagos dp) {
        return srv.eliminarDetallePagos(dp);
    }
}