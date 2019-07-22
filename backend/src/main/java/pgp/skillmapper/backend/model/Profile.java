package pgp.skillmapper.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Designation should not be empty")
	@NotNull(message = "Designation should not be null")
	@Pattern(regexp = "^[a-zA-Z\\s]{3,}$", message = "Min 3 characters, only alphabet are allowed")
	private String designation;

	
	@NotNull(message = "Experience should not be null")
	@Range(min = 0, message = "Experience should not be negative")
	private Integer experience;

	@NotBlank(message = "Location should not be empty")
	@NotNull(message = "Location should not be null")
	private String location;

	@OneToOne(fetch = FetchType.EAGER)
	@ToString.Exclude
	@JsonIgnore
	private Employee employee;

	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	private List<SkillDetails> skillDetailsList;
}
