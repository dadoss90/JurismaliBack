package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Dossier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DossierService {

    Dossier valideDossier(Long idDoss);

    Dossier nonvalide(Long idDoss);



    Dossier creer (Dossier dossier);
    List<Dossier> lire();
    Dossier modifier(Long idDoss, Dossier dossier);
    String supprimer(Long idDoss);
}
