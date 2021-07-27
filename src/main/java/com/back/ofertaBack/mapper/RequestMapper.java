package com.back.ofertaBack.mapper;

import com.back.ofertaBack.dto.request.RequestDTO;
import com.back.ofertaBack.entity.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);
    
    Request toModel(RequestDTO requestDTO);

    RequestDTO toDTO(Request request);

}
