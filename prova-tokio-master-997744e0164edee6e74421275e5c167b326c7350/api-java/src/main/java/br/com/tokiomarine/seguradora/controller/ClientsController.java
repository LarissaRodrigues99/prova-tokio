package br.com.tokiomarine.seguradora.controller;

import br.com.tokiomarine.seguradora.entity.Clients;
import br.com.tokiomarine.seguradora.repository.ClientsRepository;
import br.com.tokiomarine.seguradora.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class ClientsController {

    @Autowired
    private ClientsRepository repository;

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public ResponseEntity gerAllUsers(){
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<Clients> createClient(@RequestBody Clients clients) {
        Clients savedClients = clientsService.createClients(clients);
        return new ResponseEntity<>(savedClients, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable("id") Long id){

        clientsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
