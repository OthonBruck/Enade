/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
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
public class UsuarioController implements Serializable{
    

    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        usuarios = UsuarioDAO.getInstance().buscarTodos();
        usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        UsuarioDAO.getInstance().merge(usuario);
        usuarios = UsuarioDAO.getInstance().buscarTodos();
        usuario = new Usuario();
    }

    public void remover(ActionEvent actionEvent) {
        UsuarioDAO.getInstance().remover(usuario.getIdUsuario());
        usuarios = UsuarioDAO.getInstance().buscarTodos();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}