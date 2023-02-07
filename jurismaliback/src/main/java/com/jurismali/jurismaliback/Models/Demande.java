package com.jurismali.jurismaliback.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
//@Table(name = "Demande")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddemande;
    private String libelle;
    private String document;



    @ManyToOne
    Utilisateurs utilisateurs;
}
