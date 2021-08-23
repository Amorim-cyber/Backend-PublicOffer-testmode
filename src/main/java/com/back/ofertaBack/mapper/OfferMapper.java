package com.back.ofertaBack.mapper;

import com.back.ofertaBack.model.Offer;
import com.back.ofertaBack.model.dto.OfferDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferMapper {

    public Offer toEntity(OfferDTO dto) {
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setOfferName(dto.getOfferName());
        offer.setClientCode(dto.getClientCode());
        offer.setClientName(dto.getClientName());
        offer.setBound(dto.isBound());
        offer.setClientEmail(dto.getClientEmail());
        offer.setAgentEmail(dto.getAgentEmail());
        offer.setAmount(dto.getAmount());
        offer.setPrice(dto.getPrice());
        offer.setStatus(dto.getStatus());
        return offer;
    }

    public OfferDTO toDto(Offer offer) {
        OfferDTO dto = new OfferDTO();
        dto.setId(offer.getId());
        dto.setOfferName(offer.getOfferName());
        dto.setClientCode(offer.getClientCode());
        dto.setClientName(offer.getClientName());
        dto.setClientEmail(offer.getClientEmail());
        dto.setAgentEmail(offer.getAgentEmail());
        dto.setAmount(offer.getAmount());
        dto.setPrice(offer.getPrice());
        dto.setStatus(offer.getStatus());
        return dto;
    }

    public List<OfferDTO> toDto(List<Offer> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
