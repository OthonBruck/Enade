package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.TipoUsuario;
import com.mycompany.enade.model.Usuario;
import com.mycompany.enade.util.EncryptUtil;
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
public class UsuarioController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<UsuarioDAO> daoClass;

    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<>();

    String senha1;
    String senha2;

    public UsuarioController() {
        daoClass = UsuarioDAO.class;
        usuarios = factoryDAO.getInstance(daoClass).findAll();
        usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        salvarUsuario(usuario, true);
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(usuario.getIdUsuario());
        usuarios = factoryDAO.getInstance(daoClass).findAll();
        usuario = new Usuario();
    }

    public void atualizarSenha(ActionEvent actionEvent) {
        if (senha1 != null && senha2 != null && senha1.equals(senha2)) {
            usuario = factoryDAO.getInstance(daoClass).find(usuario.getIdUsuario());
            usuario.setSenha(senha1);
            gravar(null);
            FacesMessage msg = new FacesMessage("Editado", "Senha alterada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Cancelado", "Senhas não conferem!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Usuario salvarUsuario(Usuario u, boolean buscarUsuarios) {
        u.setSenha(EncryptUtil.encrypt(u.getSenha()));
        if (u.getTipoUsuarioidTipoUsuario() == null) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(1);
            tipoUsuario.setNomeTipoUsuario("Aluno");
            u.setTipoUsuarioidTipoUsuario(tipoUsuario);
        }
        Usuario usuarioPersisted = factoryDAO.getInstance(daoClass).merge(u);
        if (buscarUsuarios) {
            usuarios = factoryDAO.getInstance(daoClass).findAll();
            usuario = new Usuario();
        }
        return usuarioPersisted;
    }
    
    public Usuario editarUsuario(Usuario u, boolean buscarUsuarios) {
        if (u.getTipoUsuarioidTipoUsuario() == null) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(1);
            tipoUsuario.setNomeTipoUsuario("Aluno");
            u.setTipoUsuarioidTipoUsuario(tipoUsuario);
        }
        Usuario usuarioPersisted = factoryDAO.getInstance(daoClass).merge(u);
        if (buscarUsuarios) {
            usuarios = factoryDAO.getInstance(daoClass).findAll();
            usuario = new Usuario();
        }
        return usuarioPersisted;
    }

    public void onRowEdit(RowEditEvent event) {
        Usuario obj = (Usuario) event.getObject();
        setUsuario(obj);
        editarUsuario(usuario, true);
        FacesMessage msg = new FacesMessage("Editado", obj.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

}
