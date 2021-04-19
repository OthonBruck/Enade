/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
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
@Path("questao")
public class QuestaoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasQuestoes")
    public List<Questao> TodasQuestoes() {
        List<Questao> questoes = QuestaoDAO.getInstance().buscarTodos();
        return questoes;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getQuestao/{idQuestao}")
    public Questao GetQuestao(@PathParam("idQuestao") Integer idQuestao) {
        return QuestaoDAO.getInstance().buscar(idQuestao);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idQuestao}")
    public String Excluir(@PathParam("idQuestao") Integer idQuestao) {
        try {
            Questao questao = new Questao(idQuestao, null);
            QuestaoDAO.getInstance().remover(questao.getIdQuestao());
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
            QuestaoDAO.getInstance().removerAll();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Questao questao) {
        try {
            QuestaoDAO.getInstance().merge(questao);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Questao questao) {
        try {
            return QuestaoDAO.getInstance().merge(questao).toString();
        } catch (Exception e) {
            return "Erro ao atualizar um registro! " + e.getMessage();
        }
    }
}