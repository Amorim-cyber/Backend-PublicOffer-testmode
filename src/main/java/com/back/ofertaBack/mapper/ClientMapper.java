package com.back.ofertaBack.mapper;


import com.back.ofertaBack.model.Client;
import com.back.ofertaBack.model.dto.ClientDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setCode(dto.getCode());
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setAgentName(dto.getAgentName());
        client.setAgentEmail(dto.getAgentEmail());
        return client;
    }

    public ClientDTO toDto(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setCode(client.getCode());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setAgentName(client.getAgentName());
        dto.setAgentEmail(client.getAgentEmail());
        return dto;
    }

    public List<ClientDTO> toDto(List<Client> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
