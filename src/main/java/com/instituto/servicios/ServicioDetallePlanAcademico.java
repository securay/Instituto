/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.DetallePlanAcademicoDAO;
import com.instituto.entidades.DetallePlanAcademico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioDetallePlanAcademico {
    @Autowired
    private DetallePlanAcademicoDAO dao;

    public List<DetallePlanAcademico> listarDetallePlanAcademico() {
        return dao.listarDetallePlanAcademico();
    }

    public List<DetallePlanAcademico> listarDetallePlanAcademico(Long idPlanAcademico) {
        return dao.listarDetallePlanAcademico(idPlanAcademico);
    }

    public DetallePlanAcademico buscarDetallePlanAcademico(Long idDetalle) {
        return dao.buscarDetallePlanAcademico(idDetalle);
    }

    public Exception insertarDetallePlanAcademico(DetallePlanAcademico pa) {
        return dao.insertarDetallePlanAcademico(pa);
    }

    public Exception eliminarDetallePlanAcademico(DetallePlanAcademico pa) {
        return dao.eliminarDetallePlanAcademico(pa);
    }
}
