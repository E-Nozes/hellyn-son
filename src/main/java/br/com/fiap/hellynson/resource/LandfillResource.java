package br.com.fiap.hellynson.resource;

import br.com.fiap.hellynson.entity.Landfill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Define all the {@link Landfill} resources that will be exposed by the Controller classes.
 *
 * @author Gabriel Oliveira
 */
public interface LandfillResource {

    @GetMapping("{id}")
    public ResponseEntity<Landfill> findById(@PathVariable("id") Integer id);

    @GetMapping
    public ResponseEntity<Landfill> findByName(@RequestParam("name") String name);

    @PostMapping
    public ResponseEntity<Landfill> register(@RequestBody @Valid Landfill landfill);

}
