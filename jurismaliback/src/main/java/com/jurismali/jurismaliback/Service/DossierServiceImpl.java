package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Dossier;
import com.jurismali.jurismaliback.Models.DossierEtat;
import com.jurismali.jurismaliback.Repository.DossierRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DossierServiceImpl implements DossierService{
    @Autowired
    private final DossierRepo dossierRepo;


    @Override
    public Dossier valideDossier(Long idDoss) {
        Dossier dossier = dossierRepo.findDossierByIdDoss(idDoss);
        dossier.setDossierStatus(DossierEtat.TERMINER);
        return dossierRepo.save(dossier);
    }

    @Override
    public Dossier nonvalide(Long idDoss) {
        Dossier dossier = dossierRepo.findDossierByIdDoss(idDoss);
        dossier.setDossierStatus(DossierEtat.REJETTER);
        return dossierRepo.save(dossier);
    }


    @Override
    public Dossier creer(Dossier dossier) {
        dossier.setDossierStatus(DossierEtat.EN_COURS);
        return dossierRepo.save(dossier);
    }

    @Override
    public List<Dossier> lire() {
        return dossierRepo.findAll();
    }

    @Override
    public Dossier modifier(Long idDoss, Dossier dossier) {
        return dossierRepo.findById(idDoss)
                .map(d->{
                    d.setImageidentite(dossier.getImageidentite());
                    d.setDescription(dossier.getDescription());
                    d.setNumero(dossier.getNumero());
                    d.setEmail(dossier.getEmail());
                    return dossierRepo.save(d);
                }).orElseThrow(() -> new RuntimeException("Dossier non trouvable"));
    }

    @Override
    public String supprimer(Long idDoss) {
        dossierRepo.deleteById(idDoss);
        return "Dossier supprimer avec succès";
    }
}


