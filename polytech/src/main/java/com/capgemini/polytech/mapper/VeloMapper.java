package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import org.springframework.stereotype.Component;

@Component
public class VeloMapper {
    public VeloDTO toDTO(Velo velo) {
        VeloDTO veloDTO = new VeloDTO();
        veloDTO.setNom(velo.getNom());
        veloDTO.setDescription(velo.getDescription());
        return veloDTO;
    }
    public Velo fromDTO(VeloDTO veloDTO) {
        return new Velo(veloDTO.getNom(), 1, veloDTO.getDescription(), "");
    }
}
