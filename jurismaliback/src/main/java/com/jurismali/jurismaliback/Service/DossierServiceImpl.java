package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Dossier;
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
    public Dossier creer(Dossier dossier) {
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
                    d.setClient(dossier.getClient());
                    d.setStatut(dossier.getStatut());
                    // Video
                    return dossierRepo.save(d);
                }).orElseThrow(() -> new RuntimeException("Dossier non trouvable"));
    }

    @Override
    public String supprimer(Long idDoss) {
        dossierRepo.deleteById(idDoss);
        return "Dossier supprimer avec succès";
    }
}


