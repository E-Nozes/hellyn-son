package br.com.fiap.hellynson.service;

import br.com.fiap.hellynson.entity.Address;
import br.com.fiap.hellynson.entity.City;
import br.com.fiap.hellynson.entity.User;
import br.com.fiap.hellynson.repository.AddressRepository;
import br.com.fiap.hellynson.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for {@link Address} with business rules.
 *
 * @author Gabriel Oliveira
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    public User persistAddress(User user) {
        Address receivedAddress = user.getAddress();

        Optional<City> existingCity = this.cityRepository.findByNameIgnoreCase(receivedAddress.getCity().getName());
        if (existingCity.isPresent()) {
            receivedAddress.setCity(existingCity.get());
        } else {
            receivedAddress.setCity(this.cityRepository.save(receivedAddress.getCity()));
        }

        Address persistentAddress = this.addressRepository.save(receivedAddress);

        user.setAddress(persistentAddress);

        return user;
    }

}
