package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.entity.Velo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeloRepository extends JpaRepository<Velo, Integer> {
    //cree automatique les Create Read Update Delete methodes de base
    //donc findAll(), findById() etc... automatiquement
}