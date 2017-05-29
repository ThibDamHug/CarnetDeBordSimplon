package co.simplon.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Question {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String content;
	
    @ManyToOne
    private Diary diary ;
    
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

}
