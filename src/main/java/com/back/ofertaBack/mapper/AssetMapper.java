package com.back.ofertaBack.mapper;


import com.back.ofertaBack.model.Asset;
import com.back.ofertaBack.model.dto.AssetDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetMapper {

    public Asset toEntity(AssetDTO dto) {
        Asset asset = new Asset();
        asset.setId(dto.getId());
        asset.setShortName(dto.getShortName());
        asset.setLongName(dto.getLongName());
        return asset;
    }

    public AssetDTO toDto(Asset asset) {
        AssetDTO dto = new AssetDTO();
        dto.setId(asset.getId());
        dto.setShortName(asset.getShortName());
        dto.setLongName(asset.getLongName());
        return dto;
    }

    public List<AssetDTO> toDto(List<Asset> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
