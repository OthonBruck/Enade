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
import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Pichau
 */

@ManagedBean()
@ViewScoped
public class TipoQuestaoController implements Serializable {
    
    TipoQuestao tipoQuestao = new TipoQuestao();
    List<TipoQuestao> tipoQuestoes = new ArrayList<TipoQuestao>();

    public TipoQuestaoController() {
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
    
    public void gravar(ActionEvent actionEvent){
        TipoQuestaoDAO.getInstance().atualizar(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
    
    public void remover(ActionEvent actionEvent){
        TipoQuestaoDAO.getInstance().atualizar(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas();
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
