package pgp.skillmapper.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pgp.skillmapper.backend.model.SkillDetails;
import pgp.skillmapper.backend.repository.SkillDetailsRepository;


@Service
public class SkillDetailsService {

	@Autowired
	private SkillDetailsRepository skillDetailsRepository;

	public SkillDetails save(SkillDetails skill) {
		try {
			return skillDetailsRepository.save(skill);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SkillDetails update(SkillDetails skill) {
		try {
			return skillDetailsRepository.save(skill);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(SkillDetails skillDetails) {
		try {
			skillDetailsRepository.delete(skillDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
