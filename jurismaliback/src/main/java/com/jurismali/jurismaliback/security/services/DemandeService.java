package com.jurismali.jurismaliback.security.services;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.EtatDemande;
import com.jurismali.jurismaliback.Models.Utilisateurs;

import java.util.List;

public interface DemandeService {

    public String faireDemande(Demande demande, Utilisateurs utilisateurs);
    List<Demande> getDemandeByType(String typeDemande);
 //   Demande encours(Long iddemande);
    Demande accepter(Long iddemande);
    Demande rejeter (Long iddemande);
//
//    List<Object> voiretat(EtatDemande etat);

}
