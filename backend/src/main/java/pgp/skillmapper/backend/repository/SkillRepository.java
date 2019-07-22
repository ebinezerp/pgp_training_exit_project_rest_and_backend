package pgp.skillmapper.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	
}
