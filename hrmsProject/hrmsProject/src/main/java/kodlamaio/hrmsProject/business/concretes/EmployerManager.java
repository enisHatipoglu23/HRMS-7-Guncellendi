package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.abstracts.UserService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.core.verification.VerificationService;
import kodlamaio.hrmsProject.dataAccess.EmployerDao;
import kodlamaio.hrmsProject.entities.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerificationService verificationService;
	private UserService userService;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, VerificationService verificationService, UserService userService) {
		
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
		this.userService = userService;
	
	}

	@Override
	public Result registerEmployer(Employer employer) {

		if(!checkIfNullValue(employer)) {
			
			return new ErrorResult(Messages.EMPLOYER_NULL_ERROR);
		
		}
		
		if(!checkIfSameEmailAndDomain(employer.getEmail(), employer.getWebsiteAdress())) {
			
			return new ErrorResult(Messages.EMPLOYER_EMAIL_ERROR);
					
		}
		
		if(!checkIfEmailExist(employer.getEmail())) {
			
			return new ErrorResult(employer.getEmail() + Messages.EMPLOYER_EMAIL_EXIST_ERROR);
		
		}
		
		
		verificationService.sendEmail(employer.getEmail());
		employerDao.save(employer);
		userService.add(employer);
		return new SuccessResult(Messages.EMPLOYER_REGISTIRATION_COMPLETED);
	
	}

	
	

	private boolean checkIfEmailExist(String email) {
		
		if(this.userService.findUserByEmail(email).getData() != null ) {
			
			return false;
		
		}
		
		return true;
	
	}

	private boolean checkIfSameEmailAndDomain(String email, String websiteAdress) {
		
		String[] emailArr = email.split("@",2);
		String domain = websiteAdress.substring(4, websiteAdress.length());
		
		if (emailArr[1].equals(domain)) {
			
			return true;
		
		}
		
		return false;
		
		
	}

	private boolean checkIfNullValue(Employer employer) {
		
		if(employer.getEmail() == null &&
				employer.getCompanyName() == null &&
				employer.getPassword() == null &&
				employer.getWebsiteAdress() == null &&
				employer.getPhoneNumber() == null) {
			
			return false;
		
		}
		
		
		return true;
	}

	@Override
	public Result add(Employer employer) {
		
		verificationService.sendEmail(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_ADDED);
	
	}
	
	
	



	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.EMPLOYER_LISTED);
	
	}


	@Override
	public Result delete(Employer employer) {
		
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_DELETED);
	
	}


	

	
	
	
	
	
	
}

	