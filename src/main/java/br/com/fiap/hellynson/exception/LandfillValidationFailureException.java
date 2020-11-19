package br.com.fiap.hellynson.exception;

import br.com.fiap.hellynson.entity.Landfill;

import java.util.List;

/**
 * Custom exception class for {@link Landfill} payload validation failure.
 *
 * @author Gabriel Oliveira
 */
public class LandfillValidationFailureException extends ValidationFailure {

    public LandfillValidationFailureException(List<String> validationMessages) {
        super(validationMessages);
    }

}
