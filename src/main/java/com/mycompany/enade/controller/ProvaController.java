/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
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
public class ProvaController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<ProvaDAO> daoClass;

    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    public ProvaController() {
        daoClass = ProvaDAO.class;
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(prova);
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(prova.getIdProva());
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public void onRowEdit(RowEditEvent event) {
        Prova obj = (Prova) event.getObject();
        setProva(obj);
        gravar(null);
        FacesMessage msg = new FacesMessage("Editado", obj.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Prova> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
