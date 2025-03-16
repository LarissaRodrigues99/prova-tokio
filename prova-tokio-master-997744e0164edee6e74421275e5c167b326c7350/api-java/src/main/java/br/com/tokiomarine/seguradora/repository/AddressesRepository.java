package br.com.tokiomarine.seguradora.repository;

import br.com.tokiomarine.seguradora.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Addresses, Long> {}
