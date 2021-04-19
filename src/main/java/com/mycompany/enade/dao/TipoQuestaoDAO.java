package com.mycompany.enade.dao;

import com.mycompany.enade.model.TipoQuestao;

/**
 *
 * @author Pichau
 */
public class TipoQuestaoDAO extends GenericDAO<TipoQuestao, Integer> {

    public static TipoQuestaoDAO tipoQuestaoDAO;

    public TipoQuestaoDAO() {
        super(TipoQuestao.class);
    }

    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }

}
