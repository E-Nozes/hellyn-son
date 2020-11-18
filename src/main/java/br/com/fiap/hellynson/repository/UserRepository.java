package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository class for {@link User}.
 *
 * @author Gabriel Oliveira
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);

}
