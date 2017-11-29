package pl.gov.arimr.spring.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.gov.arimr.spring.core.entities.User;
import pl.gov.arimr.spring.core.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public AuthService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoggedUser loadUserByUsername(final String login) throws UsernameNotFoundException {
        final User user = Optional.ofNullable(userRepository.findByLogin(login))
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login: %s not found1", login)));
        return new LoggedUser(user);
    }
}
