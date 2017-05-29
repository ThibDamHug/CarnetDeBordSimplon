package co.simplon.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Promo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//@NotBlank(message = "Name can't empty!")
	private String name;
	
	//@NotBlank(message = "Name can't empty!")
	private Date startDate;
	
	//@NotBlank(message = "Name can't empty!")
	private Date endDate;

}
