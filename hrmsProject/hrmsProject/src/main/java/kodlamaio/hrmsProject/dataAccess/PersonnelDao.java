package kodlamaio.hrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.Personnel;

public interface PersonnelDao extends JpaRepository<Personnel, Integer>{

}
