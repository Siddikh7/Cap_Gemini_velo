package com.capgemini.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Classe représentant la clé composite pour l'entité Reservation.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationId implements Serializable {

    /**
     * ID de l'utilisateur.
     */
    @Column(name = "utilisateur_id")
    private int utilisateurId;

    /**
     * ID du vélo.
     */
    @Column(name = "velo_id")
    private int veloId;

    /**
     * Constructeur de la classe ReservationId.
     *
     * @param utilisateurId l'ID de l'utilisateur
     * @param veloId l'ID du vélo
     */
    public ReservationId(int utilisateurId, int veloId) {
        this.utilisateurId = utilisateurId;
        this.veloId = veloId;
    }
}