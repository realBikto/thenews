package thenews.database;

import java.util.List;

public interface BaseDB<T> {

    public boolean save(T object);
    public boolean update(T object);
    public List<T> findAll();
    public T findById(int id);
}
