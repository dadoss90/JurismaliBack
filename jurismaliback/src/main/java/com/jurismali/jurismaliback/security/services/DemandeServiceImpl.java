package com.jurismali.jurismaliback.security.services;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.EtatDemande;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Repository.DemandeRepository;
import com.jurismali.jurismaliback.Repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Demande> getDemandeByType(String typeDemande) {
        return demandeRepository.findByLibelleOrderByIddemande(typeDemande);
    }

    @Override
    public Demande accepter(Long iddemande) {
        Optional<Demande> demande = demandeRepository.findById(iddemande);
        demande.get().setEtat(EtatDemande.ACCEPTER);
        return demandeRepository.save(demande.get());
    }

    @Override
    public Demande rejeter(Long iddemande) {
        Optional<Demande> demande = demandeRepository.findById(iddemande);
        demande.get().setEtat(EtatDemande.REJETTER);
        return demandeRepository.save(demande.get());
    }


    //;;;;;;;;;;;;;;;
//    @Override
//    public Demande encours(Long iddemande) {
//        Demande demande=demandeRepository.findDemandeByIddemande(iddemande);
//        demande.setEtat(Demande.EN_COURS);
//        return demandeRepository.save(demande);
//    }
//
//    @Override
//    public Demande accepter(Long iddemande) {
//        Demande demande=demandeRepository.findDemandeByIddemande(iddemande);
//        demande.setEtat(Demande.ACCEPTER);
//        return demandeRepository.save(demande);
//    }
//
//    @Override
//    public Demande rejeter(Long iddemande) {
//        Demande demande=demandeRepository.findDemandeByIddemande(iddemande);
//        demande.setEtat(Demande.REJETTER);
//        return demandeRepository.save(demande);
//    }

//
//    @Override
//    public List<Object> voiretat(EtatDemande etatDemande) {
//        return demandeRepository.findByDemande(etatDemande);
//    }
}
