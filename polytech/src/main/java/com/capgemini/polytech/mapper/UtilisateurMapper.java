package com.capgemini.polytech.mapper;

import org.mapstruct.Mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;


@Mapper(componentModel = "spring") //MapStruct pour générer automatiquement le code des méthodes de mappage
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);

    Utilisateur toEntity(UtilisateurDTO dto);

}
