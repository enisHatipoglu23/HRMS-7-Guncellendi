package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.User;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<User> findUserByEmail(String email);
	
	Result add(User user);
	Result update(User user);
	Result delete(User user);
	
}
