package co.simplon.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Franck Pesson
 *
 */
@Entity
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Question {
	
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String content;
	@NotNull
    @ManyToOne
    private Diary diary ;
    @NotNull
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

}
