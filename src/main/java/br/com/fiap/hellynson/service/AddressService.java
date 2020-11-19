package br.com.fiap.hellynson.service;

import br.com.fiap.hellynson.entity.Address;
import br.com.fiap.hellynson.entity.City;
import br.com.fiap.hellynson.entity.Landfill;
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

    public Address persistAddress(Address address) {
        Optional<City> existingCity = this.cityRepository.findByNameIgnoreCase(address.getCity().getName());
        if (existingCity.isPresent()) {
            address.setCity(existingCity.get());
        } else {
            address.setCity(this.cityRepository.save(address.getCity()));
        }

        return this.addressRepository.save(address);
    }

}
