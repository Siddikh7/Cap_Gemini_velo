package com.capgemini.polytech.mapper;

import org.mapstruct.Mapper;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;


@Mapper(componentModel = "spring")
public interface VeloMapper {

    VeloDTO toDTO(Velo velo);

    Velo toEntity(VeloDTO veloDTO);

}
