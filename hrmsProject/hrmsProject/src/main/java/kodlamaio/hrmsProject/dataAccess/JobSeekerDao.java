package kodlamaio.hrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	JobSeeker getByNationalityNumber(String nationalityNumber);

}
