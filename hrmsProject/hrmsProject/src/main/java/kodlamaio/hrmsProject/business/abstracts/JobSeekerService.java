package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	
	Result registerJobSeeker(JobSeeker jobSeeker);
	Result add(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);
	
	Result getJobSeekerByNationalityNumber(String nationalityNumber);
	
}
