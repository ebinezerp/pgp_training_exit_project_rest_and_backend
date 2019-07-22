package pgp.skillmapper.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Skill Name should not be blank")
	@NotNull(message = "Skill Name should not be null")
	@Column(nullable = false, unique = true)
	private String skillName;
	
	
	@OneToOne(mappedBy = "skill")
	@ToString.Exclude
	@JsonIgnore
	private SkillDetails skillDetails;

}
