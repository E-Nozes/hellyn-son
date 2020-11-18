package br.com.fiap.hellynson.exception;

import br.com.fiap.hellynson.entity.User;

import java.util.List;

/**
 * Custom exception class for {@link User} payload validation failure.
 *
 * @author Gabriel Oliveira
 */
public class UserValidationFailureException extends ValidationFailure {

    public UserValidationFailureException(List<String> validationMessages) {
        super(validationMessages);
    }

}
