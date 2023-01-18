package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Renseignement;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RenseignService {

    Renseignement creer (Renseignement renseignement);
    List<Renseignement> lire();
    Renseignement modifier(Long idRen, Renseignement renseignement);
    String supprimer(Long idRen);

    ResponseEntity<?> creeRenseignement (Renseignement renseignement);
}
