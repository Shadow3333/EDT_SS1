package manager;

import java.util.ArrayList;
import java.util.List;

import models.AbstractUser;
import models.User;

public class UserManager {
	
	User user = new User();
	List<User> users = new ArrayList<User>();
	
	public void add (AbstractUser user){
		User useTempo = new User();
		useTempo.copy(user);
		users.add(useTempo);
	}

	public void delete (User user){
		users.remove(user);
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User find(){return null;}
	
}
