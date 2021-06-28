/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
import com.mycompany.enade.util.Constants;
import com.mycompany.enade.util.EncryptUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<UsuarioDAO> daoClass;

    private final UsuarioController usuarioController;
    private Usuario usuarioLogin;
    private Usuario usuarioCadastro;

    public LoginController() {
        daoClass = UsuarioDAO.class;
        usuarioController = new UsuarioController();
        usuarioLogin = new Usuario();
        usuarioCadastro = new Usuario();
    }

    public String cadastrar() {
        Usuario usuarioFind = factoryDAO.getInstance(daoClass).findByEmail(usuarioCadastro);
        if (usuarioFind == null) {
            Usuario usuarioPersisted = usuarioController.salvarUsuario(usuarioCadastro, false);
            setUsuarioLogin(usuarioPersisted);

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO, usuarioLogin);
            return Constants.URL_INDEX;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail já cadastrado. Por favor faça o login!", null));
            return null;
        }
    }

    public String login() {
        usuarioLogin.setSenha(EncryptUtil.encrypt(usuarioLogin.getSenha()));
        Usuario usuarioFind = factoryDAO.getInstance(daoClass).logIn(usuarioLogin);
        if (usuarioFind == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail ou senha inválidos!", null));
            return null;
        } else {
            setUsuarioLogin(usuarioFind);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO, usuarioLogin);
            return Constants.URL_INDEX;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return Constants.URL_LOGIN;
    }

    public String goHome() {
        return Constants.URL_INDEX;
    }

    public boolean isProfessor() {
        return usuarioLogin.getTipoUsuarioidTipoUsuario().getNomeTipoUsuario().equals("Professor");
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

}
