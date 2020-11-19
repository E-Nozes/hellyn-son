package br.com.fiap.hellynson.controller;

import br.com.fiap.hellynson.entity.Landfill;
import br.com.fiap.hellynson.resource.LandfillResource;
import br.com.fiap.hellynson.service.LandfillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Expose the API endpoints for {@link Landfill} resources.
 *
 * @author Gabriel Oliveira
 */
@RestController
@Api(value = "Landfills REST API")
@RequestMapping(value = "landfills", produces = MediaType.APPLICATION_JSON_VALUE)
public class LandfillController implements LandfillResource {

    @Autowired
    private LandfillService landfillService;

    @ApiOperation(value = "Get a Landfill based on it's ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Landfill not found for the given ID"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_SEARCH_LANDFILL') and #oauth2.hasScope('read')")
    public ResponseEntity<Landfill> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(landfillService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a Landfill based on it's NAME")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Landfill not found for the given NAME"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_SEARCH_LANDFILL') and #oauth2.hasScope('read')")
    public ResponseEntity<Landfill> findByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(landfillService.findByName(name), HttpStatus.OK);
    }

    @ApiOperation(value = "Register a new Landfill")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid payload information"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_REGISTER_LANDFILL') and #oauth2.hasScope('write')")
    public ResponseEntity<Landfill> register(@RequestBody @Valid Landfill landfill) {
        return new ResponseEntity<>(landfillService.create(landfill), HttpStatus.OK);
    }

}
