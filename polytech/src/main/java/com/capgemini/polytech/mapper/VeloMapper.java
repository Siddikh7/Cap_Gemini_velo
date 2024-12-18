package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.VeloDTO;
import com.capgemini.polytech.entity.Velo;
import org.mapstruct.Mapper;

/**
 * Interface VeloMapper pour mapper les entités Velo vers des DTOs et vice versa.
 * Utilise MapStruct pour générer automatiquement le code des méthodes de mappage.
 */
@Mapper(componentModel = "spring")
public interface VeloMapper {

    /**
     * Convertit une entité Velo en VeloDTO.
     *
     * @param velo l'entité Velo à convertir
     * @return l'objet VeloDTO correspondant
     */
    default VeloDTO toDTO(Velo velo) {
        VeloDTO veloDTO = new VeloDTO();
        veloDTO.setId(velo.getId());
        veloDTO.setNom(velo.getNom());
        veloDTO.setDescription(velo.getDescription());
        veloDTO.setQuantite(velo.getQuantite());
        veloDTO.setPointGeo(velo.getPointGeo());
        return veloDTO;
    }

    /**
     * Convertit un VeloDTO en entité Velo.
     *
     * @param veloDTO l'objet VeloDTO à convertir
     * @return l'entité Velo correspondante
     */
    default Velo toEntity(VeloDTO veloDTO) {
        Velo velo = new Velo();
        velo.setId(veloDTO.getId());
        velo.setNom(veloDTO.getNom());
        velo.setDescription(veloDTO.getDescription());
        velo.setQuantite(veloDTO.getQuantite());
        velo.setPointGeo(veloDTO.getPointGeo());
        return velo;
    }
}