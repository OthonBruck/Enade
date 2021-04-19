package com.mycompany.enade.model;

import com.mycompany.enade.model.Prova;
import com.mycompany.enade.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-19T09:08:16")
@StaticMetamodel(Resultado.class)
public class Resultado_ { 

    public static volatile SingularAttribute<Resultado, Prova> provaidProva;
    public static volatile SingularAttribute<Resultado, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Resultado, Double> valorObtido;
    public static volatile SingularAttribute<Resultado, Integer> idResultado;

}