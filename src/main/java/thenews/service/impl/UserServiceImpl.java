package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.UserDB;
import thenews.model.User;
import thenews.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDB userDB;

    @Override
    public List<User> getAllUsers() {
        return userDB.findAll();
    }

    @Override
    public User saveNewUser(User user) {
        return userDB.save(user);
    }

    @Override
    public User findById(int id) {return userDB.findById(id);}

    @Override
    public User findByUsername(String username) {return userDB.findByEmail(username);}

}
