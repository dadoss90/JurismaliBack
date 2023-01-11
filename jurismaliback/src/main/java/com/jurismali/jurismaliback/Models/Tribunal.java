package com.jurismali.jurismaliback.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tribunal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tribunal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String description;
    private String competence;
    private String composition;
    private String proceduree;
    //private String image;

}
