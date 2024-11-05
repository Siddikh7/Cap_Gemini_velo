package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "velo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}
