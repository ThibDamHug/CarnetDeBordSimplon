package co.simplon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class Answer {
	
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String content;
	@NotNull
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Question question;
	
}
