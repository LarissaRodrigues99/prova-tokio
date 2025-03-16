package br.com.tokiomarine.seguradora.controller;

import br.com.tokiomarine.seguradora.domain.addresses.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AddressesRepository repository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok("Hello world");
    }
}
