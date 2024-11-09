package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper){
        this.utilisateurRepository = utilisateurRepository;
    }
    public List<Utilisateur> getAllUsers(){
        return utilisateurRepository.findAll();
    }
    public Utilisateur createUser(Utilisateur utilisateur) {
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur ne peut pas être null");
        }
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
