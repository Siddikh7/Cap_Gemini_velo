package com.capgemini.polytech.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationId implements Serializable {
    @Column(name = "utilisateur_id")
    private int utilisateurId;

    @Column(name = "velo_id")
    private int veloId;


    public ReservationId(int utilisateurId, int veloId) {
        this.utilisateurId = utilisateurId;
        this.veloId = veloId;
    }

//    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        ReservationId that = (ReservationId) object;
//        return utilisateurId == that.utilisateurId && veloId == that.veloId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(utilisateurId, veloId);
//    }
}
