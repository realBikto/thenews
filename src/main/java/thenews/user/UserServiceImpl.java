package thenews.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        return List.of(
                new User(
                        1L,
                        "Victor",
                        "Herrera",
                        "email@test.com",
                        "password",
                        "email@test.com",
                        2L
                )
        );
    }
}
