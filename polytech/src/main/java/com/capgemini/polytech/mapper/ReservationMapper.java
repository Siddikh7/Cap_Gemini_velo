package com.capgemini.polytech.mapper;

import org.mapstruct.Mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;


@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDTO toDTO(Reservation reservation);

    Reservation toEntity(ReservationDTO reservationDTO);

}
