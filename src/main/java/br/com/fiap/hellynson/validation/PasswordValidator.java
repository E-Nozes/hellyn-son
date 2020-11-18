package br.com.fiap.hellynson.validation;

import br.com.fiap.hellynson.dto.PasswordUpdateDTO;

import java.util.List;

/**
 * Contract class to be implemented by the PasswordUpdate validation service classes.
 *
 * @author Gabriel Oliveira
 */
public interface PasswordValidator {

    List<String> validate(PasswordUpdateDTO passwordUpdateDTO);

}
