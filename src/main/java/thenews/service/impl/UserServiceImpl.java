package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.UserDatabase;
import thenews.model.Post;
import thenews.model.User;
import thenews.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDatabase userDatabase;

    @Override
    public List<User> getAllUsers() {
        return userDatabase.findAll();
    }

    @Override
    public User saveNewUser(User user) {
        return userDatabase.save(user);
    }

    @Override
    public User findById(int id) {return userDatabase.findById(id);}

    @Override
    public User findByUsername(String username) {return userDatabase.findByEmail(username);}

}
