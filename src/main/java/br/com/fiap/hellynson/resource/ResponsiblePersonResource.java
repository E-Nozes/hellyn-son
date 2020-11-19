package br.com.fiap.hellynson.resource;

import br.com.fiap.hellynson.entity.ResponsiblePerson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Define all the {@link ResponsiblePerson} resources that will be exposed by the Controller classes.
 *
 * @author Gabriel Oliveira
 */
public interface ResponsiblePersonResource {

    @GetMapping("{id}")
    public ResponseEntity<ResponsiblePerson> findById(@PathVariable("id") Integer id);

    @PostMapping
    public ResponseEntity<ResponsiblePerson> register(@RequestBody @Valid ResponsiblePerson responsiblePerson);

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id);

}
