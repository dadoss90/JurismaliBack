package com.jurismali.jurismaliback.Repository;


import com.jurismali.jurismaliback.Models.ERole;
import com.jurismali.jurismaliback.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(ERole name);
}
