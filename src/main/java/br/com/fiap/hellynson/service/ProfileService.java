package br.com.fiap.hellynson.service;

import br.com.fiap.hellynson.entity.Profile;
import br.com.fiap.hellynson.entity.User;
import br.com.fiap.hellynson.exception.ResourceNotFoundException;
import br.com.fiap.hellynson.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Service class for {@link Profile} with business rules.
 *
 * @author Gabriel Oliveira
 */
@Service
public class ProfileService {

    private static final String PROFILE_LEVEL_1 = "LEVEL_1";

    @Autowired
    private ProfileRepository profileRepository;

    public User addDefaultProfile(User user) {
        Profile profileLevel1 = this.profileRepository.findByDescriptionIgnoreCase(PROFILE_LEVEL_1)
                .orElseThrow(() -> new ResourceNotFoundException("Default profile not found"));

        if (user.getProfiles() == null) {
            user.setProfiles(new HashSet<>());
        }

        user.getProfiles().add(profileLevel1);

        return user;
    }

}
