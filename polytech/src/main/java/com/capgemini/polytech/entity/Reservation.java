package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @EmbeddedId //clé composite, Ce champ doit être uun objet complexe qui contient les clés étrangères utilisateurId et veloId
    private ReservationId id; //on doit définir une classe spécifique qui encapsule les cles primaires composites

    @ManyToOne //pour les clés étrangères
    @MapsId("utilisateurId") //utilisateurId est mappé à l'entité Utilisateur
    @JoinColumn(name="utilisateur_id") //Colonne dans la table Reservation
    private Utilisateur utilisateur; //Référence à l'entité Utilisateur

    @ManyToOne
    @MapsId("veloId")
    @JoinColumn(name = "velo_id")
    private Velo velo;

    @Column(name="reservation",length = 11, nullable = false, unique = false)
    private int reservation;


    public Reservation(int reservation, Utilisateur utilisateur, Velo velo) {
        this.reservation = reservation;
        this.utilisateur = utilisateur;
        this.velo = velo;
    }


}
