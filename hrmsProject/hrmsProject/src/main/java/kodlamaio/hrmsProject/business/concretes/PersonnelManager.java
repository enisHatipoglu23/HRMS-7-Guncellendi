package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.PersonnelService;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.PersonnelDao;
import kodlamaio.hrmsProject.entities.Personnel;

@Service
public class PersonnelManager implements PersonnelService{

	private PersonnelDao personnelDao;
	
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public DataResult<List<Personnel>> getAll() {
		return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll());
	}

}
