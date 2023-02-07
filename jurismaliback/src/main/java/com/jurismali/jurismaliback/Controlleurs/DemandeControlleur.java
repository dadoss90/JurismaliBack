package com.jurismali.jurismaliback.Controlleurs;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.SaveFile;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.payload.Autres.ConfigImages;
import com.jurismali.jurismaliback.security.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("demande")
@CrossOrigin
public class DemandeControlleur {
    @Autowired
    private DemandeService demandeService;

    @PostMapping("/AjouteruneDemande/{idutilisateur}")
    public String faireDemande(@Param("libelle") String libelle, @PathVariable("idutilisateur")Utilisateurs idutilisateur, @Param("document") MultipartFile document)  {

        Demande demande = new Demande();
        String image = StringUtils.cleanPath(document.getOriginalFilename());

        demande.setLibelle(libelle);
        demande.setUtilisateurs(idutilisateur);
        demande.setDocument(image);

        demande.setDocument(SaveFile.save("Demande",document,image));
        return demandeService.faireDemande(demande,idutilisateur);

    }
}
