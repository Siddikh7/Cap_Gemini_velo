package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
    public Utilisateur createUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findById(int id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur avec l'ID " + id + " n'existe pas"));
    }

    public Utilisateur updateUser(int id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur avec l'ID " + id + " n'existe pas"));

        // Mise à jour des propriétés en fonction des champs de l'entité Utilisateur
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setMail(utilisateurDetails.getMail());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        utilisateur.setUsername(utilisateurDetails.getUsername());

        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUser(int id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new NoSuchElementException("Utilisateur avec l'ID " + id + " n'existe pas");
        }
        utilisateurRepository.deleteById(id);
    }
}
