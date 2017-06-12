package co.simplon.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Promo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;	
	
	private Date startDate;
	
	private Date endDate;

}
