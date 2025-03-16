package br.com.tokiomarine.seguradora.repository;

import br.com.tokiomarine.seguradora.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {}
