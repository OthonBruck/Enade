package com.mycompany.enade.dao;

import com.mycompany.enade.model.Prova;
import java.util.Date;

public class ProvaDAO extends GenericDAO<Prova, Integer> {

    public ProvaDAO() {
        super(Prova.class);
    }

    public Prova findUltimaProvaAtiva(Integer idAluno) {
        final String jpql = " SELECT p FROM Prova p "
                + " LEFT JOIN p.resultadoList r "
                + " WHERE p.dataProva >= :dataProva AND (r.usuarioidUsuario IS NULL OR r.usuarioidUsuario.idUsuario <> :idAluno)";
        return (Prova) findSingleResult(entityManager.createQuery(jpql)
                .setParameter("dataProva", new Date())
                .setParameter("idAluno", idAluno));
    }

}
