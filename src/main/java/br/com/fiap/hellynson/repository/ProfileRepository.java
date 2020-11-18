package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository class for {@link Profile}.
 *
 * @author Gabriel Oliveira
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Optional<Profile> findByDescriptionIgnoreCase(String description);

}
