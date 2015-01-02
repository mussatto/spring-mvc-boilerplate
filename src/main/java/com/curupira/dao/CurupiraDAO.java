package com.curupira.dao;

import com.curupira.model.CurupiraModel;

public interface CurupiraDAO<T extends CurupiraModel> {

    public T save(T model);
    public T update(T model);
    public void delete(T model);

}
