/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.TipoQuestao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Pichau
 */

@Named
@ViewScoped
public class TipoQuestaoController implements Serializable{

    TipoQuestao tipoQuestao = new TipoQuestao();
    List<TipoQuestao> tipoQuestoes = new ArrayList<>();

    public TipoQuestaoController() {
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new TipoQuestao();
    }

    public void gravar(ActionEvent actionEvent) {
        TipoQuestaoDAO.getInstance().merge(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new TipoQuestao();
    }

    public void remover(ActionEvent actionEvent) {
        TipoQuestaoDAO.getInstance().remover(tipoQuestao.getIdTipoQuestao());
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new TipoQuestao();
    }

    public TipoQuestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(TipoQuestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public List<TipoQuestao> getTipoQuestoes() {
        return tipoQuestoes;
    }

    public void setTipoQuestoes(List<TipoQuestao> tipoQuestoes) {
        this.tipoQuestoes = tipoQuestoes;
    }

}