package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobPositionsService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.JobPositionsDao;
import kodlamaio.hrmsProject.entities.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService{

	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>(this.jobPositionsDao.findAll(), Messages.JOB_POITION_LISTED);
	}

	@Override
	public DataResult<JobPositions> getByPosition(String job) {
		return new SuccessDataResult<JobPositions>(this.jobPositionsDao.getByJob(job));
	}

	@Override
	public Result add(JobPositions jobPositions) {
		return new SuccessResult(Messages.JOB_POSITION_ADDED);
	}

}
