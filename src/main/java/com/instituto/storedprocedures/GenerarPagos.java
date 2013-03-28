/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.storedprocedures;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 *
 * @author root
 */
public class GenerarPagos extends StoredProcedure {
    double monto;
    public GenerarPagos(DataSource ds, double monto) {
        super(ds, "sp_generarpagos");
        this.monto= monto;
        declareParameter(new SqlParameter("Monto", Types.NUMERIC));
        compile();
        
    }
    
    public Map generar() throws DataAccessException {
        Map inParam= new HashMap();
        inParam.put("Monto", monto);
        return execute(inParam);
    }
}