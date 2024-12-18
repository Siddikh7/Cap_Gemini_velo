package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité représentant un vélo.
 */
@Entity
@Table(name = "velo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Velo {

    /**
     * Identifiant unique du vélo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nom du vélo.
     */
    @Column(name = "nom", length = 100, nullable = false, unique = false)
    private String nom;

    /**
     * Quantité de vélos disponibles.
     */
    @Column(name = "quantite", length = 11, nullable = false, unique = false)
    private int quantite;

    /**
     * Description du vélo.
     */
    @Column(name = "description", length = 100, nullable = true, unique = false)
    private String description;

    /**
     * Point géographique où se trouve le vélo.
     */
    @Column(name = "point_geo", length = 100, nullable = false, unique = false)
    private String pointGeo;
}