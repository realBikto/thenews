package thenews.service.impl;

import org.springframework.stereotype.Service;
import thenews.model.User;
import thenews.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        return List.of(
                new User(
                        1,
                        "Victor",
                        "Herrera",
                        "email@test.com",
                        "password",
                        "email@test.com",
                        2
                )
        );
    }
}
