package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.mapper.ReservationMapper;
import com.capgemini.polytech.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Contrôleur REST pour gérer les réservations.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    /**
     * Constructeur du contrôleur de réservation.
     *
     * @param reservationService le service de réservation
     * @param reservationMapper le mapper de réservation
     */
    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper){
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Récupère toutes les réservations.
     *
     * @return une liste de toutes les réservations
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ReservationDTO>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations()
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList()));
    }

    /**
     * Récupère une réservation par ID.
     *
     * @param utilisateurId l'ID de l'utilisateur
     * @param veloId l'ID du vélo
     * @return la réservation correspondante
     */
    @GetMapping("/id")
    @ResponseBody
    public ResponseEntity<ReservationDTO> getReservationById(@RequestParam int utilisateurId, @RequestParam int veloId){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.findById(new ReservationId(utilisateurId, veloId))));
    }

    /**
     * Crée une nouvelle réservation.
     *
     * @param reservationDTO les détails de la réservation
     * @return la réservation créée
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.createReservation(
                                reservationMapper.toEntity(reservationDTO))));
    }

    /**
     * Met à jour une réservation existante.
     *
     * @param utilisateurId l'ID de l'utilisateur
     * @param veloId l'ID du vélo
     * @param reservationDTO les détails de la réservation
     * @return la réservation mise à jour
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<ReservationDTO> updateReservation(@RequestParam int utilisateurId, @RequestParam int veloId, @RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.updateReservation(new ReservationId(utilisateurId, veloId), reservationMapper.toEntity(reservationDTO))));
    }

    /**
     * Supprime une réservation.
     *
     * @param utilisateurId l'ID de l'utilisateur
     * @param veloId l'ID du vélo
     * @return un message de confirmation ou une erreur
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteReservation(@RequestParam int utilisateurId, @RequestParam int veloId){
        try {
            reservationService.deleteReservation(new ReservationId(utilisateurId, veloId));
            return ResponseEntity.ok("Réservation bien supprimée");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erreur : réservation non trouvée");
        }
    }
}