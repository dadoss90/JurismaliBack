package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Tribunal;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TribunalRepo extends JpaRepository<Tribunal, Long> {

    Boolean existsByNom(String nom);
    Optional<Tribunal> findByNom (String nom);

}
