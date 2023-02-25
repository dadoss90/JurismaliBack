package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Demande;
import com.jurismali.jurismaliback.Models.EtatDemande;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {


   // Demande findDemandeByIddemande(Long iddemande); //Validation

   // List<Object> findByDemande (EtatDemande etat);

    List<Demande> findByUtilisateurs(Utilisateurs utilisateurs);
    List<Demande> findByLibelleOrderByIddemande(String name);
}
