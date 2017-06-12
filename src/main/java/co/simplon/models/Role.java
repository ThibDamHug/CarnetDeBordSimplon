package co.simplon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty
	private String name;

}
