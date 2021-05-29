package kodlamaio.hrmsProject.business.concretes;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.AuthService;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.abstracts.UserService;
import kodlamaio.hrmsProject.core.CheckService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.core.verification.VerificationService;
import kodlamaio.hrmsProject.entities.Employer;
import kodlamaio.hrmsProject.entities.JobSeeker;

@Service
public class AuthManager implements AuthService{

	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private CheckService checkService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(
			UserService userService, EmployerService employerService,
			JobSeekerService jobSeekerService,
			CheckService checkService, VerificationService verificationService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.checkService = checkService;
		this.verificationService = verificationService;
	}

	@Override
	public Result registerEmployer(Employer employer) {
		
		if(!checkIfNullValueInEmployer(employer)) {
			return new ErrorResult(Messages.EMPLOYER_NULL_ERROR);
		}
		
		if(!checkIfSameEmailAndDomain(employer.getEmail(), employer.getWebsiteAdress())) {
			return new ErrorResult(Messages.EMPLOYER_EMAIL_ERROR);
		}
		
		if(!checkIfEmailExist(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + Messages.EMPLOYER_EMAIL_EXIST_ERROR);
		}
		
		verificationService.sendEmail(employer.getEmail());
		employerService.add(employer);
		return new SuccessResult(Messages.EMPLOYER_REGISTIRATION_COMPLETED);
	}
	
	private boolean checkIfNullValueInEmployer(Employer employer) {
		
		if(employer.getEmail() == null &&
				employer.getCompanyName() == null &&
				employer.getPassword() == null &&
				employer.getWebsiteAdress() == null &&
				employer.getPhoneNumber() == null
				) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkIfSameEmailAndDomain(String email, String webSiteAdress) {
		
		String[] emailArr = email.split("@",2);
		String domain = webSiteAdress.substring(4, webSiteAdress.length());
		
		if (emailArr[1].equals(domain)) {
			return true;
		}
		return false;
		
	}
	

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) {
		
		if(checkIfRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalityNumber(), jobSeeker.getBirthDate()) == false) {
			return new ErrorResult(Messages.MERNIS_VERIFICATION_ERROR) ;
			}
			
		
		if(!checkIfNullValueInJobSeeker(jobSeeker)) {
			return new ErrorResult(Messages.JOB_SEEKER_NULL_ERROR);
			}
		
		if(!checkIfExistNationalityNumber(jobSeeker.getNationalityNumber())) {
			return new ErrorResult(Messages.JOB_SEEKER_NATIONALITY_NUMBER_ERROR);
			}
		
		if(!checkIfEmailExist(jobSeeker.getEmail())) {
			return new ErrorResult(Messages.JOB_SEEKER_EMAIL_ERROR);
		}
		
		verificationService.sendEmail(jobSeeker.getEmail());
		jobSeekerService.add(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_REGISTIRATION_COMPLETED);
		
		}
	
	
	private boolean checkIfRealPerson(String firstName, String lastName, String nationalityNumber, Date birthDate) {
		if(checkService.checkIfRealPerson(firstName, lastName, nationalityNumber, birthDate)) {
			return true;
		}
		
		return false;
		
	}
	
	private boolean checkIfNullValueInJobSeeker(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName() == null &&
			jobSeeker.getLastName() == null &&
			jobSeeker.getNationalityNumber() == null &&
			jobSeeker.getEmail() == null &&
			jobSeeker.getPassword() == null) {
			return false;
		}
		
		return true;
	}
	
	
	private boolean checkIfExistNationalityNumber(String nationalityNumber) {
		
		if(this.jobSeekerService.getJobSeekerByNationalityNumber(nationalityNumber).getData() == null) {
			return true;
		}
		
		return false;
		
	}
	
	private boolean checkIfEmailExist(String email) {
		if (this.userService.findUserByEmail(email).getData() == null) {
			return true;
		}
		
		return false;
	}
	
}
		
	
