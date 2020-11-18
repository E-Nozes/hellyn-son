package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link State}.
 *
 * @author Gabriel Oliveira
 */
public interface StateRepository extends JpaRepository<State, Integer> {
}
