package br.com.tokiomarine.seguradora.service;

import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepServise {

    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.brasilaberto.com/v1/zipcode").build();
    }

    public Mono<Address> getAddressByCep(String cep) {
        return webClient.get()
                .uri("/{cep}", cep)
                .retrieve()
                .bodyToMono(Address.class);
    }
}
