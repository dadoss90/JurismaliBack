package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepo extends JpaRepository<Dossier,Long> {
}
