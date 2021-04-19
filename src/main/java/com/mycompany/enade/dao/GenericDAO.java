/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Pichau
 */
public abstract class GenericDAO<T, I extends Serializable> {

    protected EntityManager entityManager = PersistenceUtil.getEntityManager();
   
    private Class<T> persistedClass;

    protected GenericDAO() {
    }

    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }

    public List<T> buscarTodos() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T buscar(I id) {
        return entityManager.find(persistedClass, id);
    }

    public T merge(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            entity = entityManager.merge(entity);
            entityManager.flush();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return entity;
    }

    public void remover(I id) {
        T entity = buscar(id);
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            T mergedEntity = entityManager.merge(entity);
            entityManager.remove(mergedEntity);
            entityManager.flush();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }

    public void removerAll() {
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            entityManager.createQuery("DELETE FROM " + persistedClass.getSimpleName()).executeUpdate();
            entityManager.flush();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }

}