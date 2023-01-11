package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Renseignement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RenseignService {

    Renseignement creer (Renseignement renseignement);
    List<Renseignement> lire();
    Renseignement modifier(Long idRen, Renseignement renseignement);
    String supprimer(Long idRen);
}
