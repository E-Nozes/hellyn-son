package br.com.fiap.hellynson.repository;

import br.com.fiap.hellynson.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for {@link Permission}.
 *
 * @author Gabriel Oliveira
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
