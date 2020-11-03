package de.tekup.gca;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.tekup.gca.entities.Absence;
import de.tekup.gca.entities.Conge;
import de.tekup.gca.entities.Reclamation;
import de.tekup.gca.entities.User;
import de.tekup.gca.repository.AbsenceRepo;
import de.tekup.gca.repository.CongeRepo;
import de.tekup.gca.repository.ReclamationRepo;
import de.tekup.gca.repository.UserRepo;


@SpringBootApplication
public class GestionCongeAbsenceApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AbsenceRepo absenceRepo;
	@Autowired
	private CongeRepo congeRepo;
	@Autowired
	private ReclamationRepo reclamationRepo;

	public static void main(String[] args) {
		
		SpringApplication.run(GestionCongeAbsenceApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		  
		   User u = userRepo.save( new User("user", "user", "Baha", "Zaghdoudi", "zagdoudi@gmail.com", "98654321", true));
		   User u2 = userRepo.save( new User("ayoub", "ayoub", "ayoub", "Belgacem", "ayoub@hotmail.fr", "26456123", true));
		  
		   absenceRepo.save(new Absence(LocalDate.of(2020, 9, 02), LocalDate.of(2020, 9, 03),u));
		   absenceRepo.save(new Absence(LocalDate.of(2020, 9, 05), LocalDate.of(2020, 9, 06),u2));
		   congeRepo.save(new Conge(LocalDate.of(2020, 9, 05), LocalDate.of(2020, 9, 10), "non", false, true, 30, u));
		   congeRepo.save(new Conge(LocalDate.of(2020, 9, 05), LocalDate.of(2020, 9, 10), "non", false, true, 30, u2));
		   
		   reclamationRepo.save(new Reclamation("bonjour ayoub", "bonjour", LocalDate.of(2020, 10, 01), u));
		   reclamationRepo.save(new Reclamation("bonjour ayoub", "bonjour", LocalDate.of(2020, 11, 01), u2));


		
		
	}
	
	 
	
	

}
