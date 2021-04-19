/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
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
@Path("resultado")
public class ResultadoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosResultados")
    public List<Resultado> TodosResultados() {
        List<Resultado> resultados = ResultadoDAO.getInstance().buscarTodos();
        return resultados;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getResultado/{idResultado}")
    public Resultado GetResultado(@PathParam("idResultado") Integer idResultado) {
        return ResultadoDAO.getInstance().buscar(idResultado);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idResultado}")
    public String Excluir(@PathParam("idResultado") Integer idResultado) {
        try {
            ResultadoDAO.getInstance().remover(idResultado);
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
            ResultadoDAO.getInstance().removerAll();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Resultado resultado) {
        Resultado r = new Resultado();
        try {
            r.setIdResultado(resultado.getIdResultado());
            r.setValorObtido(resultado.getValorObtido());
            r.setProvaidProva(resultado.getProvaidProva());
            r.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
            ResultadoDAO.getInstance().merge(r);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Resultado resultado) {
        Resultado r = new Resultado();
        try {
            r.setIdResultado(resultado.getIdResultado());
            r.setValorObtido(resultado.getValorObtido());
            r.setProvaidProva(resultado.getProvaidProva());
            r.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
            return ResultadoDAO.getInstance().merge(r).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
}