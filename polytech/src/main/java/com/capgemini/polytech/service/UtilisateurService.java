package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service pour gérer les opérations liées aux utilisateurs.
 */
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    /**
     * Constructeur de la classe UtilisateurService.
     *
     * @param utilisateurRepository le repository pour les entités Utilisateur
     * @param utilisateurMapper le mapper pour les entités Utilisateur (non utilisé dans cette classe)
     */
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Récupère tous les utilisateurs.
     *
     * @return une liste de tous les utilisateurs
     */
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param utilisateur l'utilisateur à créer
     * @return l'utilisateur créé
     * @throws IllegalArgumentException si l'utilisateur est null
     */
    public Utilisateur createUser(Utilisateur utilisateur) {
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur ne peut pas être null");
        }
        return utilisateurRepository.save(utilisateur);
    }

    /**
     * Trouve un utilisateur par son identifiant.
     *
     * @param id l'identifiant de l'utilisateur
     * @return l'utilisateur trouvé
     * @throws NoSuchElementException si l'utilisateur n'existe pas
     */
    public Utilisateur findById(int id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur avec l'ID " + id + " n'existe pas"));
    }

    /**
     * Trouve un utilisateur par son email.
     *
     * @param mail l'email de l'utilisateur
     * @return l'utilisateur trouvé
     * @throws NoSuchElementException si l'utilisateur n'existe pas
     */
    public Utilisateur findByMail(String mail) {
        return utilisateurRepository.findByMail(mail)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur avec l'email " + mail + " n'existe pas"));
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param id l'identifiant de l'utilisateur à mettre à jour
     * @param utilisateurDetails les nouvelles informations de l'utilisateur
     * @return l'utilisateur mis à jour
     * @throws NoSuchElementException si l'utilisateur n'existe pas
     */
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

    /**
     * Supprime un utilisateur par son identifiant.
     *
     * @param id l'identifiant de l'utilisateur à supprimer
     * @throws NoSuchElementException si l'utilisateur n'existe pas
     */
    public void deleteUser(int id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new NoSuchElementException("Utilisateur avec l'ID " + id + " n'existe pas");
        }
        utilisateurRepository.deleteById(id);
    }

    /**
     * Authentifie un utilisateur par son email et son mot de passe.
     *
     * @param mail l'email de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return l'utilisateur authentifié
     * @throws NoSuchElementException si l'utilisateur n'existe pas
     * @throws IllegalArgumentException si le mot de passe est incorrect
     */
    public Utilisateur login(String mail, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByMail(mail)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur avec l'email " + mail + " n'existe pas"));
        if (!utilisateur.getPassword().equals(password)) {
            throw new IllegalArgumentException("Mot de passe incorrect");
        }
        return utilisateur;
    }
}