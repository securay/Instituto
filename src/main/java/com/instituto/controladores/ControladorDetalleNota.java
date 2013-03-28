/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.DetalleNota;
import com.instituto.servicios.ServicioDetalleNota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorDetalleNota {
    @Autowired
    private ServicioDetalleNota srv;

    public List<DetalleNota> listarDetalleNotas() {
        return srv.listarDetalleNotas();
    }

    public DetalleNota buscarDetalleNota(Long id) {
        return srv.buscarDetalleNota(id);
    }

    public Exception insertarDetalleNota(DetalleNota dn) {
        return srv.insertarDetalleNota(dn);
    }

    public Exception eliminarDetalleNota(DetalleNota dn) {
        return srv.eliminarDetalleNota(dn);
    }
}