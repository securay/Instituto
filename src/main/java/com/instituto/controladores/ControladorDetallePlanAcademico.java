/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.DetallePlanAcademico;
import com.instituto.servicios.ServicioDetallePlanAcademico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorDetallePlanAcademico {
    @Autowired
    private ServicioDetallePlanAcademico srv;

    public List<DetallePlanAcademico> listarDetallePlanAcademico() {
        return srv.listarDetallePlanAcademico();
    }

    public List<DetallePlanAcademico> listarDetallePlanAcademico(Long idPlanAcademico) {
        return srv.listarDetallePlanAcademico(idPlanAcademico);
    }

    public DetallePlanAcademico buscarDetallePlanAcademico(Long idDetalle) {
        return srv.buscarDetallePlanAcademico(idDetalle);
    }

    public Exception insertarDetallePlanAcademico(DetallePlanAcademico pa) {
        return srv.insertarDetallePlanAcademico(pa);
    }

    public Exception eliminarDetallePlanAcademico(DetallePlanAcademico pa) {
        return srv.eliminarDetallePlanAcademico(pa);
    }
}
