/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.NombreCursoDAO;
import com.instituto.entidades.NombreCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioNombreCurso {
    @Autowired
    private NombreCursoDAO dao;

    public List<NombreCurso> listarNombreCursos() {
        return dao.listarNombreCursos();
    }

    public List<NombreCurso> listarNombreCursos(String idEspecialidad) {
        return dao.listarNombreCursos(idEspecialidad);
    }

    public NombreCurso buscarNombreCurso(Long id) {
        return dao.buscarNombreCurso(id);
    }

    public Exception insertarNombreCurso(NombreCurso nc) {
        return dao.insertarNombreCurso(nc);
    }

    public Exception eliminarNombreCurso(NombreCurso nc) {
        return dao.eliminarNombreCurso(nc);
    }
}