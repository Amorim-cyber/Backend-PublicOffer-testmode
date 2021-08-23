package com.back.ofertaBack.service;


import com.back.ofertaBack.exceptions.BusinessException;
import com.back.ofertaBack.exceptions.NotFoundException;
import com.back.ofertaBack.mapper.OfferMapper;
import com.back.ofertaBack.model.Offer;
import com.back.ofertaBack.model.dto.OfferDTO;
import com.back.ofertaBack.repository.OfferRepository;
import com.back.ofertaBack.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferMapper offerMapper;

    @Transactional
    public OfferDTO save(OfferDTO dto) {

        Optional<Offer> optionalOffer = offerRepository.findByClientCodeAndOfferName(dto.getClientCode(),dto.getOfferName());
        if(optionalOffer.isPresent()){
            throw new BusinessException(MessageUtils.OFFER_ALREADY_EXISTS);
        }
        Offer offer = offerMapper.toEntity(dto);
        offerRepository.save(offer);
        return offerMapper.toDto(offer);
    }

    @Transactional
    public List<OfferDTO> save(List<OfferDTO> listDto) {

        listDto.stream().forEach(x->save(x));

        return listDto;
    }

    @Transactional
    public OfferDTO update(OfferDTO dto) {

        Optional<Offer> optionalOffer = offerRepository.findByOfferUpdate(dto.getClientCode(),dto.getOfferName(), dto.getId());
        if(optionalOffer.isPresent()){
            throw new BusinessException(MessageUtils.OFFER_ALREADY_EXISTS);
        }

        Offer offer = offerMapper.toEntity(dto);
        offerRepository.save(offer);
        return offerMapper.toDto(offer);
    }

    @Transactional
    public OfferDTO delete(Long id) {
        OfferDTO dto = this.findById(id);

        offerRepository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public List<OfferDTO> deleteAll(List<OfferDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getId()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<OfferDTO> findAll() {
        return offerMapper.toDto(offerRepository.findAll());
    }
    @Transactional(readOnly = true)
    public OfferDTO findById(Long id){
        return offerRepository.findById(id).map(offerMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<OfferDTO> findByClientCode(Long clientCode) {
        return  offerRepository.findByClientCode(clientCode).map(offerMapper::toDto).orElseThrow(NotFoundException::new);
    }
}
