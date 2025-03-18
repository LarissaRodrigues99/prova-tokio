package br.com.tokiomarine.seguradora.service;

import br.com.tokiomarine.seguradora.entity.Addresses;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.brasilaberto.com/v1/zipcode").build();
    }

    public Mono<Addresses> getAddressesByCep(String cep) {
        return webClient.get()
                .uri("/{cep}", cep)
                .retrieve()
                .bodyToMono(Addresses.class);
    }
}
