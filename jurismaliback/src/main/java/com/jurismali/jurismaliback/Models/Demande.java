package com.jurismali.jurismaliback.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "Demande")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demande {

//    public static final EtatDemande EN_COURS = EtatDemande.EN_COURS;
//    public static final EtatDemande ACCEPTER = EtatDemande.ACCEPTER;
//    public static final EtatDemande REJETTER = EtatDemande.REJETTER;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddemande;
    private String libelle;
    private String document;

    private String typeDemande;
    private String nomDemandeur;
    private String prenomDemandeur;
    private Date dateDemandeur;
    private String lieuNaissance;
    private String pereDemandeur;
    private String mereDemandeur;
    private String professionDemandeur;
    private String situationDemandeur;
    private String domicileDemandeur;
    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    @ManyToOne
    Utilisateurs utilisateurs;

   /* @ManyToOne
    Utilisateurs demandeur;*/
}
