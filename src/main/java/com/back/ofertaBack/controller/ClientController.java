package com.back.ofertaBack.controller;


import com.back.ofertaBack.model.dto.ClientDTO;
import com.back.ofertaBack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody ClientDTO dto){
        return ResponseEntity.ok(clientService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> save(@Valid @RequestBody List<ClientDTO> list){
        return ResponseEntity.ok(clientService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO dto){
        return ResponseEntity.ok(clientService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> findAll(){

        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));

    }

    @GetMapping(value = "/search/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> findByCode(@PathVariable Long code){
        return ResponseEntity.ok(clientService.findByCode(code));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(clientService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> deleteAll(@RequestBody List<ClientDTO> list){
        return ResponseEntity.ok(clientService.deleteAll(list));
    }

}
