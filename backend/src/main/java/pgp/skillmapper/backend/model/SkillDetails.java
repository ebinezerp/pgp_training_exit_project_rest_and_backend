package pgp.skillmapper.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class SkillDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Version Should not be empty")
	@NotBlank(message = "Version Should not be blank")
	@Column(unique = false, nullable = false)
	private String version;
	
	@Enumerated(EnumType.STRING)
	private Knowledge knowledgeLevel;
	
	@NotNull(message = "Skill Experience should not be null")
	@Range(min = 0, message = "Experience should not be negative")
	private Integer skillExperience;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@ToString.Exclude
	@JsonIgnore
	private Profile profile;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Skill skill;
}


