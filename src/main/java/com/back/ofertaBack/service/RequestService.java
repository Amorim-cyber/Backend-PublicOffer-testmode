package com.back.ofertaBack.service;

import com.back.ofertaBack.dto.request.RequestDTO;
import com.back.ofertaBack.dto.response.MessageResponseDTO;
import com.back.ofertaBack.entity.Request;
import com.back.ofertaBack.exception.RequestNotFoundException;
import com.back.ofertaBack.mapper.RequestMapper;
import com.back.ofertaBack.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return getMessageResponseDTO(savedRequest.getId(),"Created");
    }

    public MessageResponseDTO updateById(Long id, RequestDTO requestDTO) throws RequestNotFoundException {

        verifyIfRequestExists(id);

        Request requestToUpdate= requestMapper.toModel(requestDTO);

        Request updatedRequest = requestRepository.save(requestToUpdate);
        return getMessageResponseDTO(updatedRequest.getId(),"Updated");
    }

    public List<RequestDTO> listAll() {
        List<Request> allRequests = requestRepository.findAll();
        return getListDTO(allRequests);
    }

    public List<RequestDTO> findAllByAgentId(Long agentId) {
        List<Request> allAgentRequests = requestRepository.findByAgentId(agentId);
        return getListDTO(allAgentRequests);
    }

    public List<RequestDTO> findAllByClientId(Long clientId) {
        List<Request> allClientRequests = requestRepository.findByClientId(clientId);
        return getListDTO(allClientRequests);
    }

    public void delete(Long id) throws RequestNotFoundException {
        verifyIfRequestExists(id);
        requestRepository.deleteById(id);
    }

    private MessageResponseDTO getMessageResponseDTO(Long id, String message ) {
        return MessageResponseDTO
                .builder()
                .message(message+" request with ID " + id)
                .build();
    }

    private Request verifyIfRequestExists(Long id) throws RequestNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
    }

    private List<RequestDTO> getListDTO(List<Request> list){
        return list.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }


}
