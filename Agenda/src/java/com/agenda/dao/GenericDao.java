
package com.agenda.dao;
import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, E extends Serializable> {
    E create(T entity);
    void delete(T entity);
    void update(T entity);
    
    T findById(Serializable id);
    List<T> findAll();
    List<T> findList(int pageNo, int pageSize);
    int getCountOfAll();
}