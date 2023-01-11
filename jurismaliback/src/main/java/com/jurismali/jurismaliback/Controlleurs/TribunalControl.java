package com.jurismali.jurismaliback.Controlleurs;


import com.jurismali.jurismaliback.Models.Tribunal;

import com.jurismali.jurismaliback.Service.TribunalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

