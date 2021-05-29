package kodlamaio.hrmsProject.core.verification;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public Result sendEmail(String email) {
		
		return new SuccessResult(
				"Verification mail has been send to ::: "
		+ email + "\n Click the link and verify your account. \n "
				+ "\n Your account is ready to log in. ");
	
	}

}
