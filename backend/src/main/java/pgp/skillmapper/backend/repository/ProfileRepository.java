package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pgp.skillmapper.backend.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	public Profile findByEmployeeId(Long id);

	public List<Profile> findByLocation(String location);

	public List<Profile> findByDesignation(String designation);

	public List<Profile> findByDesignationAndExperienceGreaterThan(String designation, Integer experience);

	public List<Profile> findByExperienceGreaterThan(Integer experience);

	@Query("select p from Profile p where p.id IN "
			+ "(select sd.profile from SkillDetails sd where sd.skill IN "
			+ "(select s.id from Skill s where s.skillName IN (:skillNames))) or p.location =:location")
	public List<Profile> getProfiles(@Param("skillNames") List<String> skillNames, @Param("location")String location);
}
