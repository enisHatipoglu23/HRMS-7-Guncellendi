package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer  );
    Result update(Employer employer);
    Result delete(Employer employer);

	
}
