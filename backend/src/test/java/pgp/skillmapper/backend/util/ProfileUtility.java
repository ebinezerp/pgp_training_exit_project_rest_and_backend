package pgp.skillmapper.backend.util;

import java.util.ArrayList;

import pgp.skillmapper.backend.enums.Knowledge;
import pgp.skillmapper.backend.model.Profile;
import pgp.skillmapper.backend.model.Skill;

public class ProfileUtility {
	
	public static Profile getProfileInstance() {
		Profile profile = new Profile();
		profile.setDesignation("Tech Mentor");
		profile.setExperience(3);
		profile.setLocation("Hyderabad");
		
		ArrayList<Skill> skills = new ArrayList<Skill>();
		Skill skill1=new Skill();
		skill1.setSkillName("Java");
		skill1.setVersion("8");
		skill1.setSkillExperience(2);
		skill1.setKnowledgeLevel(Knowledge.Expert);
		
		Skill skill2=new Skill();
		skill2.setSkillName("Angular");
		skill2.setVersion("6");
		skill2.setSkillExperience(1);
		skill2.setKnowledgeLevel(Knowledge.Intermediate);
		
		skills.add(skill1);
		skills.add(skill2);
		
		profile.setSkills(skills);
		
		return profile;
	}

}
