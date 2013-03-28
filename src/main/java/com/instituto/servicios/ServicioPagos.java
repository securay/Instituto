/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.PagosDAO;
import com.instituto.entidades.Alumno;
import com.instituto.entidades.Pagos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioPagos {
    @Autowired
    private PagosDAO dao;

    public List<Pagos> listarPagos() {
        return dao.listarPagos();
    }

    public List<Pagos> listarPagos(Alumno a) {
        return dao.listarPagos(a);
    }

    public Pagos buscarPago(String idAlumno, String idMes) {
        return dao.buscarPago(idAlumno, idMes);
    }

    public Pagos buscarPago(Long idPago) {
        return dao.buscarPago(idPago);
    }

    public Exception insertarPago(Pagos p) {
        return dao.insertarPago(p);
    }

    public Exception eliminarPago(Pagos p) {
        return dao.eliminarPago(p);
    }

    public List<Pagos> listarDeudas() {
        return dao.listarDeudas();
    }

    public List<Pagos> listarDeudas(String idMes) {
        return dao.listarDeudas(idMes);
    }

    public List<Pagos> listarDeudas(Alumno a) {
        return dao.listarDeudas(a);
    }

    public List<Pagos> listarDeudas(Alumno a, String idMes) {
        return dao.listarDeudas(a, idMes);
    }
}