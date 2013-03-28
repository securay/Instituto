/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.PlanAcademicoDAO;
import com.instituto.entidades.PlanAcademico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioPlanAcademico {
    @Autowired
    private PlanAcademicoDAO dao;

    public List<PlanAcademico> listarPlanesAcademicos() {
        return dao.listarPlanesAcademicos();
    }

    public PlanAcademico buscarPlanAcademico(Long idPlanAcademico) {
        return dao.buscarPlanAcademico(idPlanAcademico);
    }

    public Exception insertarPlanAcademico(PlanAcademico pa) {
        return dao.insertarPlanAcademico(pa);
    }

    public Exception eliminarPlanAcademico(PlanAcademico pa) {
        return dao.eliminarPlanAcademico(pa);
    }
}