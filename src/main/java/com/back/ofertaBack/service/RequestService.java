package com.back.ofertaBack.service;

import com.back.ofertaBack.dto.request.RequestDTO;
import com.back.ofertaBack.dto.response.MessageResponseDTO;
import com.back.ofertaBack.entity.Request;
import com.back.ofertaBack.mapper.RequestMapper;
import com.back.ofertaBack.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    private final RequestMapper requestMapper = RequestMapper.INSTANCE;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public MessageResponseDTO createRequest(RequestDTO requestDTO){

        Request requestToSave = requestMapper.toModel(requestDTO);

        Request savedRequest = requestRepository.save(requestToSave);
        return MessageResponseDTO
                .builder()
                .message("Created request with ID "+ savedRequest.getId())
                .build();
    }

    public List<RequestDTO> listAll() {
        List<Request> allRequests = requestRepository.findAll();
        return allRequests.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RequestDTO> findAllByAgentId(Long agentId) {
        List<Request> allAgentRequests = requestRepository.findByAgentId(agentId);
        return allAgentRequests.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RequestDTO> findAllByClientId(Long clientId) {
        List<Request> allAgentRequests = requestRepository.findByClientId(clientId);
        return allAgentRequests.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
