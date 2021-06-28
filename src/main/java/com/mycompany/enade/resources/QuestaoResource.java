package com.mycompany.enade.resources;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
import javax.ws.rs.Path;

@Path("questao")
public class QuestaoResource extends GenericResource<Questao, QuestaoDAO> {

    public QuestaoResource() {
        super(QuestaoDAO.class);
    }

}
