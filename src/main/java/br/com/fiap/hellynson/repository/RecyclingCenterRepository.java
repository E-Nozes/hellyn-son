package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link RecyclingCenter}.
 *
 * @author Gabriel Oliveira
 */
public interface RecyclingCenterRepository extends JpaRepository<RecyclingCenter, Integer> {
}
