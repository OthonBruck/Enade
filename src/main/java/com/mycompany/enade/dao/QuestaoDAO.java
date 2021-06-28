package com.mycompany.enade.dao;

import com.mycompany.enade.model.Questao;
import java.util.List;


public class QuestaoDAO extends GenericDAO<Questao, Integer> {

    public QuestaoDAO() {
        super(Questao.class);
    }

    public List<Questao> findQuestoesAtivas() {
        return entityManager.createNamedQuery("Questao.findByEstadoQuestao", Questao.class)
                .setParameter("estadoQuestao", true).getResultList();
    }

}
