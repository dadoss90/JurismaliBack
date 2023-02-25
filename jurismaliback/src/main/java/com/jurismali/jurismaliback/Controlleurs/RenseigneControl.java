package com.jurismali.jurismaliback.Controlleurs;

import com.jurismali.jurismaliback.Models.Renseignement;
import com.jurismali.jurismaliback.Models.SaveFile;
import com.jurismali.jurismaliback.Service.RenseignService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("renseignement")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class RenseigneControl {

    @Autowired
    private final RenseignService renseignService;

    @PostMapping("/ajouter")
    public Renseignement create(@RequestBody Renseignement renseignement){
        return renseignService.creer(renseignement);
    }

    @GetMapping("/voir")
    public List<Renseignement> read(){
        return renseignService.lire();
    }

    @PutMapping("/update/{idRen}")
    public Renseignement update(@PathVariable Long idRen, @RequestBody Renseignement renseignement){
        return renseignService.modifier(idRen, renseignement);
    }
    @DeleteMapping("/supprimer/{idRen}")
    public String delete (@PathVariable Long idRen )
    {
        return renseignService.supprimer(idRen);
    }

    @PostMapping("/ajouterRenseignement")
    public ResponseEntity<?> createRenseignement(@Param("titre") String titre, @Param("description") String description,
                                                 @Param("file")MultipartFile file){
        Renseignement rensei = new Renseignement();
        String video = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            rensei.setTitre(titre);
            rensei.setDescription(description);
            if (file != null){
                rensei.setVideos(SaveFile.save("video", file, video));
            }

        }catch (Exception e){
            // TODO: handle exception
        }

        return renseignService.creeRenseignement(rensei);
    }
}
