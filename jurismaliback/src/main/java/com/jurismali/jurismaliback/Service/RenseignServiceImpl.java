package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Renseignement;
import com.jurismali.jurismaliback.Repository.RenseignementRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RenseignServiceImpl implements RenseignService{

    @Autowired
    private final RenseignementRepo renseignementRepo;

    @Override
    public Renseignement creer(Renseignement renseignement) {
        return renseignementRepo.save(renseignement);
    }

    @Override
    public List<Renseignement> lire() {
        return renseignementRepo.findAll();
    }

    @Override
    public Renseignement modifier(Long idRen, Renseignement renseignement) {
        return renseignementRepo.findById(idRen)
                .map(r->{
                    r.setTitre(renseignement.getTitre());
                    r.setDescription(renseignement.getDescription());
                    // Video
                    return renseignementRepo.save(r);
                }).orElseThrow(() -> new RuntimeException("Renseingnement non trouvable"));
    }

    @Override
    public String supprimer(Long idRen) {
        renseignementRepo.deleteById(idRen);
        return "Renseignement supprimer avec succès";
    }
}
