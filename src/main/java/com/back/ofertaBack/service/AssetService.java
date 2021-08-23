package com.back.ofertaBack.service;


import com.back.ofertaBack.exceptions.BusinessException;
import com.back.ofertaBack.exceptions.NotFoundException;
import com.back.ofertaBack.mapper.AssetMapper;
import com.back.ofertaBack.model.Asset;
import com.back.ofertaBack.model.dto.AssetDTO;
import com.back.ofertaBack.repository.AssetRepository;
import com.back.ofertaBack.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetMapper assetMapper;

    @Transactional
    public AssetDTO save(AssetDTO dto) {

        Optional<Asset> optionalAsset = assetRepository.findByShortNameAndLongName(dto.getShortName(),dto.getLongName());
        if(optionalAsset.isPresent()){
            throw new BusinessException(MessageUtils.ASSET_ALREADY_EXISTS);
        }
        Asset asset = assetMapper.toEntity(dto);
        assetRepository.save(asset);
        return assetMapper.toDto(asset);
    }

    @Transactional
    public List<AssetDTO> save(List<AssetDTO> listDto) {

        listDto.stream().forEach(x->save(x));

        return listDto;
    }

    @Transactional
    public AssetDTO update(AssetDTO dto) {

        Optional<Asset> optionalAsset = assetRepository.findByOfferUpdate(dto.getShortName(),dto.getLongName(), dto.getId());
        if(optionalAsset.isPresent()){
            throw new BusinessException(MessageUtils.ASSET_ALREADY_EXISTS);
        }

        Asset asset = assetMapper.toEntity(dto);
        assetRepository.save(asset);
        return assetMapper.toDto(asset);
    }

    @Transactional
    public AssetDTO delete(Long id) {
        AssetDTO dto = this.findById(id);

        assetRepository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public List<AssetDTO> deleteAll(List<AssetDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getId()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<AssetDTO> findAll() {
        return assetMapper.toDto(assetRepository.findAll());
    }
    @Transactional(readOnly = true)
    public AssetDTO findById(Long id){
        return assetRepository.findById(id).map(assetMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<AssetDTO> findByShortName(String shortName) {
        return  assetRepository.findByShortName(shortName).map(assetMapper::toDto).orElseThrow(NotFoundException::new);
    }

    public List<String> getAssetList() {
        List<Asset> list = assetRepository.findAll();
        return list.stream().map(x -> x.getShortName()).distinct().collect(Collectors.toList());
    }
}
