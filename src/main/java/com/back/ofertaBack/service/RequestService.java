package com.back.ofertaBack.service;

import com.back.ofertaBack.dto.response.MessageResponseDTO;
import com.back.ofertaBack.entity.Request;
import com.back.ofertaBack.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public MessageResponseDTO createRequest(Request request){
        Request savedRequest = requestRepository.save(request);
        return MessageResponseDTO
                .builder()
                .message("Created request with ID "+ savedRequest.getId())
                .build();
    }

}
