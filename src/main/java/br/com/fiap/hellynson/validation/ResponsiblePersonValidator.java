package br.com.fiap.hellynson.validation;

import br.com.fiap.hellynson.entity.ResponsiblePerson;

import java.util.List;

/**
 * Contract class to be implemented by the {@link ResponsiblePerson} validation service classes.
 *
 * @author Gabriel Oliveira
 */
public interface ResponsiblePersonValidator {

    List<String> validate(ResponsiblePerson responsiblePerson);

}
