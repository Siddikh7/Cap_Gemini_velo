package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "velo")
@Getter
@Setter
public class Velo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom",length = 100, nullable = false, unique = false)
    private String nom;

    @Column(name="quantite",length = 11, nullable = false, unique = false)
    private int quantite;

    @Column(name="description",length = 100, nullable = true, unique = false)
    private String description;

    @Column(name="point_geo",length = 100, nullable = false, unique = false)
    private String pointGeo;

    public Velo() {}
    public Velo(String nom, int quantite, String description, String pointGeo) {
        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
        this.pointGeo = pointGeo;
    }

}
