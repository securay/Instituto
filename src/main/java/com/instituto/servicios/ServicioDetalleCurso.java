/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.DetalleCursoDAO;
import com.instituto.entidades.DetalleCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioDetalleCurso {
    @Autowired
    private DetalleCursoDAO dao;

    public List<DetalleCurso> listarDetCursos() {
        return dao.listarDetCursos();
    }

    public DetalleCurso buscarDetalleCurso(Long id) {
        return dao.buscarDetalleCurso(id);
    }

    public Exception insertarDetalleCurso(DetalleCurso dc) {
        return dao.insertarDetalleCurso(dc);
    }

    public Exception eliminarDetalleCurso(DetalleCurso dc) {
        return dao.eliminarDetalleCurso(dc);
    }
}