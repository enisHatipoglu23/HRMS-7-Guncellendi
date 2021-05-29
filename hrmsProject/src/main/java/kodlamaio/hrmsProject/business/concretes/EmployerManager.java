package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.EmployerDao;
import kodlamaio.hrmsProject.entities.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.EMPLOYER_LISTED);
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_ADDED);
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_UPDATED);
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_DELETED);
	}
	
	
	
	
	
	
	
}

	