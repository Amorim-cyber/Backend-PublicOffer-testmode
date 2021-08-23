package com.back.ofertaBack.service;


import com.back.ofertaBack.exceptions.BusinessException;
import com.back.ofertaBack.exceptions.NotFoundException;
import com.back.ofertaBack.mapper.ClientMapper;
import com.back.ofertaBack.model.Client;
import com.back.ofertaBack.model.dto.ClientDTO;
import com.back.ofertaBack.repository.ClientRepository;
import com.back.ofertaBack.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Transactional
    public ClientDTO save(ClientDTO dto) {

        Optional<Client> optionalClient = clientRepository.findByCodeAndName(dto.getCode(),dto.getName());
        if(optionalClient.isPresent()){
            throw new BusinessException(MessageUtils.CLIENT_ALREADY_EXISTS);
        }
        Client client = clientMapper.toEntity(dto);
        clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Transactional
    public List<ClientDTO> save(List<ClientDTO> listDto) {

        listDto.stream().forEach(x->save(x));

        return listDto;
    }

    @Transactional
    public ClientDTO update(ClientDTO dto) {

        Optional<Client> optionalClient = clientRepository.findByOfferUpdate(dto.getCode(),dto.getName(), dto.getId());
        if(optionalClient.isPresent()){
            throw new BusinessException(MessageUtils.CLIENT_ALREADY_EXISTS);
        }

        Client client = clientMapper.toEntity(dto);
        clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Transactional
    public ClientDTO delete(Long id) {
        ClientDTO dto = this.findById(id);

        clientRepository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public List<ClientDTO> deleteAll(List<ClientDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getId()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return clientMapper.toDto(clientRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        return clientRepository.findById(id).map(clientMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findByCode(Long code) {
        return  clientRepository.findByCode(code).map(clientMapper::toDto).orElseThrow(NotFoundException::new);
    }


}
