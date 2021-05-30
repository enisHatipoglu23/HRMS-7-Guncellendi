package kodlamaio.hrmsProject.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.abstracts.UserService;
import kodlamaio.hrmsProject.core.CheckService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.core.verification.VerificationService;
import kodlamaio.hrmsProject.dataAccess.JobSeekerDao;
import kodlamaio.hrmsProject.entities.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private VerificationService verificationService;
	private CheckService checkService;
	private UserService userService;

	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationService verificationService,
			CheckService checkService, UserService userService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.verificationService = verificationService;
		this.checkService = checkService;
		this.userService = userService;

	}



	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}


	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) {

		if(checkIfRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getNationalityNumber(), jobSeeker.getBirthDate()) == false) {
			
			return new ErrorResult(Messages.MERNIS_VERIFICATION_ERROR);
			
		}
		
		if(!checkIfNullValue(jobSeeker)) {
			
			return new ErrorResult(Messages.JOB_SEEKER_NULL_ERROR);
			
		}
		
		//if(!checkIfExistNationalityNumber(jobSeeker.getNationalityNumber())) {
		//	return new ErrorResult(Messages.JOB_SEEKER_NATIONALITY_NUMBER_ERROR);
		//	}
		
		
		if(!checkIfEmailExist(jobSeeker.getEmail())) {
			return new ErrorResult(Messages.JOB_SEEKER_EMAIL_ERROR);
			}
		

		verificationService.sendEmail(jobSeeker.getEmail());
		jobSeekerDao.save(jobSeeker);
		userService.add(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_REGISTIRATION_COMPLETED);
	}
	
	
	private boolean checkIfEmailExist(String email) {
		
			if (this.userService.findUserByEmail(email).getData() == null) {
			return true;
				}

			return false;
		}

	//private boolean checkIfExistNationalityNumber(String nationalityNumber) {
	
		//if(checkIfExistNationalityNumber(nationalityNumber) == jobSeekerDao.) {
		//	return false;
		//}
		
		//return true;

	//}
			

	private boolean checkIfNullValue(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName() == null &&
				jobSeeker.getLastName() == null &&
				jobSeeker.getNationalityNumber() == null &&
				jobSeeker.getEmail() == null &&
				jobSeeker.getPassword() == null) {
			
			return false;
			
		}
		
		return true;
		
	}
		
			
	

	private boolean checkIfRealPerson(String firstName, String lastName, String nationalityNumber, Date birthDate) {
		if(checkService.checkIfRealPerson(firstName, lastName, nationalityNumber, birthDate)) {
			return true;
		}
		return false;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(jobSeeker.getFirstName() == null &&
				jobSeeker.getLastName() == null &&
				jobSeeker.getNationalityNumber() == null &&
				jobSeeker.getEmail() == null &&
				jobSeeker.getPassword() == null) {
			return new ErrorResult(Messages.JOB_SEEKER_NULL_ERROR);
		}
		else if(checkService.checkIfRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getNationalityNumber(), jobSeeker.getBirthDate()) == false) {
			return new ErrorResult(Messages.MERNIS_VERIFICATION_ERROR);
		}
		
		
		this.verificationService.sendEmail(jobSeeker.getEmail());
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_ADDED);
	}


	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_DELETED);
	}



	@Override
	public Result getJobSeekerByNationalityNumber(String nationalityNumber) {
		if(this.jobSeekerDao.getByNationalityNumber(nationalityNumber) != null) {
			return new ErrorResult(Messages.JOB_SEEKER_NATIONALITY_NUMBER_ERROR);
		}
		return new SuccessResult("done. ");
	}



	

	


}
