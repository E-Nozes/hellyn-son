package br.com.fiap.hellynson.validation;

import br.com.fiap.hellynson.entity.User;

import java.util.List;

/**
 * Contract class to be implemented by the {@link User} validation service classes.
 *
 * @author Gabriel Oliveira
 */
public interface UserValidator {

    List<String> validate(User user);

}
