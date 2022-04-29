package thenews.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thenews.database.RoleDB;
import thenews.database.UserDB;
import thenews.model.Role;
import thenews.model.User;


@Service
public class UserDetailsSecurityService implements UserDetailsService {

    private UserDB userDB;
    private RoleDB roleDB;

    public UserDetailsSecurityService(UserDB userDB, RoleDB roleDB) {
        this.userDB = userDB;
        this.roleDB = roleDB;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userDB.findByEmail(email);
        Role role = this.roleDB.findByUser(email);
        UserDetailsSecurityModel userDetailsSecurityModel = new UserDetailsSecurityModel(user, role);

        return userDetailsSecurityModel;
    }
}
