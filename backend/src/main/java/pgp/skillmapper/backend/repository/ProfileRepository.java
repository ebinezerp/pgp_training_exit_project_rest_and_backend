package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	public Profile findByEmployeeId(Long id);
	public List<Profile> findByLocation(String location);
	public List<Profile> findByDesignation(String designation);
	public List<Profile> findByDesignationAndExperienceGreaterThan(String designation, Integer experience);
	public List<Profile> findByExperienceGreaterThan(Integer experience);
}
