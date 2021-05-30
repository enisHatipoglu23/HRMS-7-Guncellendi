package kodlamaio.hrmsProject.core.adapters;

import java.sql.Date;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.Mernis.MernisManager;
import kodlamaio.hrmsProject.core.CheckService;

@Service
public class MernisAdapterManager implements CheckService{

	@Override
	public boolean checkIfRealPerson(String firstName, String lastName, String nationalityNumber, Date birthDate) {

		MernisManager mernisManager = new MernisManager();
		
		boolean result = mernisManager.ifValidPerson(firstName, lastName, nationalityNumber, birthDate);
		
		if(!result) {
			System.out.println("Person is not valid ! ");
		}
		return false;
	}

}
