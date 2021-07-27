package com.back.ofertaBack.controller;

import com.back.ofertaBack.dto.request.RequestDTO;
import com.back.ofertaBack.dto.response.MessageResponseDTO;
import com.back.ofertaBack.entity.Request;
import com.back.ofertaBack.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ofertaPublica/back")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createRequest(@RequestBody @Valid RequestDTO requestDTO){
        return requestService.createRequest(requestDTO);
    }
}
