package com.back.ofertaBack.repository;

import com.back.ofertaBack.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
