package pgp.skillmapper.backend.service;

import java.util.List;

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

	public boolean delete(Skill skill) {
		try {
			skillRepository.delete(skill);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public Skill getSkill(Long id) {
		try {
			return skillRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Skill> getSkills() {
		try {
			return skillRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
