package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.UserService;
import kodlamaio.hrmsProject.core.Messages;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.core.utilities.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.UserDao;
import kodlamaio.hrmsProject.entities.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> findUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getUserByEmail(email));
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.USER_ADDED);
	}
	
	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.USER_UPDATED);
	}
	
	@Override
	public Result delete(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.USER_DELETED);
	}

}
