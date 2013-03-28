/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.CursoDAO;
import com.instituto.entidades.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioCurso {
    @Autowired
    private CursoDAO dao;

    public List<Curso> listarCursos() {
        return dao.listarCursos();
    }

    public List<Curso> listarCursos(Long idNombreCurso) {
        return dao.listarCursos(idNombreCurso);
    }

    public Curso buscarCurso(String id) {
        return dao.buscarCurso(id);
    }

    public Exception insertarCurso(Curso c) {
        return dao.insertarCurso(c);
    }

    public Exception eliminarCurso(Curso c) {
        return dao.eliminarCurso(c);
    }
}