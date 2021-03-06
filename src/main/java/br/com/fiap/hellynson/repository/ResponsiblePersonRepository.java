package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.ResponsiblePerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link br.com.fiap.hellynson.entity.ResponsiblePerson}.
 *
 * @author Gabriel Oliveira
 */
public interface ResponsiblePersonRepository extends JpaRepository<ResponsiblePerson, Integer> {
}
