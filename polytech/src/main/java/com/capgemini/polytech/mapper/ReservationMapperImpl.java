package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.entity.Velo;
import com.capgemini.polytech.repository.UtilisateurRepository;
import com.capgemini.polytech.repository.VeloRepository;
import org.springframework.stereotype.Component;

/**
 * Implémentation de l'interface ReservationMapper pour mapper entre l'entité Reservation et le DTO ReservationDTO.
 */
@Component
public class ReservationMapperImpl implements ReservationMapper {

    private UtilisateurRepository utilisateurRepository;
    private VeloRepository veloRepository;

    /**
     * Constructeur de la classe ReservationMapperImpl.
     *
     * @param utilisateurRepository le repository pour les entités Utilisateur
     * @param veloRepository le repository pour les entités Velo
     */
    public ReservationMapperImpl(UtilisateurRepository utilisateurRepository, VeloRepository veloRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.veloRepository = veloRepository;
    }

    /**
     * Convertit une entité Reservation en DTO ReservationDTO.
     *
     * @param reservation l'entité Reservation à convertir
     * @return le DTO ReservationDTO correspondant
     */
    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservation(reservation.getReservation());
        reservationDTO.setUtilisateurId(reservation.getUtilisateur().getId());
        reservationDTO.setVeloId(reservation.getVelo().getId());
        return reservationDTO;
    }

    /**
     * Convertit un DTO ReservationDTO en entité Reservation.
     *
     * @param reservationDTO le DTO ReservationDTO à convertir
     * @return l'entité Reservation correspondante
     */
    public Reservation toEntity(ReservationDTO reservationDTO) {
        ReservationId reservationId = new ReservationId(reservationDTO.getUtilisateurId(), reservationDTO.getVeloId());

        Utilisateur utilisateur = utilisateurRepository.findById(reservationDTO.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        Velo velo = veloRepository.findById(reservationDTO.getVeloId())
                .orElseThrow(() -> new IllegalArgumentException("Velo non trouvé"));

        return new Reservation(reservationId, utilisateur, velo, reservationDTO.getReservation());
    }
}