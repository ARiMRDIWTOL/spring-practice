package pl.gov.arimr.spring.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gov.arimr.spring.core.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(final String login);

    List<User> findByActiveTrue();
}
