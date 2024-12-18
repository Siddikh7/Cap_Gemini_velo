package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité représentant un utilisateur.
 */
@Entity(name = "utilisateur") // l'attribut name est utile si on veut donner un nom à l'entité qui soit différent de la classe
@Table(name = "utilisateur") // le nom de la table dans la base de données
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    /**
     * Identifiant unique de l'utilisateur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nom de l'utilisateur.
     */
    @Column(name = "nom", length = 100, nullable = false, unique = false)
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    @Column(name = "prenom", length = 100, nullable = false, unique = false)
    private String prenom;

    /**
     * Adresse e-mail de l'utilisateur.
     */
    @Column(name = "mail", length = 100, nullable = false, unique = false)
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     */
    @Column(name = "password", length = 100, nullable = false, unique = false)
    private String password;

    /**
     * Nom d'utilisateur.
     */
    @Column(name = "username", length = 100, nullable = false, unique = false)
    private String username;
}