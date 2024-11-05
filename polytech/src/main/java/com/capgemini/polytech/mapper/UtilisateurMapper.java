package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") //MapStruct pour générer automatiquement le code des méthodes de mappage
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);

    Utilisateur toEntity(UtilisateurDTO dto);

}
