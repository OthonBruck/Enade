/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class FactoryDAO {

    private final static Map<String, Object> daoClassList = new HashMap<>();

    public <T> T getInstance(Class<T> t) {
        T daoClass = (T) daoClassList.get(t.getName());
        try {
            if (daoClass == null) {
                daoClass = t.newInstance();
                daoClassList.put(t.getName(), daoClass);
            }
        } catch (IllegalAccessException | InstantiationException e) {
            Logger.getLogger(e.getMessage());
        }
        return daoClass;
    }

}
