package com.mycompany.enade.controller;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Pichau
 */
@Named
@ViewScoped
public class QuestaoController implements Serializable{

    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<>();

    public QuestaoController() {
        questoes = QuestaoDAO.getInstance().buscarTodos();
        questao = new Questao();
    }

    public void gravar(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().merge(questao);
        questoes = QuestaoDAO.getInstance().buscarTodos();
        questao = new Questao();
    }

    public void remover(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().remover(questao.getIdQuestao());
        questoes = QuestaoDAO.getInstance().buscarTodos();
        questao = new Questao();
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
}
