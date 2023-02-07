package com.jurismali.jurismaliback.security.services;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.Utilisateurs;

public interface DemandeService {

    public String faireDemande(Demande demande, Utilisateurs utilisateurs);

}
