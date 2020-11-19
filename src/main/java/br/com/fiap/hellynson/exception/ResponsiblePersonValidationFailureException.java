package br.com.fiap.hellynson.exception;

import br.com.fiap.hellynson.entity.ResponsiblePerson;

import java.util.List;

/**
 * Custom exception class for {@link ResponsiblePerson} payload validation failure.
 *
 * @author Gabriel Oliveira
 */
public class ResponsiblePersonValidationFailureException extends ValidationFailure {

    public ResponsiblePersonValidationFailureException(List<String> validationMessages) {
        super(validationMessages);
    }

}
