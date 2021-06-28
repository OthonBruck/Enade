package com.mycompany.enade.resources;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
import javax.ws.rs.Path;

@Path("usuario")
public class UsuarioResource extends GenericResource<Usuario, UsuarioDAO> {

    public UsuarioResource() {
        super(UsuarioDAO.class);
    }

}
