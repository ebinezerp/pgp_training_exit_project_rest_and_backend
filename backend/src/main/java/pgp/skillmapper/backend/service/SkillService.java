package pgp.skillmapper.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pgp.skillmapper.backend.model.Skill;
import pgp.skillmapper.backend.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public Skill save(Skill skill) {
		try {
			return skillRepository.save(skill);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Skill update(Skill skill) {
		try {
			return skillRepository.save(skill);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Skill skill) {
		try {
			skillRepository.delete(skill);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
