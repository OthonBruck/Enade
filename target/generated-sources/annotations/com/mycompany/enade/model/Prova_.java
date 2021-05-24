package com.mycompany.enade.model;

import com.mycompany.enade.model.Questao;
import com.mycompany.enade.model.Resultado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-24T15:01:01")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile SingularAttribute<Prova, Integer> idProva;
    public static volatile ListAttribute<Prova, Resultado> resultadoList;
    public static volatile SingularAttribute<Prova, Date> dataProva;
    public static volatile ListAttribute<Prova, Questao> questaoList;

}