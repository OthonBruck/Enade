package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
import javax.ws.rs.Path;

@Path("resultado")
public class ResultadoResource extends GenericResource<Resultado, ResultadoDAO> {

    public ResultadoResource() {
        super(ResultadoDAO.class);
    }

}
