package com.back.ofertaBack.repository;


import com.back.ofertaBack.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    Optional<Asset> findByShortNameAndLongName(String shortName, String longName);

    @Query("SELECT asset "+
            "FROM Asset asset "+
            "WHERE asset.shortName = :shortName AND asset.longName = :longName AND asset.id <> :id ")
    Optional<Asset> findByOfferUpdate(String shortName, String longName, Long id);

    Optional<List<Asset>> findByShortName(String shortName);

}
