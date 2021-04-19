/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public static UsuarioDAO UsuarioDAO;

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public static UsuarioDAO getInstance() {
        if (UsuarioDAO == null) {
            UsuarioDAO = new UsuarioDAO();
        }
        return UsuarioDAO;
    }

}
