package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	public List<Skill>  findBySkillNameIn(List<String> skillNames);
}
