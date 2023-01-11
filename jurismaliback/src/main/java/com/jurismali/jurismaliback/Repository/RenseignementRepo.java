package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.Renseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenseignementRepo extends JpaRepository<Renseignement,Long> {

}
