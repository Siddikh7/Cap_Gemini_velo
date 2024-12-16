package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") //MapStruct pour générer automatiquement le code des méthodes de mappage
public interface VeloMapper {

    default VeloDTO toDTO(Velo velo){
        VeloDTO veloDTO = new VeloDTO();
        veloDTO.setId(velo.getId());
        veloDTO.setNom(velo.getNom());
        veloDTO.setDescription(velo.getDescription());
        veloDTO.setQuantite(velo.getQuantite());
        veloDTO.setPointGeo(velo.getPointGeo());
        return veloDTO;
    }

    default Velo toEntity(VeloDTO veloDTO){
        Velo velo = new Velo();
        velo.setId(veloDTO.getId());
        velo.setNom(veloDTO.getNom());
        velo.setDescription(veloDTO.getDescription());
        velo.setQuantite(veloDTO.getQuantite());
        velo.setPointGeo(veloDTO.getPointGeo());
        return velo;
    }

}