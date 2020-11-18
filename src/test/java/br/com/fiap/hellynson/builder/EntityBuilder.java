package br.com.fiap.hellynson.builder;

import br.com.fiap.hellynson.entity.*;
import br.com.fiap.hellynson.entity.Address.AddressBuilder;
import br.com.fiap.hellynson.entity.City.CityBuilder;
import br.com.fiap.hellynson.entity.Profile.ProfileBuilder;
import br.com.fiap.hellynson.entity.State.StateBuilder;
import br.com.fiap.hellynson.entity.User.UserBuilder;

import java.util.HashSet;
import java.util.Set;

public class EntityBuilder {

    public static User buildUser() {
        return new UserBuilder()
                .withEmail("user@test.com")
                .withPassword("12345678")
                .withAddress(buildAddress())
                .withProfiles(buildProfiles())
                .build();
    }

    public static Address buildAddress() {
        return new AddressBuilder()
                .withAddress("Rua Vigário Albernaz 738")
                .withNumber("738")
                .withZipCode("04134-021")
                .withCity(buildCity())
                .build();
    }

    public static City buildCity() {
        return new CityBuilder()
                .withName("São Paulo")
                .withState(buildState())
                .build();
    }

    public static State buildState() {
        return new StateBuilder()
                .withId(24)
                .withName("São Paulo")
                .withFederalUnity("SP")
                .build();
    }

    public static Profile buildProfile() {
        return new ProfileBuilder()
                .withId(1)
                .build();
    }

    public static Set<Profile> buildProfiles() {
        Set<Profile> profiles = new HashSet<>();
        profiles.add(buildProfile());

        return profiles;
    }

}
