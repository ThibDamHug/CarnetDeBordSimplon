package co.simplon.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Franck Pesson
 *
 */
//Dit a hibernate que ca correspond a une table
@Entity
//Lombok pour creer auto les getter/setter
@Getter
@Setter
//@Table ( si nom different de table name ="" )
//Evite de boucler à l'infini dans manyTomany
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(Include.NON_NULL)
public class User {
	
	//Cle primaire
	@Id
	//Previent que la cle est genere  automatiquement
	@GeneratedValue//(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
		
	private String password;
	
	private String email;
	
	@OneToOne
	private User pair;
	
	@ManyToOne
	private Promo promo;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Conclusion> conclusions;
	
// Methode utile pour integrer la derniere maj	
// @UpdateTimestamp
// private Timestamp derniereMaj;
	
	//Entité Maitre
	
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//	//name = table de joiture;type_id = foreign key de la table actuelle; role_id = fk de la table opposé
//	@JoinTable(name="utilisateur_role", joinColumns = {
//			@JoinColumn(name = "utilisateur_id")},inverseJoinColumns = {@JoinColumn(name ="role_id")
//			})
//	@JsonManagedReference
//	private List <Role> roles ;

}
