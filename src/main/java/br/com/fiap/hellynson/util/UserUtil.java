package br.com.fiap.hellynson.util;

import br.com.fiap.hellynson.entity.User;
import br.com.fiap.hellynson.validation.search.UserSearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Utility class for {@link User}.
 *
 * @author Gabriel Oliveira
 */
@Service
public class UserUtil {

    @Autowired
    private UserSearchValidator searchValidator;

    public User findLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email = principal instanceof UserDetails
                ? ((UserDetails) principal).getUsername()
                : principal.toString();

        return this.searchValidator.verifyIfExistsByEmail(email);
    }

}
