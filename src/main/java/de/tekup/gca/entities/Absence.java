package de.tekup.gca.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate dateDebut;
	private LocalDate dateFin;

	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;


	public Absence( LocalDate dateDebut, LocalDate dateFin, User user) {
		super();

		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.user = user;
	}
	
	
	

}
