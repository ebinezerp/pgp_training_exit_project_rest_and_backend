package pgp.skillmapper.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pgp.skillmapper.backend.model.Profile;
import pgp.skillmapper.backend.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	public Profile save(Profile profile) {
		try {
			return profileRepository.save(profile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Profile getProfile(Long id) {
		try {
			return profileRepository.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Profile getProfileByEmployeeId(Long id) {
		try {
			return profileRepository.findByEmployeeId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Profile> getProfileByLocation(String location) {
		try {
			return profileRepository.findByLocation(location);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Profile> getProfileByDesignation(String designation) {
		try {
			return profileRepository.findByDesignation(designation);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Profile> getProfileByExperience(Integer experience) {
		try {
			return profileRepository.findByExperienceGreaterThan(experience);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Profile> getProfileByDesignationAndExperience(String designation, Integer experience) {
		try {
			return profileRepository.findByDesignationAndExperienceGreaterThan(designation, experience);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Profile profie) {
		try {
			profileRepository.delete(profie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
