package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") //MapStruct pour générer automatiquement le code des méthodes de mappage
public interface UtilisateurMapper {

    default UtilisateurDTO toDTO(Utilisateur utilisateur){
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(utilisateur.getId());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setMail(utilisateur.getMail());
        dto.setUsername(utilisateur.getUsername());
        return dto;
    }

    default Utilisateur toEntity(UtilisateurDTO dto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setMail(dto.getMail());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setPassword("password");
        return utilisateur;
    }

}
