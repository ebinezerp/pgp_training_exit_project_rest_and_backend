package pgp.skillmapper.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pgp.skillmapper.backend.model.Skill;
import pgp.skillmapper.backend.service.SkillService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SkillController {
	
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skill")
	public ResponseEntity<List<Skill>> getSkills() {
		return new ResponseEntity<List<Skill>>(skillService.getSkills(),HttpStatus.OK);
	}

}
