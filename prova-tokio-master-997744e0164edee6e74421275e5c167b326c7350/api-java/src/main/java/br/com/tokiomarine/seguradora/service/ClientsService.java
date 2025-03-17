package br.com.tokiomarine.seguradora.service;

import br.com.tokiomarine.seguradora.entity.Clients;
import br.com.tokiomarine.seguradora.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public Clients createClients(Clients clients) {
        return clientsRepository.save(clients);
    }

    public void deleteById(Long id) {

        var userExists = clientsRepository.existsById(id);

        if (userExists) {
            clientsRepository.deleteById(id);
        }
    }

}
