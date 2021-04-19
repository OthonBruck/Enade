/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.TipoUsuario;
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
@Path("tipousuario")
public class TipoUsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario")
    public List<TipoUsuario> TodosTipoUsuario() {
        List<TipoUsuario> tipoUsuario = TipoUsuarioDAO.getInstance().buscarTodos();
        return tipoUsuario;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoUsuario/{id}")
    public TipoUsuario GetTipoUsuario(@PathParam("id") Integer id) {
        return TipoUsuarioDAO.getInstance().buscar(id);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            TipoUsuarioDAO.getInstance().remover(codigo);
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
            TipoUsuarioDAO.getInstance().removerAll();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoUsuario tipoUsuario) {
        TipoUsuario tu = new TipoUsuario();
        try {
            tu.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            TipoUsuarioDAO.getInstance().merge(tu);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoUsuario tipoUsuario) {
        TipoUsuario tu = new TipoUsuario();
        try {
            tu.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            return TipoUsuarioDAO.getInstance().merge(tu).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
}