package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {
    public UtilisateurDTO toDTO(Utilisateur utilisateur) {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setUsername(utilisateur.getUsername());
        dto.setEmail(utilisateur.getMail());
        return dto;
    }
    public Utilisateur toEntity(UtilisateurDTO dto) {
        Utilisateur utilisateur = new Utilisateur(); //trop long en 1 seule ligne en utilisant le constructeur
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setMail(dto.getEmail());
        utilisateur.setPassword("");
        return utilisateur;
    }
}
