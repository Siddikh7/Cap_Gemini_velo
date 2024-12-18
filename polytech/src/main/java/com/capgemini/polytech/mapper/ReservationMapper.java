package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;

/**
 * Interface pour mapper entre l'entité Reservation et le DTO ReservationDTO.
 */
public interface ReservationMapper {

    /**
     * Convertit une entité Reservation en DTO ReservationDTO.
     *
     * @param reservation l'entité Reservation à convertir
     * @return le DTO ReservationDTO correspondant
     */
    ReservationDTO toDTO(Reservation reservation);

    /**
     * Convertit un DTO ReservationDTO en entité Reservation.
     *
     * @param reservationDTO le DTO ReservationDTO à convertir
     * @return l'entité Reservation correspondante
     */
    Reservation toEntity(ReservationDTO reservationDTO);
}