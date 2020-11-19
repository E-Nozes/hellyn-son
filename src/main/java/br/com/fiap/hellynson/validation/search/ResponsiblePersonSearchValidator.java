package br.com.fiap.hellynson.validation.search;

import br.com.fiap.hellynson.entity.ResponsiblePerson;
import br.com.fiap.hellynson.exception.ResourceNotFoundException;
import br.com.fiap.hellynson.repository.ResponsiblePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Validator class for {@link ResponsiblePerson} searching methods.
 *
 * @author Gabriel Oliveira
 */
@Component
public class ResponsiblePersonSearchValidator {

    private static final String INVALID_ID_MESSAGE_TEMPLATE = "Responsible Person not found for the given ID '%s'";

    @Autowired
    private ResponsiblePersonRepository responsiblePersonRepository;

    public ResponsiblePerson verifyIfExists(Integer id) {
        return this.responsiblePersonRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(generateErrorMessage(INVALID_ID_MESSAGE_TEMPLATE, id)));
    }

    public String validateId(Integer id) {
        if (!responsiblePersonRepository.findById(id).isPresent()) {
            return generateErrorMessage(INVALID_ID_MESSAGE_TEMPLATE, id);
        }

        return null;
    }

    private String generateErrorMessage(String template, Integer id) {
        return String.format(template, id);
    }

}
