package manager;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserManager {
	
	User user = new User();
	List<User> users = new ArrayList<User>();
	
	public void add (User user){
		users.add(user);
	}

	public void delete (User user){
		users.remove(user);
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User find(){return null;}
	
}
