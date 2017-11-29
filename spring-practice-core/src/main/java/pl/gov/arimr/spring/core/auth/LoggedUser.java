package pl.gov.arimr.spring.core.auth;


import org.springframework.security.core.authority.AuthorityUtils;
import pl.gov.arimr.spring.core.entities.User;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public LoggedUser(User user) {
        super(user.getLogin(), user.getPassword(),
            AuthorityUtils.createAuthorityList(user.getRole().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
