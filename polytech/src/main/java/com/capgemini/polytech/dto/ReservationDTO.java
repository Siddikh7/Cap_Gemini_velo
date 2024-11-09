package com.capgemini.polytech.dto;

import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.entity.Velo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    private int reservation;
    private int veloId;
    private int utilisateurId;

}
