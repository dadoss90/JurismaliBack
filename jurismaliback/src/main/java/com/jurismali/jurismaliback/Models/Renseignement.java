package com.jurismali.jurismaliback.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "Renseignement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Renseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRen;
    private String titre;
    private String description;
    //private String videos ;
}
