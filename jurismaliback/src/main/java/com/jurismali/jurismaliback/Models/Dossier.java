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
    private String client;
    private String statut;
}
