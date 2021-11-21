package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.UserDatabase;
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
}
