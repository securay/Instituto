/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.servicios;

import com.instituto.DAO.DetalleNotaDAO;
import com.instituto.entidades.DetalleNota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ServicioDetalleNota {
    @Autowired
    private DetalleNotaDAO dao;

    public List<DetalleNota> listarDetalleNotas() {
        return dao.listarDetalleNotas();
    }

    public DetalleNota buscarDetalleNota(Long id) {
        return dao.buscarDetalleNota(id);
    }

    public Exception insertarDetalleNota(DetalleNota dn) {
        return dao.insertarDetalleNota(dn);
    }

    public Exception eliminarDetalleNota(DetalleNota dn) {
        return dao.eliminarDetalleNota(dn);
    }
}