/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Alumno;
import com.instituto.entidades.Pagos;
import com.instituto.servicios.ServicioPagos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorPagos {
    @Autowired
    private ServicioPagos srv;

    public List<Pagos> listarPagos() {
        return srv.listarPagos();
    }

    public List<Pagos> listarPagos(Alumno a) {
        return srv.listarPagos(a);
    }

    public Pagos buscarPago(String idAlumno, String idMes) {
        return srv.buscarPago(idAlumno, idMes);
    }

    public Pagos buscarPago(Long idPago) {
        return srv.buscarPago(idPago);
    }

    public Exception insertarPago(Pagos p) {
        return srv.insertarPago(p);
    }

    public Exception eliminarPago(Pagos p) {
        return srv.eliminarPago(p);
    }

    public List<Pagos> listarDeudas() {
        return srv.listarDeudas();
    }

    public List<Pagos> listarDeudas(String idMes) {
        return srv.listarDeudas(idMes);
    }

    public List<Pagos> listarDeudas(Alumno a) {
        return srv.listarDeudas(a);
    }

    public List<Pagos> listarDeudas(Alumno a, String idMes) {
        return srv.listarDeudas(a, idMes);
    }
}