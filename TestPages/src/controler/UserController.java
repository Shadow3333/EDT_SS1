package controler;

import java.util.ArrayList;
import java.util.List;

import manager.UserManager;
import models.User;

public class UserController {
	
	UserManager userM = new UserManager();
	User user = new User();
	
	List<User> users = new ArrayList<User>();
	
	public UserController(){
		users = userM.findAll();
	}
	
	public void save(User user){
		this.user = user;
		userM.add(user);
	}
	
	public void remove(User user){
		userM.delete(user);
	}
	
	

	
}
