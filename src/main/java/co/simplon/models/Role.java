package co.simplon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Damien Pradier
 *
 */
@Entity
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	// Entité esclave lié par List <Role> roles
	// @JsonBackReference
	// @ManyToMany(mappedBy = "roles")

	// @OneToMany(mappedBy="role")
	// private List <User> users;

}
