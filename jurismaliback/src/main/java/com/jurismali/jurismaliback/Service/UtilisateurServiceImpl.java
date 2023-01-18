package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Repository.UtilisateursRepository;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateursRepository utilisateursRepository;


    @Override
    public MessageResponse modifierprofile(Long id, Utilisateurs utilisateurs) {
        if (utilisateursRepository.findById(id) != null){
            Utilisateurs updateprofile = utilisateursRepository.findById(id).get();

            updateprofile.setPhoto(updateprofile.getPhoto());
            utilisateursRepository.saveAndFlush(updateprofile);
            MessageResponse message = new MessageResponse("Profile modifier avec succes ! ");
            return message;
        }else {
            MessageResponse message = new MessageResponse("cet utilisateur n'existe pas !");
            return message;
        }
    }

    @Override
    public Utilisateurs modifier(Long id, Utilisateurs utilisateurs) {
        return utilisateursRepository.findById(id)
                .map(u-> {
                    u.setUsername(utilisateurs.getUsername());
                    u.setNomcomplet(utilisateurs.getNomcomplet());
                    u.setEmail(utilisateurs.getEmail());
                    u.setNumerotelephone(utilisateurs.getNumerotelephone());
                    u.setAdresse(utilisateurs.getAdresse());
                    u.setPassword(utilisateurs.getPassword());
//                    u.setPhoto(utilisateurs.getPhoto());
                    return  utilisateursRepository.save(u);
                }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !!"));
    }

}
