package com.mycompany.enade.resources;

import com.mycompany.enade.dao.GenericDAO;
import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.util.Constants;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public abstract class GenericResource<T, D extends GenericDAO> {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private Class<D> daoClass;

    protected GenericResource() {
    }

    protected GenericResource(Class<D> daoClass) {
        this();
        this.daoClass = daoClass;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<T> findAll() {
        List<T> entityList = factoryDAO.getInstance(daoClass).findAll();
        return entityList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{id}")
    public T find(@PathParam("id") Integer id) {
        return (T) factoryDAO.getInstance(daoClass).find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String merge(T entity) {
        try {
            factoryDAO.getInstance(daoClass).merge(entity).toString();
            return Constants.REGISTRO_SALVO;
        } catch (Exception e) {
            return Constants.ERRO_SALVAR_REGISTRO + e.getMessage();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/removeAll")
    public String removeAll() {
        try {
            factoryDAO.getInstance(daoClass).removeAll();
            return Constants.TODOS_REGISTROS_EXCLUIDOS;
        } catch (Exception e) {
            return Constants.ERRO_EXCLUIR_REGISTRO + e.getMessage();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remove/{id}")
    public String remove(@PathParam("id") Integer id) {
        String result = Constants.REGISTRO_NAO_ENCONTRADO;
        try {
            T entityFind = find(id);
            if (entityFind != null) {
                factoryDAO.getInstance(daoClass).remove(id);
                result = Constants.REGISTRO_EXCLUIDO;
            }
        } catch (Exception e) {
            result = Constants.ERRO_EXCLUIR_REGISTRO + e.getMessage();
        }
        return result;
    }

}
