package br.com.fiap.hellynson.controller;

import br.com.fiap.hellynson.entity.ResponsiblePerson;
import br.com.fiap.hellynson.resource.ResponsiblePersonResource;
import br.com.fiap.hellynson.service.ResponsiblePersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Expose the API endpoints for {@link ResponsiblePerson} resources.
 *
 * @author Gabriel Oliveira
 */
@RestController
@Api(value = "Responsible People REST API")
@RequestMapping(value = "responsiblepeople", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResponsiblePersonController implements ResponsiblePersonResource {

    @Autowired
    private ResponsiblePersonService responsiblePersonService;

    @ApiOperation(value = "Get a Responsible Person based on it's ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Responsible Person not found for the given ID"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_SEARCH_RESPONSIBLE') and #oauth2.hasScope('read')")
    public ResponseEntity<ResponsiblePerson> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(responsiblePersonService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Register a new Responsible Person")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid payload information"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_REGISTER_RESPONSIBLE') and #oauth2.hasScope('write')")
    public ResponseEntity<ResponsiblePerson> register(@RequestBody @Valid ResponsiblePerson responsiblePerson) {
        return new ResponseEntity<>(responsiblePersonService.create(responsiblePerson), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Responsible Person")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Responsible Person not found for the given ID"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_DELETE_RESPONSIBLE') and #oauth2.hasScope('write')")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        responsiblePersonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
