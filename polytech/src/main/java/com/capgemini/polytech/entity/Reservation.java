package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité représentant une réservation.
 */
@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    /**
     * Clé composite pour la réservation, contenant les clés étrangères utilisateurId et veloId.
     */
    @EmbeddedId //clé composite, Ce champ doit être un objet complexe qui contient les clés étrangères utilisateurId et veloId
    private ReservationId id; //on doit définir une classe spécifique qui encapsule les clés primaires composites

    /**
     * Référence à l'entité Utilisateur.
     */
    @ManyToOne //pour les clés étrangères
    @MapsId("utilisateurId") //utilisateurId est mappé à l'entité Utilisateur
    @JoinColumn(name = "utilisateur_id") //Colonne dans la table Reservation
    private Utilisateur utilisateur; //Référence à l'entité Utilisateur

    /**
     * Référence à l'entité Velo.
     */
    @ManyToOne
    @MapsId("veloId")
    @JoinColumn(name = "velo_id")
    private Velo velo;

    /**
     * Champ représentant la réservation.
     */
    @Column(name="reservation", length = 11, nullable = false, unique = false)
    private int reservation;

    /**
     * Constructeur de la classe Reservation.
     *
     * @param reservation le nombre de réservations
     * @param utilisateur l'utilisateur associé à la réservation
     * @param velo le vélo associé à la réservation
     */
    public Reservation(int reservation, Utilisateur utilisateur, Velo velo) {
        this.reservation = reservation;
        this.utilisateur = utilisateur;
        this.velo = velo;
    }
}