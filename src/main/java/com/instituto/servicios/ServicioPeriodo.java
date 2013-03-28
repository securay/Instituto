/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.PeriodoDAO;
import com.instituto.entidades.Periodo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioPeriodo {
    @Autowired
    private PeriodoDAO dao;

    public List<Periodo> listarPeriodo() {
        return dao.listarPeriodo();
    }

    public Periodo buscarNombreCurso(String id) {
        return dao.buscarNombreCurso(id);
    }

    public Exception insertarPeriodo(Periodo nc) {
        return dao.insertarPeriodo(nc);
    }

    public Exception eliminarNombreCurso(Periodo nc) {
        return dao.eliminarNombreCurso(nc);
    }
}