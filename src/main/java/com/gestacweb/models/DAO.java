package com.gestacweb.models;

import java.util.Set;


public interface DAO<T>{

    public void save(T entity);

    public T findById(long id);

    public void update(T entity);

    public void delete(T entity);

    public Set<T> getAll();

}
