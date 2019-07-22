package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.SkillDetails;

public interface SkillDetailsRepository extends JpaRepository<SkillDetails, Long> { 
	
	/* public List<Skill> findBySkillNameIn(List<String> skillNames); */
}
