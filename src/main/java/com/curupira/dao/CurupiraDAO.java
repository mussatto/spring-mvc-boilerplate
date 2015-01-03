package com.curupira.dao;

import com.curupira.model.CurupiraModel;

public interface CurupiraDAO<T extends CurupiraModel> {

    public T saveOrUpdate(T model);
    public void delete(T model);
    public T find(Long id);


}
