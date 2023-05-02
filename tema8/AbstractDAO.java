package org.example.tema8;

import java.sql.SQLException;
public abstract class AbstractDAO<T> {
    public abstract void create(T object) throws SQLException;
    public abstract  T findByName(String name) throws SQLException;
    public abstract  T findById(int id) throws SQLException;
}
