package com.mycompany.enade.dao;

import com.mycompany.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @param <T>
 * @param <I>
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

    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T find(I id) {
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
            Logger.getLogger(e.getMessage());
        }
        return entity;
    }

    public void remove(I id) {
        T entity = find(id);
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            T mergedEntity = entityManager.merge(entity);
            entityManager.remove(mergedEntity);
            entityManager.flush();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            Logger.getLogger(e.getMessage());
        }
    }

    public void removeAll() {
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            entityManager.createQuery("DELETE FROM " + persistedClass.getSimpleName()).executeUpdate();
            entityManager.flush();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            Logger.getLogger(e.getMessage());
        }
    }

    public Object findSingleResult(Query query) {
        Object result;
        try {
            result = query.setMaxResults(1).getSingleResult();
        } catch (NoResultException ignored) {
            result = null;
        }
        return result;
    }

}
