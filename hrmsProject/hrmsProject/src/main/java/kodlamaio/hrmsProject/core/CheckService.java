package kodlamaio.hrmsProject.core;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public interface CheckService {

	boolean checkIfRealPerson(String firstName, String lastName, String nationalityNumber, Date birthDate );
	
	
	
}
