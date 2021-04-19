/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Pichau
 */
@Path("usuario")
public class UsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuarios")
    public List<Usuario> TodosUsuarios() {
        List<Usuario> usuarios = UsuarioDAO.getInstance().buscarTodos();
        return usuarios;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getUsuario/{id}")
    public Usuario GetUsuario(@PathParam("id") Integer id) {
        return UsuarioDAO.getInstance().buscar(id);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idUsuario}")
    public String Excluir(@PathParam("idUsuario") Integer idUsuario) {
        try {
            UsuarioDAO.getInstance().remover(idUsuario);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodos")
    public String ExcluirTodos() {
        try {
            UsuarioDAO.getInstance().removerAll();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Usuario usuario) {
        try {
            UsuarioDAO.getInstance().merge(usuario);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Usuario usuario) {
        try {
            return UsuarioDAO.getInstance().merge(usuario).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
}
