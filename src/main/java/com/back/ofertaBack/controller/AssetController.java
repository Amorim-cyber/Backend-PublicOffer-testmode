package com.back.ofertaBack.controller;

import com.back.ofertaBack.model.dto.AssetDTO;
import com.back.ofertaBack.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetDTO> save(@Valid @RequestBody AssetDTO dto){
        return ResponseEntity.ok(assetService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssetDTO>> save(@Valid @RequestBody List<AssetDTO> list){
        return ResponseEntity.ok(assetService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetDTO> update(@RequestBody AssetDTO dto){
        return ResponseEntity.ok(assetService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssetDTO>> findAll(){

        return ResponseEntity.ok(assetService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<AssetDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(assetService.findById(id));

    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<List<String>> getAssetList(){
        return ResponseEntity.ok(assetService.getAssetList());

    }

    @GetMapping(value = "/search/{shortName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssetDTO>> findByShortName(@PathVariable String shortName){
        return ResponseEntity.ok(assetService.findByShortName(shortName));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(assetService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssetDTO>> deleteAll(@RequestBody List<AssetDTO> list){
        return ResponseEntity.ok(assetService.deleteAll(list));
    }

}
