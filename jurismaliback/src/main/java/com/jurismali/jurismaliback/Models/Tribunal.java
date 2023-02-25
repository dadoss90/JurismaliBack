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
    @Lob
    private String description;
    @Lob
    private String competence;
    @Lob
    private String composition;
    private String proceduree;
    private String image;

}
