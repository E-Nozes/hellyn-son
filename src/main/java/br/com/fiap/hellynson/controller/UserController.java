package br.com.fiap.hellynson.controller;

import br.com.fiap.hellynson.entity.User;
import br.com.fiap.hellynson.dto.PasswordUpdateDTO;
import br.com.fiap.hellynson.resource.UserResource;
import br.com.fiap.hellynson.service.UserService;
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
 * Expose the API endpoints for {@link User} resources.
 *
 * @author Gabriel Oliveira
 */
@RestController
@Api(value = "Users REST API")
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserResource {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get an User based on it's ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "User not found for the given ID"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_SEARCH_USER') and #oauth2.hasScope('read')")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Register a new User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid payload information"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and #oauth2.hasScope('write')")
    public ResponseEntity<User> register(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @ApiOperation(value = "Update password")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid payload information"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    @PreAuthorize("hasAuthority('ROLE_UPDATE_USER') and #oauth2.hasScope('write')")
    public ResponseEntity<HttpStatus> updatePassword(@RequestBody @Valid PasswordUpdateDTO passwordUpdateDTO) {
        userService.updatePassword(passwordUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
