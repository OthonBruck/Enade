/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Resultado;

/**
 *
 * @author Pichau
 */
public class ResultadoDAO extends GenericDAO<Resultado, Integer> {

    public static ResultadoDAO resultadoDAO;

    public ResultadoDAO() {
        super(Resultado.class);
    }

    public static ResultadoDAO getInstance() {
        if (resultadoDAO == null) {
            resultadoDAO = new ResultadoDAO();
        }
        return resultadoDAO;
    }

}