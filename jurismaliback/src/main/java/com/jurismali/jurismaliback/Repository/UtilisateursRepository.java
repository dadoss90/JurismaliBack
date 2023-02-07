package com.jurismali.jurismaliback.Repository;

import com.jurismali.jurismaliback.Models.ERole;
import com.jurismali.jurismaliback.Models.Role;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {

  Optional<Utilisateurs> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  List<Utilisateurs> findByRoles(String role);

}
