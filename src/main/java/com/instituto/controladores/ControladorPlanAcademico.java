/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.PlanAcademico;
import com.instituto.servicios.ServicioPlanAcademico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorPlanAcademico {
    @Autowired
    private ServicioPlanAcademico srv;

    public List<PlanAcademico> listarPlanesAcademicos() {
        return srv.listarPlanesAcademicos();
    }

    public PlanAcademico buscarPlanAcademico(Long idPlanAcademico) {
        return srv.buscarPlanAcademico(idPlanAcademico);
    }

    public Exception insertarPlanAcademico(PlanAcademico pa) {
        return srv.insertarPlanAcademico(pa);
    }

    public Exception eliminarPlanAcademico(PlanAcademico pa) {
        return srv.eliminarPlanAcademico(pa);
    }

    public List<PlanAcademico> listarPlanesAcademicos(String idEspecialidad) {
        return srv.listarPlanesAcademicos(idEspecialidad);
    }
}