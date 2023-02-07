package com.jurismali.jurismaliback.Service;

import com.jurismali.jurismaliback.Models.ERole;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.payload.request.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtilisateurService {

    MessageResponse modifierprofile (Long id, Utilisateurs utilisateurs);

    Utilisateurs modifier(Long id, Utilisateurs utilisateurs);

    List<Utilisateurs> findUtilisateurParRole(ERole roleName);

}
