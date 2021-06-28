package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.TipoUsuario;
import javax.ws.rs.Path;


@Path("tipousuario")
public class TipoUsuarioResource extends GenericResource<TipoUsuario, TipoUsuarioDAO> {

    public TipoUsuarioResource() {
        super(TipoUsuarioDAO.class);
    }

}
