package com.jurismali.jurismaliback.security.services;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Repository.DemandeRepository;
import com.jurismali.jurismaliback.Repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Override
    public String faireDemande(Demande demande, Utilisateurs utilisateurs) {
        if (utilisateursRepository.findById(utilisateurs.getId()) != null){
            demande.setUtilisateurs(utilisateurs);
            demandeRepository.save(demande);
            return " Demande envoyer avec succès";
        }
        else{
            return " Compte introuvable";
        }

    }
}
