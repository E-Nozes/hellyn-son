package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.Landfill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository class for {@link Landfill}.
 *
 * @author Gabriel Oliveira
 */
public interface LandfillRepository extends JpaRepository<Landfill, Integer> {

    Optional<Landfill> findByName(String name);

}
