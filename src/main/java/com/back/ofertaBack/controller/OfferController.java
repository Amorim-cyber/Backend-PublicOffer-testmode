package com.back.ofertaBack.controller;


import com.back.ofertaBack.model.dto.OfferDTO;
import com.back.ofertaBack.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/main")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferDTO> save(@Valid @RequestBody OfferDTO dto){
        return ResponseEntity.ok(offerService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> save(@Valid @RequestBody List<OfferDTO> list){
        return ResponseEntity.ok(offerService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferDTO> update(@RequestBody OfferDTO dto){
        return ResponseEntity.ok(offerService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> findAll(){

        return ResponseEntity.ok(offerService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<OfferDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(offerService.findById(id));

    }

    @GetMapping(value = "/search/{clientCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> findByClientCode(@PathVariable Long clientCode){
        return ResponseEntity.ok(offerService.findByClientCode(clientCode));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(offerService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> deleteAll(@RequestBody List<OfferDTO> list){
        return ResponseEntity.ok(offerService.deleteAll(list));
    }
}
