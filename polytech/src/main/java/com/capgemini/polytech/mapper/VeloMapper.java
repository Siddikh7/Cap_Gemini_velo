package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VeloMapper {

    VeloDTO toDTO(Velo velo);

    Velo toEntity(VeloDTO veloDTO);

}
