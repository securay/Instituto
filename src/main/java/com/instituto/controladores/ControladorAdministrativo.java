/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.controladores;

import com.instituto.entidades.Administrativo;
import com.instituto.servicios.ServicioAdministrativo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class ControladorAdministrativo {
    @Autowired
    private ServicioAdministrativo srv;

    public List<Administrativo> listarAdministrativos() {
        return srv.listarAdministrativos();
    }

    public Administrativo buscarAdministrativo(String id) {
        return srv.buscarAdministrativo(id);
    }

    public Exception insertarAdministrativo(Administrativo a) {
        return srv.insertarAdministrativo(a);
    }

    public Exception eliminarAdministrativo(Administrativo a) {
        return srv.eliminarAdministrativo(a);
    }
}