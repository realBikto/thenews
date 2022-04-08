package thenews.database;

import java.util.List;

public interface BaseDB<T> {

    boolean save(T object);
    boolean update(int id, T object);
    List<T> findAll();
    T findById(int id);
    boolean deleteById(int id);
}
