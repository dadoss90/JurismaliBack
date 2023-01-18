package com.jurismali.jurismaliback.Service;


import com.jurismali.jurismaliback.Models.Tribunal;
import com.jurismali.jurismaliback.Repository.TribunalRepo;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TribunalServiceImpl implements TribunalService{

    @Autowired
    private final TribunalRepo tribunalRepo;

    @Override
    public Tribunal creer(Tribunal tribunal) {

        return tribunalRepo.save(tribunal);
    }

    @Override
    public MessageResponse addtribunal(Tribunal tribunal) {
        if (tribunalRepo.existsByNom(tribunal.getNom()) || tribunal.getNom().isEmpty()) {
            MessageResponse message = new MessageResponse("Désolé ! Ce tribunal existe déjà ou le champ nom n'est pas remplis ! ");
            return message;
        }
        tribunalRepo.save(tribunal);
        MessageResponse message = new MessageResponse("Tribunal ajouter avec succes ! ");
        return message;
    }

    @Override
    public List<Tribunal> lire() {
        return tribunalRepo.findAll();
    }

    @Override
    public Tribunal modifier(Long idtribu, Tribunal tribunal) {
        return tribunalRepo.findById(idtribu)
                .map(t->{
                    t.setNom (tribunal.getNom());
                    t.setAdresse(tribunal.getAdresse());
                    t.setDescription(tribunal.getDescription());
                    t.setCompetence(tribunal.getCompetence());
                    t.setComposition(tribunal.getComposition());
                    t.setProceduree(tribunal.getProceduree());

                    // Video
                    return tribunalRepo.save(t);
                }).orElseThrow(() -> new RuntimeException("Tribunal non trouvable"));
    }

    @Override
    public String supprimer(Long idRen) {
        tribunalRepo.deleteById(idRen);
        return "Tribunal supprimer avec succès";
    }
}

