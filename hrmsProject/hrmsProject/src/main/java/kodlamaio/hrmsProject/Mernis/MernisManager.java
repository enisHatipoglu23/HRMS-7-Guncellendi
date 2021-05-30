package kodlamaio.hrmsProject.Mernis;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class MernisManager {

	public boolean ifValidPerson(String firstName, String lastName, String nationalityNumber, Date birthDate) {
		
		System.out.println(firstName + " " + lastName + "person is valid. ");
		return true;
	}
	
}
