package co.simplon.models;

import java.util.Date;
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
 * @author Abdel Ahmar
 *
 */
@Entity
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Diary {

	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String name;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	@NotEmpty
	private String introduction;
	@NotNull
	@ManyToOne
	private Promo promo;

	@OneToMany(mappedBy = "diary")
	private List<Conclusion> conclusions;

	@OneToMany(mappedBy = "diary")
	private List<Question> questions;
}
