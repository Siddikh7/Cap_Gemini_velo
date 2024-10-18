package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "utilisateur") //l'att name estutile si on veut donner un nom à l'entité qui soit différente de la classe
@Table(name = "utilisateur") //le nom de la table dans la base de données
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom",length = 100, nullable = false, unique = false)
    private String nom;

    @Column(name="prenom",length = 100, nullable = false, unique = false)
    private String prenom;

    @Column(name="mail",length = 100, nullable = false, unique = false)
    private String mail;

    @Column(name="password",length = 100, nullable = false, unique = false)
    private String password;

    @Column(name="username",length = 100, nullable = false, unique = false)
    private String username;

}
