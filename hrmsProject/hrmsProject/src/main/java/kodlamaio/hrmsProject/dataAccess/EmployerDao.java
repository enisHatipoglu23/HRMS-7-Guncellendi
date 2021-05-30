package kodlamaio.hrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
}
