/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
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
public class ProvaController implements Serializable{

    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    public ProvaController() {
        provas = ProvaDAO.getInstance().buscarTodos();
        prova = new Prova();
    }

    public void gravar(ActionEvent actionEvent) {
        ProvaDAO.getInstance().merge(prova);
        provas = ProvaDAO.getInstance().buscarTodos();
        prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        ProvaDAO.getInstance().remover(prova.getIdProva());
        provas = ProvaDAO.getInstance().buscarTodos();
        prova = new Prova();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

}
