/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.DetallePagosDAO;
import com.instituto.entidades.Alumno;
import com.instituto.entidades.DetallePagos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioDetallePagos {
    @Autowired
    private DetallePagosDAO dao;

    public List<DetallePagos> listarDetallePagos() {
        return dao.listarDetallePagos();
    }

    public List<DetallePagos> listarDetallePagos(Alumno a, String idMes) {
        return dao.listarDetallePagos(a, idMes);
    }

    public List<DetallePagos> listarDetallePagos(Alumno a) {
        return dao.listarDetallePagos(a);
    }

    public DetallePagos buscarDetallePagos(Long idDetalle) {
        return dao.buscarDetallePagos(idDetalle);
    }

    public Exception insertarDetallePagos(DetallePagos dp) {
        return dao.insertarDetallePagos(dp);
    }

    public Exception eliminarDetallePagos(DetallePagos dp) {
        return dao.eliminarDetallePagos(dp);
    }
}
