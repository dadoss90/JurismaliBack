package com.jurismali.jurismaliback.Controlleurs;

import com.jurismali.jurismaliback.Models.Renseignement;
import com.jurismali.jurismaliback.Service.RenseignService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("renseignement")
@AllArgsConstructor
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
}
