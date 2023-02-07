package com.jurismali.jurismaliback.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "Dossier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoss;
    private String imageidentite;
    private String numero;
    private String description;
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private DossierEtat dossierStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Etatypeprobl etatypeprobl;
}
