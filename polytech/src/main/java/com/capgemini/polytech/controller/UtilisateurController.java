package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;


    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurMapper  utilisateurMapper) {
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUsers() {
        return ResponseEntity.ok(utilisateurService.getAllUsers()
                .stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        return ResponseEntity.ok(
                utilisateurMapper.toDTO(
                        utilisateurService.createUser(
                                utilisateurMapper.toEntity(utilisateurDTO))));
    }

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

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam int id) {
        try {
            utilisateurService.deleteUser(id);
            return ResponseEntity.ok("utilisateur bien supp");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erreur : flm");
        }
    }

}
