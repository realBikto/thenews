package thenews.database;

import thenews.model.User;

import java.util.List;

public interface UserDB {
    User save(User object);
    User update(int id, User object);
    List<User> findAll();
    User findById(int id);
    boolean deleteById(int id);
    User findByEmail(String email);
}
