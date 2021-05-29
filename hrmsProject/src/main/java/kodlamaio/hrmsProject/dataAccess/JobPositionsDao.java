package kodlamaio.hrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions, Integer>{

	JobPositions getByJob(String job);
	
}
