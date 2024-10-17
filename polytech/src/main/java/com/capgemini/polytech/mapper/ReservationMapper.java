package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservation(reservationDTO.getReservation());
        return reservationDTO;
    }
    public Reservation toEntity(ReservationDTO reservationDTO) {
        return new Reservation(reservationDTO.getReservation(), reservationDTO.getUtilisateur(), reservationDTO.getVelo());
    }
}
