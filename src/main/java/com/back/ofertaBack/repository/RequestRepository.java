package com.back.ofertaBack.repository;

import com.back.ofertaBack.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT request "+
            "FROM Request request "+
            "WHERE request.agentId = :agentId")
    List<Request> findByAgentId(Long agentId);

    @Query("SELECT request "+
            "FROM Request request "+
            "WHERE request.clientId = :clientId")
    List<Request> findByClientId(Long clientId);

}
