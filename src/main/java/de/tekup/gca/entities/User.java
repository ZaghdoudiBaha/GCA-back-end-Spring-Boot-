package de.tekup.gca.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private boolean accepted;
	
	

	public User(String login, String password, String nom, String prenom, String mail, String tel, boolean accepted) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.accepted = accepted;
	}

	@OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonBackReference
	List<Absence> absences;
	
	@OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonBackReference
	List<Conge> conges;
	
	@OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonBackReference
	List<Reclamation> reclamations;
	
	@OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonBackReference
	List<Message> messages;
	
	
	

}
