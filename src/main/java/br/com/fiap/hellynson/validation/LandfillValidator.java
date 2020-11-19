package br.com.fiap.hellynson.validation;

import br.com.fiap.hellynson.entity.Landfill;

import java.util.List;

/**
 * Contract class to be implemented by the {@link Landfill} validation service classes.
 *
 * @author Gabriel Oliveira
 */
public interface LandfillValidator {

    List<String> validate(Landfill landfill);

}
