package br.com.fiap.hellynson.validation.register;

import br.com.fiap.hellynson.entity.Landfill;
import br.com.fiap.hellynson.validation.LandfillValidator;
import br.com.fiap.hellynson.validation.search.LandfillSearchValidator;
import br.com.fiap.hellynson.validation.search.ResponsiblePersonSearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Validator class for {@link Landfill} register payload.
 *
 * @author Gabriel Oliveira
 */
@Component
public class LandfillRegisterValidator implements LandfillValidator {

    @Autowired
    private LandfillSearchValidator landfillSearchValidator;

    @Autowired
    private AddressRegisterValidator addressRegisterValidator;

    @Autowired
    private ResponsiblePersonSearchValidator responsiblePersonSearchValidator;

    @Override
    public List<String> validate(Landfill landfill) {
        Stream<String> validName = validateName(landfill).stream();
        Stream<String> validResponsiblePerson = validateResponsiblePerson(landfill).stream();
        Stream<String> validAddress = validateAddress(landfill).stream();

        return Stream.of(validName, validResponsiblePerson, validAddress)
                .flatMap(s -> s)
                .collect(toList());
    }

    private List<String> validateName(Landfill landfill) {
        String error = this.landfillSearchValidator.validateDuplicatedName(landfill.getName());
        return error == null
                ? Collections.emptyList()
                : Collections.singletonList(error);
    }

    private List<String> validateResponsiblePerson(Landfill landfill) {
        String error = this.responsiblePersonSearchValidator.validateId(landfill.getResponsiblePerson().getId());
        return error == null
                ? Collections.emptyList()
                : Collections.singletonList(error);
    }

    private List<String> validateAddress(Landfill landfill) {
        if (landfill.getAddress() != null) {
            return this.addressRegisterValidator.validate(landfill.getAddress());
        }

        return Collections.emptyList();
    }

}
