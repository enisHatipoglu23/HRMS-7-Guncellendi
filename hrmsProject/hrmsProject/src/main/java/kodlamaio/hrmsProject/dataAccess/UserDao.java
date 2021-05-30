package kodlamaio.hrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User getUserByEmail(String email);

}
