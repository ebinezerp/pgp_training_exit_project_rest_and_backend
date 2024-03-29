package pgp.skillmapper.backend;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import pgp.skillmapper.backend.model.Profile;
import pgp.skillmapper.backend.model.SkillDetails;
import pgp.skillmapper.backend.service.ProfileService;
import pgp.skillmapper.backend.service.SkillDetailsService;
import pgp.skillmapper.backend.util.ProfileUtility;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = BackendApplication.class)
public class AddProfileTest {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private SkillDetailsService skillDetailsService;

	private Profile profile;

	@Before
	public void setup() {
		profile = ProfileUtility.getProfileInstance();
	}

	@After
	public void tearDown() {

		if (profileService.getProfile(profile.getId()) != null) {
			for (SkillDetails skillDetails : profile.getSkillDetailsList()) {
				skillDetailsService.delete(skillDetails);
			}
			profileService.delete(profile);
		}

	}
	
	@Test
	public void addProfileTest() {
		assertNotNull(profileService.save(profile));
	}
}
