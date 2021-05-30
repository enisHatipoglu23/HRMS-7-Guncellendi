package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.JobPositions;

public interface JobPositionsService {

	DataResult<List<JobPositions>> getAll();
	DataResult<JobPositions> getByPosition(String job);
	
	Result add(JobPositions jobPositions);
	
	
	
}
