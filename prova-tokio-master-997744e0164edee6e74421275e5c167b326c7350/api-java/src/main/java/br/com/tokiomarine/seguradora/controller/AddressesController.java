package br.com.tokiomarine.seguradora.controller;

import br.com.tokiomarine.seguradora.entity.Addresses;
import br.com.tokiomarine.seguradora.repository.AddressesRepository;

import br.com.tokiomarine.seguradora.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/addresses")
public class AddressesController {

    @Autowired
    private AddressesRepository repository;

    @Autowired
    private AddressesService addressesService;

    @GetMapping
    public ResponseEntity gerAlladdresses(){
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<Addresses> createAddresses(@RequestBody Addresses addresses) {
        Addresses savedAddresses = addressesService.createAddresses(addresses);
        return new ResponseEntity<>(savedAddresses, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable("id") Long id){

        addressesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
