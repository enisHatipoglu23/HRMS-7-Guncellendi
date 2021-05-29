package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.Employer;
import kodlamaio.hrmsProject.entities.JobSeeker;

public interface AuthService {

	Result registerEmployer(Employer employer);
	Result registerJobSeeker(JobSeeker jobSeeker);
	
}
