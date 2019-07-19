package pgp.skillmapper.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pgp.skillmapper.backend.enums.Knowledge;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Skill Should not be empty")
	@NotBlank(message = "Skill Should not be blank")
	@Column(unique = true, nullable = false)
	private String skillName;
	
	@NotNull(message = "Version Should not be empty")
	@NotBlank(message = "Version Should not be blank")
	@Column(unique = true, nullable = false)
	private String version;
	
	@Enumerated(EnumType.STRING)
	private Knowledge knowledgeLevel;
	
	@NotNull(message = "Skill Experience should not be null")
	@Range(min = 0, message = "Experience should not be negative")
	private Integer skillExperience;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@ToString.Exclude
	@JsonIgnore
	private List<Profile> profiles;
}


