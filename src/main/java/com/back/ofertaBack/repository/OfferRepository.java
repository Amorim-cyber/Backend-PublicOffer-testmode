package com.back.ofertaBack.repository;

import com.back.ofertaBack.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


    Optional<Offer> findByClientCodeAndOfferName(Long clientCode,String offerName);

    @Query("SELECT offer "+
            "FROM Offer offer "+
            "WHERE offer.clientCode = :clientCode AND offer.offerName = :offerName AND offer.id <> :id ")
    Optional<Offer> findByOfferUpdate(Long clientCode, String offerName, Long id);

    @Query("SELECT offer "+
            "FROM Offer offer "+
            "WHERE offer.clientCode = :clientCode")
    Optional<List<Offer>> findByClientCode(Long clientCode);
}
