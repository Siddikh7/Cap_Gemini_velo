package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    //cree automatique les Create Read Update Delete methodes de base
    //donc findAll(), findById() etc... automatiquement
    Optional<Utilisateur> findByMail(String email);


}
