package com.mycompany.enade.dao;

import com.mycompany.enade.model.Usuario;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario findByEmail(Usuario usuario) {
        return (Usuario) findSingleResult(entityManager.createNamedQuery("Usuario.findByEmail")
                .setParameter("email", usuario.getEmail()));
    }

    public Usuario logIn(Usuario usuario) {
        return (Usuario) findSingleResult(entityManager.createNamedQuery("Usuario.findByEmailAndSenha")
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha()));
    }
    
    public List<Usuario> findAllAlunos() {
        return entityManager.createNamedQuery("Usuario.findAllAlunos").getResultList();
    }

}
