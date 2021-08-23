package com.back.ofertaBack.repository;

import com.back.ofertaBack.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCodeAndName(Long id, String name);

    @Query("SELECT client "+
            "FROM Client client "+
            "WHERE client.code = :code AND client.name = :name AND client.id <> :id ")
    Optional<Client> findByOfferUpdate(Long code, String name, Long id);

    Optional<List<Client>> findByCode(Long code);

}
