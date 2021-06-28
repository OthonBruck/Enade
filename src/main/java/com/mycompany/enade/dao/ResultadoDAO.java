package com.mycompany.enade.dao;

import com.mycompany.enade.model.Resultado;
import java.util.List;

public class ResultadoDAO extends GenericDAO<Resultado, Integer> {

    public ResultadoDAO() {
        super(Resultado.class);
    }

    public List<Resultado> findResultadosUsuario(Integer idUsuario) {
        return entityManager.createNamedQuery("Resultado.findByIdUsuario", Resultado.class)
                .setParameter("idUsuario", idUsuario).getResultList();
    }
    
    public List<Resultado> findUltimosDezResultados() {
        return entityManager.createQuery("from Resultado r ORDER BY r.idResultado DESC", Resultado.class).setMaxResults(10).getResultList();
    }

}
