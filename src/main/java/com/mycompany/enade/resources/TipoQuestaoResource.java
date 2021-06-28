package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.TipoQuestao;
import javax.ws.rs.Path;

@Path("tipoquestao")
public class TipoQuestaoResource extends GenericResource<TipoQuestao, TipoQuestaoDAO> {

    public TipoQuestaoResource() {
        super(TipoQuestaoDAO.class);
    }

}
