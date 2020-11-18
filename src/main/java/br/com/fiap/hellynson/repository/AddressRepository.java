package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link Address}.
 *
 * @author Gabriel Oliveira
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
