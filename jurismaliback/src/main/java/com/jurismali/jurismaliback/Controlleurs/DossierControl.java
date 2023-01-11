package com.jurismali.jurismaliback.Controlleurs;

import com.jurismali.jurismaliback.Models.Dossier;
import com.jurismali.jurismaliback.Service.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dossier")
@AllArgsConstructor
public class DossierControl {
    @Autowired
    private final DossierService dossierService;

    @PostMapping("/ajouter")
    public Dossier create(@RequestBody Dossier dossier){
        return dossierService.creer(dossier);
    }

    @GetMapping("/voir")
    public List<Dossier> read(){
        return dossierService.lire();
    }

    @PutMapping("/update/{idDoss}")
    public Dossier update(@PathVariable Long idDoss, @RequestBody Dossier dossier){
        return dossierService.modifier(idDoss, dossier);
    }
    @DeleteMapping("/supprimer/{idDoss}")
    public String delete (@PathVariable Long idDoss )
    {
        return dossierService.supprimer(idDoss);
    }
}

