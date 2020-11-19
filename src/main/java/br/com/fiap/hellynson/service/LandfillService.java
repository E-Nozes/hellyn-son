package br.com.fiap.hellynson.service;

import br.com.fiap.hellynson.entity.Address;
import br.com.fiap.hellynson.entity.Landfill;
import br.com.fiap.hellynson.exception.LandfillValidationFailureException;
import br.com.fiap.hellynson.repository.LandfillRepository;
import br.com.fiap.hellynson.validation.LandfillValidator;
import br.com.fiap.hellynson.validation.search.LandfillSearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for {@link Landfill} with business rules.
 *
 * @author Gabriel Oliveira
 */
@Service
public class LandfillService {

    @Autowired
    private LandfillRepository landfillRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private LandfillValidator landfillValidator;

    @Autowired
    private LandfillSearchValidator landfillSearchValidator;

    public Landfill findById(Integer id) {
        return this.landfillSearchValidator.verifyIfExists(id);
    }

    public Landfill findByName(String name) {
        return this.landfillSearchValidator.verifyIfExistsByName(name);
    }

    public Landfill create(Landfill landfill) {
        validateRegistrationPayload(landfill);

        Address address = landfill.getAddress();
        if (address != null) {
            landfill.setAddress(this.addressService.persistAddress(address));
        }

        return this.landfillRepository.save(landfill);
    }

    private void validateRegistrationPayload(Landfill landfill) {
        List<String> validationMessages = this.landfillValidator.validate(landfill);

        LandfillValidationFailureException validationFailure = new LandfillValidationFailureException(validationMessages);
        if (validationFailure.hasValidationFailures()) {
            throw validationFailure;
        }
    }

}
