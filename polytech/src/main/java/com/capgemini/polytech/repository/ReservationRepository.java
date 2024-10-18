package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepositery extends JpaRepository<Reservation, Integer> {
    //cree automatique les Create Read Update Delete methodes de base
    //donc findAll(), findById() etc... automatiquement
}
