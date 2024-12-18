package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;

/**
 * Interface UtilisateurMapper pour mapper les entités Utilisateur vers des DTOs et vice versa.
 * Utilise MapStruct pour générer automatiquement le code des méthodes de mappage.
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    /**
     * Convertit une entité Utilisateur en UtilisateurDTO.
     *
     * @param utilisateur l'entité Utilisateur à convertir
     * @return l'objet UtilisateurDTO correspondant
     */
    default UtilisateurDTO toDTO(Utilisateur utilisateur){
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(utilisateur.getId());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setMail(utilisateur.getMail());
        dto.setUsername(utilisateur.getUsername());
        return dto;
    }

    /**
     * Convertit un UtilisateurDTO en entité Utilisateur.
     *
     * @param dto l'objet UtilisateurDTO à convertir
     * @return l'entité Utilisateur correspondante
     */
    default Utilisateur toEntity(UtilisateurDTO dto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setMail(dto.getMail());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setPassword("password"); // Mot de passe par défaut
        return utilisateur;
    }
}