package pl.gov.arimr.spring.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gov.arimr.spring.core.constant.UserRole;
import pl.gov.arimr.spring.core.entities.User;
import pl.gov.arimr.spring.core.repository.UserRepository;
import pl.gov.arimr.spring.core.utils.PasswordUtils;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TestData {

    private UserRepository userRepository;
    private List<User> data = Arrays.asList(
        new User("Admin", PasswordUtils.getPassword("admin"), UserRole.ADMIN, "Admin", "Admin"),
        new User("User", PasswordUtils.getPassword("user"), UserRole.USER, "user", "uesr"),
        new User("Jacek", PasswordUtils.getPassword("jacek"), UserRole.USER, "Maurycy", "Bak"),
        new User("Daniel", PasswordUtils.getPassword("daniel"), UserRole.USER, "Daniel", "Trzeci")
    );

    @Autowired
    public TestData(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner addUsers() {
        return args -> userRepository.save(data);
    }

}
