package com.capgemini.polytech.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeloDTO {
    private int id;
    private String nom;
    private int quantite;
    private String description;
    private String pointGeo;

}