/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
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
@Path("prova")
public class ProvaResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasProvas")
    public List<Prova> TodasProvas() {
        List<Prova> provas = ProvaDAO.getInstance().buscarTodos();
        return provas;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getProva/{idProva}")
    public Prova GetProva(@PathParam("idProva") Integer idProva) {
        return (Prova) ProvaDAO.getInstance().buscar(idProva);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idProva}")
    public String Excluir(@PathParam("idProva") Integer idProva) {
        try {
            Prova prova = new Prova(idProva, null);
            ProvaDAO.getInstance().remover(prova.getIdProva());
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodas")
    public String ExcluirTodas() {
        try {
            ProvaDAO.getInstance().removerAll();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Prova prova) {
        Prova p = new Prova();
        try {
            p.setIdProva(prova.getIdProva());
            p.setDataProva(prova.getDataProva());
            p.setQuestaoList(prova.getQuestaoList());
            p.setResultadoList(prova.getResultadoList());
            ProvaDAO.getInstance().merge(p);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Prova prova) {
        Prova p = new Prova();
        try {
            p.setIdProva(prova.getIdProva());
            p.setDataProva(prova.getDataProva());
            p.setQuestaoList(prova.getQuestaoList());
            p.setResultadoList(prova.getResultadoList());
            return ProvaDAO.getInstance().merge(p).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
}
