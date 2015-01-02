package com.curupira.dao;

import com.curupira.model.CurupiraModel;

public class AbstractDAO<T extends CurupiraModel> implements CurupiraDAO<T> {

    public T save(T model){
        return null;
    }

    public T update(T model){
        return null;
    }

    public void delete(T model){

    }
}
