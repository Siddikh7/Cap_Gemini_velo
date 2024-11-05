package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper){
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }
    public List<UtilisateurDTO> getAllUsers(){
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList());
    }
}
