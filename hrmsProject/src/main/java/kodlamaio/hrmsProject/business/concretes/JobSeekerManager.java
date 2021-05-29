package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.JobSeekerDao;
import kodlamaio.hrmsProject.entities.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByNationalityNumber(String nationalityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByNationalityNumber(nationalityNumber));
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_ADDED);
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_UPDATED);
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_DELETED);
	}

}
