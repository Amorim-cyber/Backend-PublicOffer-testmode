package com.back.ofertaBack.controller;

import com.back.ofertaBack.dto.request.RequestDTO;
import com.back.ofertaBack.dto.response.MessageResponseDTO;
import com.back.ofertaBack.entity.Request;
import com.back.ofertaBack.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<RequestDTO> listAll(){
        return requestService.listAll();
    }

    @GetMapping(value="/{agentId}")
    public ResponseEntity<List<RequestDTO>> findAllByAgentId(@PathVariable Long agentId){
        return ResponseEntity.ok(requestService.findAllByAgentId(agentId));
    }

    @GetMapping(value="/localizar/{clientId}")
    public ResponseEntity<List<RequestDTO>> findAllByClientId(@PathVariable Long clientId){
        return ResponseEntity.ok(requestService.findAllByClientId(clientId));
    }
}
