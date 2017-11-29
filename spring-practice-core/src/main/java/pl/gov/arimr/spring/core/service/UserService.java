package pl.gov.arimr.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.arimr.spring.core.constant.UserRole;
import pl.gov.arimr.spring.core.entities.User;
import pl.gov.arimr.spring.core.repository.UserRepository;
import pl.gov.arimr.spring.core.utils.PasswordUtils;

import java.util.Set;
import java.util.TreeSet;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Set<User> findAll() {
        final Set<User> ret = new TreeSet<>();
        ret.addAll(repository.findByActiveTrue());
        return ret;
    }

    public User findByLogin(final String login) {
        return repository.findByLogin(login);
    }

    public void deleteUser(Long id) {
        User user = repository.findOne(id);
        user.setActive(false);
        repository.save(user);
    }

    public User saveOrUpdate(final User user) {
        user.setRole(UserRole.USER);
        user.setActive(true);
        if (user.getNewPassword().equals(user.getConfirmedNewPassword())){
            user.setPassword(PasswordUtils.getPassword(user.getNewPassword()));
        }
        return repository.save(user);
    }

}
