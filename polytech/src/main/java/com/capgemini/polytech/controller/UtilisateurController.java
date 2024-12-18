package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.LoginDTO;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Contrôleur REST pour gérer les utilisateurs.
 */
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Constructeur du contrôleur d'utilisateur.
     *
     * @param utilisateurService le service d'utilisateur
     * @param utilisateurMapper le mapper d'utilisateur
     */
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
    }

    /**
     * Récupère tous les utilisateurs.
     *
     * @return une liste de tous les utilisateurs
     */
    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUsers() {
        return ResponseEntity.ok(utilisateurService.getAllUsers()
                .stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList()));
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param utilisateurDTO les détails de l'utilisateur
     * @return l'utilisateur créé
     */
    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        return ResponseEntity.ok(
                utilisateurMapper.toDTO(
                        utilisateurService.createUser(
                                utilisateurMapper.toEntity(utilisateurDTO))));
    }

    /**
     * Authentifie un utilisateur.
     *
     * @param loginDTO les détails de connexion
     * @return l'utilisateur authentifié ou une erreur
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            Utilisateur utilisateur = utilisateurService.login(loginDTO.getMail(), loginDTO.getPassword());
            return ResponseEntity.ok(utilisateurMapper.toDTO(utilisateur));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ce compte n'existe pas");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue");
        }
    }

    /**
     * Récupère un utilisateur par ID.
     *
     * @param id l'ID de l'utilisateur
     * @return l'utilisateur correspondant
     */
    @GetMapping("/id")
    public ResponseEntity<UtilisateurDTO> getUserById(@RequestParam int id) {
        try {
            return ResponseEntity.ok(
                    utilisateurMapper.toDTO(
                            utilisateurService.findById(id)));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param id l'ID de l'utilisateur
     * @param utilisateurDTO les détails de l'utilisateur
     * @return l'utilisateur mis à jour
     */
    @PutMapping()
    public ResponseEntity<UtilisateurDTO> updateUser(@RequestParam int id, @RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            return ResponseEntity.ok(
                    utilisateurMapper.toDTO(
                            utilisateurService.updateUser(id, utilisateurMapper.toEntity(utilisateurDTO))));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Supprime un utilisateur.
     *
     * @param id l'ID de l'utilisateur
     * @return un message de confirmation ou une erreur
     */
    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam int id) {
        try {
            utilisateurService.deleteUser(id);
            return ResponseEntity.ok("Utilisateur bien supprimé");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erreur : utilisateur non trouvé");
        }
    }
}