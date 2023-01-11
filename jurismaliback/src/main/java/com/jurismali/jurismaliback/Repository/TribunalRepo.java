package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Tribunal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribunalRepo extends JpaRepository<Tribunal, Long> {
}
