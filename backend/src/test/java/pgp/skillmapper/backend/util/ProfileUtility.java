package pgp.skillmapper.backend.util;

import java.util.ArrayList;

import pgp.skillmapper.backend.enums.Knowledge;
import pgp.skillmapper.backend.model.Profile;
import pgp.skillmapper.backend.model.SkillDetails;

public class ProfileUtility {
	
	public static Profile getProfileInstance() {
		Profile profile = new Profile();
		profile.setDesignation("Tech Mentor");
		profile.setExperience(3);
		profile.setLocation("Hyderabad");
		
		ArrayList<SkillDetails> skillDetilsList = new ArrayList<SkillDetails>();
		SkillDetails skillDetails1=new SkillDetails();
		skillDetails1.setVersion("8");
		skillDetails1.setSkillExperience(2);
		skillDetails1.setKnowledgeLevel(Knowledge.Expert);
		
		SkillDetails skillDetails2=new SkillDetails();
		skillDetails2.setVersion("6");
		skillDetails2.setSkillExperience(1);
		skillDetails2.setKnowledgeLevel(Knowledge.Intermediate);
		
		skillDetilsList.add(skillDetails1);
		skillDetilsList.add(skillDetails2);
		
		profile.setSkillDetailsList(skillDetilsList);
		
		return profile;
	}

}
