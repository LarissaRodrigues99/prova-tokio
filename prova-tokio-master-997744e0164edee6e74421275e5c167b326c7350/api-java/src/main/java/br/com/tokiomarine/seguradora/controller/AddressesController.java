package br.com.tokiomarine.seguradora.controller;

import br.com.tokiomarine.seguradora.entity.Addresses;
import br.com.tokiomarine.seguradora.repository.AddressesRepository;
import br.com.tokiomarine.seguradora.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/addresses")
public class AddressesController {

    @Autowired
    private AddressesRepository addressesRepository;

    @Autowired
    private CepService cepService;

    @PostMapping("/add")
    public Addresses addAddresses(@RequestBody Addresses addresses) {
        return addressesRepository.save(addresses);
    }

    @GetMapping("/by-cep/{cep}")
    public Addresses getAddressByCep(@PathVariable String cep) {
        return cepService.getAddressesByCep(cep).block();
    }

}
