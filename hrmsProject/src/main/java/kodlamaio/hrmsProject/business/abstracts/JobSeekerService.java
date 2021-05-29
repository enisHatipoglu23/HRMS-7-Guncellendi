package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getJobSeekerByNationalityNumber(String nationalityNumber);
	
	Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);

	
}
