package com.mycompany.enade.model;

import com.mycompany.enade.model.Prova;
import com.mycompany.enade.model.TipoQuestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-18T20:51:01")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, String> alternativaE;
    public static volatile SingularAttribute<Questao, String> alternativaD;
    public static volatile SingularAttribute<Questao, String> alternativaC;
    public static volatile SingularAttribute<Questao, String> alternativaB;
    public static volatile SingularAttribute<Questao, String> alternativaA;
    public static volatile ListAttribute<Questao, Prova> provaList;
    public static volatile SingularAttribute<Questao, Integer> idQuestao;
    public static volatile SingularAttribute<Questao, String> descricaoQuestao;
    public static volatile SingularAttribute<Questao, Short> estadoQuestao;
    public static volatile SingularAttribute<Questao, TipoQuestao> tipoQuestaoidTipoQuestao;
    public static volatile SingularAttribute<Questao, Character> questaoCorreta;

}