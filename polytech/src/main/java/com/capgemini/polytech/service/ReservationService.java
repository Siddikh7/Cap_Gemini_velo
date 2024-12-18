package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service pour gérer les opérations liées aux réservations.
 */
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    /**
     * Constructeur de la classe ReservationService.
     *
     * @param reservationRepository le repository pour les entités Reservation
     */
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * Récupère toutes les réservations.
     *
     * @return une liste de toutes les réservations
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * Crée une nouvelle réservation.
     *
     * @param reservation la réservation à créer
     * @return la réservation créée
     */
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * Trouve une réservation par son identifiant.
     *
     * @param reservationId l'identifiant de la réservation
     * @return la réservation trouvée
     * @throws NoSuchElementException si la réservation n'existe pas
     */
    public Reservation findById(ReservationId reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            return optionalReservation.get();
        } else {
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
    }

    /**
     * Met à jour une réservation existante.
     *
     * @param reservationId l'identifiant de la réservation à mettre à jour
     * @param reservation les nouvelles informations de la réservation
     * @return la réservation mise à jour
     * @throws NoSuchElementException si la réservation n'existe pas
     */
    public Reservation updateReservation(ReservationId reservationId, Reservation reservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setReservation(reservation.getReservation());
            return reservationRepository.save(existingReservation);
        } else {
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
    }

    /**
     * Supprime une réservation par son identifiant.
     *
     * @param reservationId l'identifiant de la réservation à supprimer
     * @throws NoSuchElementException si la réservation n'existe pas
     */
    public void deleteReservation(ReservationId reservationId) {
        if (!reservationRepository.existsById(reservationId)) {
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
        reservationRepository.deleteById(reservationId);
    }
}