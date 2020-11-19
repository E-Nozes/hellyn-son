package br.com.fiap.hellynson.validation.search;

import br.com.fiap.hellynson.entity.Landfill;
import br.com.fiap.hellynson.exception.ResourceNotFoundException;
import br.com.fiap.hellynson.repository.LandfillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Validator class for {@link Landfill} searching methods.
 *
 * @author Gabriel Oliveira
 */
@Component
public class LandfillSearchValidator {

    private static final String INVALID_ID_MESSAGE_TEMPLATE = "Landfill not found for the given ID '%s'";
    private static final String INVALID_NAME_MESSAGE_TEMPLATE = "Landfill not found for the given name '%s'";
    private static final String DUPLICATE_NAME_MESSAGE_TEMPLATE = "The given name '%s' is already taken. Please choose another one";

    @Autowired
    private LandfillRepository landfillRepository;

    public Landfill verifyIfExists(Integer id) {
        return this.landfillRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(generateErrorMessage(INVALID_ID_MESSAGE_TEMPLATE, id)));
    }

    public Landfill verifyIfExistsByName(String name) {
        return this.landfillRepository.findByName(name).orElseThrow(() ->
                new ResourceNotFoundException(generateErrorMessage(INVALID_NAME_MESSAGE_TEMPLATE, name)));
    }

    public String validateDuplicatedName(String name) {
        return this.landfillRepository.findByName(name).isPresent()
                ? generateErrorMessage(DUPLICATE_NAME_MESSAGE_TEMPLATE, name)
                : null;
    }

    private String generateErrorMessage(String template, Integer id) {
        return String.format(template, id);
    }

    private String generateErrorMessage(String template, String name) {
        return String.format(template, name);
    }

}
