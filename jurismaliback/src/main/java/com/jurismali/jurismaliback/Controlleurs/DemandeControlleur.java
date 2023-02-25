package com.jurismali.jurismaliback.Controlleurs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.SaveFile;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Repository.DemandeRepository;
import com.jurismali.jurismaliback.Repository.UtilisateursRepository;
import com.jurismali.jurismaliback.security.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("demande")
@CrossOrigin
public class DemandeControlleur {
    @Autowired
    private DemandeService demandeService;


    @Autowired
    private DemandeRepository demandeRepository;


    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/AjouteruneDemandeCertificat/{idutilisateur}")
    public String faireDemandeCertificat(@Param("demande") String demande, @PathVariable("idutilisateur") Utilisateurs idutilisateur, @Param("document") MultipartFile document) throws JsonProcessingException {

        Demande demande1=new JsonMapper().readValue(demande,Demande.class);
        //Demande demande = new Demande();
        String image = StringUtils.cleanPath(document.getOriginalFilename());

        demande1.setUtilisateurs(idutilisateur);
        demande1.setDocument(image);

        demande1.setDocument(SaveFile.save("Demande",document,image));
        return demandeService.faireDemande(demande1,idutilisateur);

    }
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

    @PostMapping("/AjouteruneDemande2/{id}")
    public String faireDemande2(@Param("type") String type,@Param("description") String description, @Param("idutilisateur") String idutilisateur,
                                @PathVariable(value = "id") Utilisateurs id, @Param("document") MultipartFile document) throws JsonProcessingException {

        ObjectMapper mapper=new ObjectMapper();
        Utilisateurs user= mapper.  readValue(idutilisateur,Utilisateurs.class);


        //user.setPassword(encoder.encode(user.getEmail()));

        Demande demande = new Demande();
        String image = StringUtils.cleanPath(document.getOriginalFilename());

        System.err.println(description);

        demande.setDescription(description);
        demande.setTypeDemande(type);
        //demande.setDemandeur(utilisateursRepository.save(user));
        demande.setDocument(image);

        demande.setDocument(SaveFile.save("Demande",document,image));
        return demandeService.faireDemande(demande,id);

    }

    @GetMapping("/get/{idUser}")
    public List<Demande> getUserDemande(@PathVariable Utilisateurs idUser){

        return  demandeRepository.findByUtilisateurs(idUser);
    }
    @GetMapping("/get/type/{demandeType}")
    public List<Demande> getAllUserDemande(@PathVariable String demandeType){

        return  demandeService.getDemandeByType(demandeType);
    }
    @GetMapping("/accepter/{idDemande}")
    public Demande accepterDemande(@PathVariable Long idDemande){

        return  demandeService.accepter(idDemande);
    }
    @GetMapping("/refuser/{idDemande}")
    public Demande refuserDemande(@PathVariable Long idDemande){

        return  demandeService.rejeter(idDemande);
    }
    //::::::::::::::::
//    @PostMapping("/encours/{iddemande}")
//    public Demande encoursDemande(@PathVariable long iddemande) throws IOException {
//        return demandeService.encours(iddemande);
//    }
//
//    @PostMapping("/accepter/{iddemande}")
//    public Demande accepterdemande(@PathVariable long iddemande) throws IOException {
//        return demandeService.accepter(iddemande);
//    }
//
//    @PostMapping("/rejeter/{iddemande}")
//    public Demande rejeterdemande(@PathVariable long iddemande) throws IOException {
//        return demandeService.rejeter(iddemande);
//    }
//
//    // Voir Etat formation
//    @GetMapping("/regarder/{etat}")
//    //@PostAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    public Object rea(@PathVariable String etat){
//        if (etat.equals("encours")){
//            return demandeService.voiretat(EtatDemande.EN_COURS);
//        }
//        else if (etat.equals("accepter")) {
//            return demandeService.voiretat(EtatDemande.ACCEPTER);
//        }else if (etat.equals("rejeter")){
//            return demandeService.voiretat(EtatDemande.REJETTER);
//        } else {
//            return "ssss dddd";
//        }
//    }
}
