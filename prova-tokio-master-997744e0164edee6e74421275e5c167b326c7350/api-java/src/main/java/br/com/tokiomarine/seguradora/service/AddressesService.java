package br.com.tokiomarine.seguradora.service;

import br.com.tokiomarine.seguradora.entity.Addresses;
import br.com.tokiomarine.seguradora.repository.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnddressesService {
    @Autowired
    private AddressesRepository addressesRepository;

    public Addresses createAddresses(Addresses addresses) {
        return addressesRepository.save(addresses);
    }
}
