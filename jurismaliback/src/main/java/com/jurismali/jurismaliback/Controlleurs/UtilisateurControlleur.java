package com.jurismali.jurismaliback.Controlleurs;

import com.jurismali.jurismaliback.Models.ERole;
import com.jurismali.jurismaliback.Models.SaveFile;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Service.UtilisateurService;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("utilisateur")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UtilisateurControlleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @PutMapping("/modifierProfile/{id}")
    public MessageResponse modifierprofile(@PathVariable Long id, @Param("file") MultipartFile file) {

        Utilisateurs utilisateurs = new Utilisateurs();
        String photoprofile = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            utilisateurs.setPhoto(SaveFile.save("user", file, photoprofile));
        }catch (Exception e){
            // TODO: handle exception
        }
        return utilisateurService.modifierprofile(id, utilisateurs);
    }

    @PutMapping("/update/{id}")
    public Utilisateurs modifier(@PathVariable Long id, @RequestBody Utilisateurs utilisateurs) {
        return utilisateurService.modifier(id, utilisateurs);
    }
    @GetMapping("/avocatListe")
    public List<Utilisateurs> getAvocatListes(){
        return utilisateurService.findUtilisateurParRole(ERole.ROLE_AVOCAT);
    }
    @GetMapping("/clientListe")
    public List<Utilisateurs> getclientListes(){
        return utilisateurService.findUtilisateurParRole(ERole.ROLE_USER);
    }

}
