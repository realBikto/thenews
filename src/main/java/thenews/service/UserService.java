package thenews.service;

import thenews.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User saveNewUser(User user);
    User findById(int id);
    User findByUsername(String username);
}
