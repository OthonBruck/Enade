package com.mycompany.enade.controller;

import com.google.common.hash.Hashing;
import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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
        String senhaCriptografada = Hashing.sha256().hashString(usuario.getSenha(), StandardCharsets.UTF_8).toString();
        usuario.setSenha(senhaCriptografada);
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