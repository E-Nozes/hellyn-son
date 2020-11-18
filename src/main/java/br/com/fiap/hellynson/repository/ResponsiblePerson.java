package br.com.fiap.hellynson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link br.com.fiap.hellynson.entity.ResponsiblePerson}.
 *
 * @author Gabriel Oliveira
 */
public interface ResponsiblePerson extends JpaRepository<ResponsiblePerson, Integer> {
}
