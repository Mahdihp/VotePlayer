package com.mahdi.service.dao;

import com.mahdi.service.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface Crud<T extends Entity<I>,I> {

    void create(T entity) throws SQLException;

    T read(I id)throws SQLException;

    void update(T entity)throws SQLException;

    void delete(I id)throws SQLException;

    List<T> readAll()throws SQLException;

}
