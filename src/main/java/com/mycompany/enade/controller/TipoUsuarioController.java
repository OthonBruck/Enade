package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.TipoUsuario;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@SessionScoped
public class TipoUsuarioController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<TipoUsuarioDAO> daoClass;

    TipoUsuario tipoUsuario = new TipoUsuario();
    List<TipoUsuario> tipoUsuarios = new ArrayList<>();

    public TipoUsuarioController() {
        daoClass = TipoUsuarioDAO.class;
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(tipoUsuario);
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(tipoUsuario.getIdTipoUsuario());
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }
    
    public void onRowEdit(RowEditEvent event) {
        TipoUsuario obj = (TipoUsuario) event.getObject();
        setTipoUsuario(obj);
        gravar(null);
        FacesMessage msg = new FacesMessage("Editado", obj.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<TipoUsuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

}
