package com.jurismali.jurismaliback.Controlleurs;


import com.jurismali.jurismaliback.Models.SaveFile;
import com.jurismali.jurismaliback.Models.Tribunal;

import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Service.TribunalService;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("tribunal")
@AllArgsConstructor
public class TribunalControl {

    @Autowired
    private final TribunalService tribunalService;

    @PostMapping("/ajouter")
    public Tribunal create(@RequestBody Tribunal tribunal){
        return tribunalService.creer(tribunal);
    }

    @PostMapping("/ajoutertribunal")
    public MessageResponse createtribunal(@Param("nom") String nom, @Param("description") String description,
                                          @Param("composition") String composition, @Param("competence") String competence,
                                          @Param("adresse") String adresse, @Param("proceduree") String proceduree,
                                          @Param("file") MultipartFile file){
        Tribunal tribunal = new Tribunal();
        String photoprofile = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            tribunal.setComposition(composition);
            tribunal.setCompetence(competence);
            tribunal.setNom(nom);
            tribunal.setDescription(description);
            tribunal.setAdresse(adresse);
            tribunal.setProceduree(proceduree);
            if (file != null){

                tribunal.setImage(SaveFile.save("tribunal", file, photoprofile));
            }

        }catch (Exception e){
            // TODO: handle exception
        }
        return tribunalService.addtribunal(tribunal);
    }

    @GetMapping("/voir")
    public List<Tribunal> read(){
        return tribunalService.lire();
    }

    @PutMapping("/update/{idtribu}")
    public Tribunal update(@PathVariable Long idtribu, @RequestBody Tribunal tribunal){
        return tribunalService.modifier(idtribu, tribunal);
    }
    @DeleteMapping("/supprimer/{idtribu}")
    public String delete (@PathVariable Long idtribu )
    {
        return tribunalService.supprimer(idtribu);
    }
}

