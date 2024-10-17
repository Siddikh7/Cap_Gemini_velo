package com.capgemini.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ReservationId implements Serializable {
    @Column(name = "utilisateur_id")
    private int utilisateurId;

    @Column(name = "velo_id")
    private int veloId;


    public ReservationId(int utilisateurId, int veloId) {
        this.utilisateurId = utilisateurId;
        this.veloId = veloId;
    }
}
