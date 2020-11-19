package br.com.fiap.hellynson.service;

import br.com.fiap.hellynson.entity.ResponsiblePerson;
import br.com.fiap.hellynson.entity.User;
import br.com.fiap.hellynson.exception.ResponsiblePersonValidationFailureException;
import br.com.fiap.hellynson.exception.UserValidationFailureException;
import br.com.fiap.hellynson.repository.ResponsiblePersonRepository;
import br.com.fiap.hellynson.validation.search.ResponsiblePersonSearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for {@link ResponsiblePerson} with business rules.
 *
 * @author Gabriel Oliveira
 */
@Service
public class ResponsiblePersonService {

    @Autowired
    private ResponsiblePersonRepository responsiblePersonRepository;

    @Autowired
    private ResponsiblePersonSearchValidator responsiblePersonSearchValidator;

    public ResponsiblePerson findById(Integer id) {
        return this.responsiblePersonSearchValidator.verifyIfExists(id);
    }

    public ResponsiblePerson create(ResponsiblePerson responsiblePerson) {
        return this.responsiblePersonRepository.save(responsiblePerson);
    }

}
