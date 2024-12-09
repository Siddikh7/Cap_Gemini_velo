package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;




public interface ReservationMapper {

    ReservationDTO toDTO(Reservation reservation);

    Reservation toEntity(ReservationDTO reservationDTO);

}
