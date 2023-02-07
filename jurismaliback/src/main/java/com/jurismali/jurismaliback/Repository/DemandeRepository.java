package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
     //Demande findByIddemande(Long iddemande);
}
