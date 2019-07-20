package pgp.skillmapper.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.SkillDetails;

public interface SkillDetailsRepository extends JpaRepository<SkillDetails, Long> { 
}
