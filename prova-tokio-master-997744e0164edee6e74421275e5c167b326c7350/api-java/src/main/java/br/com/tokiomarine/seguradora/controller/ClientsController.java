package br.com.tokiomarine.seguradora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ClientsController {

    @GetMapping
    public ResponseEntity getAllClients(){
        return ResponseEntity.ok("Helo World");
    }
}
