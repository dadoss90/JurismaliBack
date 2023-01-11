package com.jurismali.jurismaliback;

import com.jurismali.jurismaliback.Models.ERole;
import com.jurismali.jurismaliback.Models.Role;
import com.jurismali.jurismaliback.Models.Utilisateurs;
import com.jurismali.jurismaliback.Repository.RoleRepository;
import com.jurismali.jurismaliback.Repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JurismalibackApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	UtilisateursRepository utilisateursRepository;
	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(JurismalibackApplication.class, args);
	}

	public void run(String... args) throws Exception {
		//VERIFICATION DE L'EXISTANCE DU ROLE ADMIN AVANT SA CREATION
		if (roleRepository.findAll().size() == 0){
			roleRepository.save(new Role(ERole.ROLE_ADMIN));
			//roleRepository.save(new Role(ERole.ROLE_FORMATEUR));
			roleRepository.save(new Role(ERole.ROLE_USER));
		}
		if (utilisateursRepository.findAll().size() == 0){
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findByName(ERole.ROLE_ADMIN);
			roles.add(role);
			Utilisateurs utilisateurs = new Utilisateurs("traore","moussoudou@gmail.com", encoder.encode( "1234"),"ACI","Moussoudou traore","photo.png");
			utilisateurs.setRoles(roles);
			utilisateursRepository.save(utilisateurs);
		}
	}


}
