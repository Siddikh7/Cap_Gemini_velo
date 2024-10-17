package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private UtilisateurService utilisateurSerice;
    private UtilisateurMapper utilisateurMapper;

    @GetMapping
    @ResponseBody
    public List<UtilisateurDTO> getUtilisateurs(){
        return UtilisateurService.getAllUtilisateurs()
                .stream()
                .map(utilisateurMapper::toDTO)
                .collect(toList());
    }
    @PostMapping
    @ResponseBody
    public UtilisateurDTO createU(@RequestBody UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        //revoir la logique pour créer un utilisateur et l'ajouter à la bdd + flm
        return new UtilisateurDTO();
    }
    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.utilisateurSerice = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
    }
}
