package br.com.fiap.hellynson.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract exception class for payload validation failures.
 *
 * @author Gabriel Oliveira
 */
public abstract class ValidationFailure extends RuntimeException {

    private List<String> validationMessages = new ArrayList<>();

    public ValidationFailure(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }

    public boolean hasValidationFailures() {
        return !validationMessages.isEmpty();
    }

    public List<String> getValidationMessages() {
        return validationMessages;
    }

}
