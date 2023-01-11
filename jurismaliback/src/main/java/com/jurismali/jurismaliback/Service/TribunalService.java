package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.Tribunal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TribunalService {
    Tribunal creer (Tribunal tribunal);
    List<Tribunal> lire();
    Tribunal modifier(Long idtribu, Tribunal tribunal);
    String supprimer(Long idtribu);
}

