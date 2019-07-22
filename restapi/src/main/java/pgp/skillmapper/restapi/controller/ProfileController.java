package pgp.skillmapper.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pgp.skillmapper.backend.model.Employee;
import pgp.skillmapper.backend.model.Profile;
import pgp.skillmapper.backend.model.Skill;
import pgp.skillmapper.backend.model.SkillDetails;
import pgp.skillmapper.backend.service.EmployeeService;
import pgp.skillmapper.backend.service.ProfileService;
import pgp.skillmapper.backend.service.SkillDetailsService;
import pgp.skillmapper.backend.service.SkillService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillDetailsService skillDetailsService;

	@Autowired
	private SkillService skillService;

	@PostMapping("/profile")
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile, @RequestParam("id") Long employeeId) {

		System.out.println(profile);
		profile.setEmployee(employeeService.getEmployee(employeeId));
		for (SkillDetails skillDetails : profile.getSkillDetailsList()) {
			System.out.println(skillDetails);
			skillDetails.setProfile(profile);
			Skill skill = skillDetails.getSkill();
			skill.setSkillDetails(skillDetails);
		}

		System.out.println(profile);

		profileService.save(profile);

		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getProfile(@PathVariable("id") Long id) {
		return new ResponseEntity<Profile>(profileService.getProfileByEmployeeId(id), HttpStatus.OK);
	}

	@GetMapping("/profile/search")
	public ResponseEntity<List<Profile>> search(@RequestParam("location") String location,
			@RequestParam("skills") List<String> skills) {
         System.out.println(skills);
         if(skills.size()<=0) {
        	 skills=null;
         }
		return new ResponseEntity<List<Profile>>(profileService.search(skills, location), HttpStatus.OK);

	}

}
