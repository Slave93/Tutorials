package kom.slavko.tutorials.spring.springMVC.service;

import java.util.List;

import kom.slavko.tutorials.spring.springMVC.dao.Offer;
import kom.slavko.tutorials.spring.springMVC.dao.OffersDao;
import kom.slavko.tutorials.spring.springMVC.dao.User;
import kom.slavko.tutorials.spring.springMVC.dao.UsersDao;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {
UsersDao usersDao;
	
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}	

	public void create(User user) {
		usersDao.create(user);
	}

	public boolean userExists(String username) {
		return usersDao.exists(username);
	}

	
}
