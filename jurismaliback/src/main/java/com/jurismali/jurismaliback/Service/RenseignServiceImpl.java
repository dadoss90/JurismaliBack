package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Renseignement;
import com.jurismali.jurismaliback.Repository.RenseignementRepo;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<?> creeRenseignement(Renseignement renseignement) {
        if (renseignementRepo.existsByTitre(renseignement.getTitre())){
            return ResponseEntity.badRequest().body(new MessageResponse("ce renseignement existe déjàs ! veillez la modifier "));
        }
        renseignementRepo.save(renseignement);
        return ResponseEntity.badRequest().body(new MessageResponse("Votre renseignement est éffectuer avec succès "));
    }
}
