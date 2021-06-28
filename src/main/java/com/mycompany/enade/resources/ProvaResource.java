package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
import javax.ws.rs.Path;

@Path("prova")
public class ProvaResource extends GenericResource<Prova, ProvaDAO> {

    public ProvaResource() {
        super(ProvaDAO.class);
    }

}
