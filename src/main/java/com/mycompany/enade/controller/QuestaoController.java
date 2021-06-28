/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author mycompany
 */
@Named
@SessionScoped
public class QuestaoController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<QuestaoDAO> daoClass;

    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<>();
    List<Questao> questoesAtivas = new ArrayList<>();

    public QuestaoController() {
        daoClass = QuestaoDAO.class;
        questoes = factoryDAO.getInstance(daoClass).findAll();
        questoesAtivas = factoryDAO.getInstance(daoClass).findQuestoesAtivas();
        questao = new Questao();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(questao);
        questoes = factoryDAO.getInstance(daoClass).findAll();
        questoesAtivas = factoryDAO.getInstance(daoClass).findQuestoesAtivas();
        questao = new Questao();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(questao.getIdQuestao());
        questoes = factoryDAO.getInstance(daoClass).findAll();
        questoesAtivas = factoryDAO.getInstance(daoClass).findQuestoesAtivas();
        questao = new Questao();
    }

    public void onRowEdit(RowEditEvent event) {
        Questao obj = (Questao) event.getObject();
        setQuestao(obj);
        gravar(null);
        FacesMessage msg = new FacesMessage("Editado", obj.getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Questao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Questao> getQuestoesAtivas() {
        return questoesAtivas;
    }

    public void setQuestoesAtivas(List<Questao> questoesAtivas) {
        this.questoesAtivas = questoesAtivas;
    }

}
