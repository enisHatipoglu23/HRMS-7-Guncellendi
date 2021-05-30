package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.entities.Personnel;

public interface PersonnelService {

	DataResult<List<Personnel>> getAll();
	
}
