package co.simplon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Abdel Ahmar
 *
 */
@Entity
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Conclusion {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String content;
	
	@ManyToOne
	private Diary diary;
	
	@ManyToOne
	private User user;

}
