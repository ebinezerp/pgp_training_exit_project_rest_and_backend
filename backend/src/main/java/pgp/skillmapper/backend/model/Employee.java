package pgp.skillmapper.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "First name Should not be null")
	@NotBlank(message = "First name should not be empty")
	@Size(min = 4, message = "Min 4 characters")
	@Pattern(regexp = "^[a-zA-Z]{4,}$", message = "Min 3 characters, Only alphabet are allowed")
	@Column(nullable = false)
	private String firstname;
	
	@NotNull(message = "Last name Should not be null")
	@NotBlank(message = "Last name should not be empty")
	@Size(min = 4, message = "Min 4 characters")
	@Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Min 4 characters, Only alphabet are allowed")
	@Column(nullable = false)
	private String lastname;
	
	@NotNull(message = "Email should not be null")
	@NotBlank(message = "Email should not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,63}$", message = "Enter a valid email")
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotNull(message = "Mobile should not be null")
	@NotBlank(message = "Mobile should not be empty")
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Enter valid mobile number")
	@Column(nullable = false, unique = true)
	private String mobile;
	
	
	@NotNull(message = "Username should not be null")
	@NotBlank(message = "Username should not be empty")
	@Pattern(regexp = "^[a-z0-9]{5,10}$", message = "Min 5 and Max 10 characters. Only small alphabet and numeric are allowed")
	@Column(nullable = false, unique = true)
	private String username;
	
	
	@NotBlank(message = "Password should not be empty")
	@NotNull(message = "Password should not be null")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should Contain atleast 8 characters with atleast one Capital, one small alphabet, one digit and one special character")
	@Column(nullable = false)
	private String password;
	
	@NotBlank(message = "Role should not be empty")
	@NotNull(message = "Role should not be null")
	@Column(nullable = false)
	private String role;
	
	
	@NotNull(message = "Enabled value should not be null")
	@Column(nullable = false)
	private boolean enabled;

	@OneToOne(mappedBy = "employee")
	private Profile profile;
}
